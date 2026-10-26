//package Thread;
//
//public class Demo3 {
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            System.out.println("Thread is running " + Thread.currentThread().getName());
//        });
//        t1.start();
//        t1.run();
//    }
//}

package Thread;

public class Demo3 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(
                    "Executing on: " + Thread.currentThread().getName()
            );
        });

        System.out.println("Before start");

        t1.start();

        System.out.println("After start");

        t1.run();

        System.out.println("Main finished");
    }
}
