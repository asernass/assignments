package assignments;

public class Assignment2 {

    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 2;

        System.out.println("Deadlock example starts");

        Runnable t1 = new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (i1) {
                        Thread.sleep(100);
                        synchronized (i2) {
                            System.out.println("Thread 1 is running");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };

        Runnable t2 = new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (i2) {
                        Thread.sleep(100);
                        synchronized (i1) {
                            System.out.println("Thread 2 is running");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };

        new Thread(t1).start();
        new Thread(t2).start();
        System.out.println("Deadlock ends");
    }

}
