package Thread;

public class Demo1 {
    public static void main(String[] args) {
       MyRunnable myRunnable = new MyRunnable();
       Thread myThread = new Thread(myRunnable);
       myThread.start();
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
