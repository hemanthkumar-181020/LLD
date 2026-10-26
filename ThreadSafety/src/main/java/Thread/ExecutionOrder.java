package Thread;

public class ExecutionOrder {

        public static void main(String[] args) {

            Thread mainThread = Thread.currentThread();

            Thread t1 = new Thread(() -> {
                System.out.println(
                        "Name of current thread is " +
                                Thread.currentThread().getName()
                );

                System.out.println(
                        "Main thread state " + mainThread.getState()
                );
            });

            System.out.println(t1.getState()); // NEW

            // Runnable stage
            t1.start();

            System.out.println(t1.getState()); // Usually RUNNABLE

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(t1.getState()); // TERMINATED
        }
    }

