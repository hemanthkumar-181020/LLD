import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
//    int count = 0;
//    public synchronized void increase() {
//        count++;
//    }
    AtomicInteger count = new AtomicInteger(0);
    public void increase(){
        count.incrementAndGet();

    }



    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable(){
            public void run() {
                for(int i=0;i<1_000_000;i++){
                    counter.increase();
                }
            }

        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<1_1000_000;i++){
                    counter.increase();
                }
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
