class MyRunnable implements Runnable{

    private int n;

    public MyRunnable(int n){
        this.n = n;
    }

    public void run(){
        go();
    }

    private void go() {
        doMore();
    }

    private void doMore() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getName());

    }
}


public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable(5);
        Thread thread = new Thread(runnable);
        thread.setName("firstThread");
        Thread thread1 = new Thread(runnable);
        thread1.setName("secondThread");
        thread.start();
        thread1.start();




    }
    public static void runManyThreads() throws InterruptedException {
        for(int i=0; i < 10; i++) {
            Runnable threadJob = new MyRunnable(i);
            Thread myThread = new Thread(threadJob);
            myThread.start();
            Thread.sleep(1);
            System.out.println("back in main "+i);

        }
    }
}
