interface NotificationSystem {
    void sendNotification();
}

class WhatsApp implements NotificationSystem {

    @Override
    public void sendNotification() {
        System.out.println("Sending WhatsApp notification");
    }
}

class MailNotification implements NotificationSystem {

    @Override
    public void sendNotification() {
        System.out.println("Sending Email notification");
    }
}

class NotificationFactory {

    public static NotificationSystem createNotificationSystem(String type) {

        if (type.equalsIgnoreCase("Email")) {
            return new MailNotification();
        }
        else if (type.equalsIgnoreCase("WhatsApp")) {
            return new WhatsApp();
        }

        throw new IllegalArgumentException("Invalid notification type: " + type);
    }
}

public class Factory {

    public static void main(String[] args) {

        NotificationSystem notificationSystem1 =
                NotificationFactory.createNotificationSystem("Email");

        NotificationSystem notificationSystem2 =
                NotificationFactory.createNotificationSystem("WhatsApp");

        notificationSystem1.sendNotification();
        notificationSystem2.sendNotification();
    }
}