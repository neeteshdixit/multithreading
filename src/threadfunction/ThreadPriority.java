package threadfunction;

public class ThreadPriority extends Thread{

    public ThreadPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <5; i++) {

            System.out.println(Thread.currentThread().getName() + "-priority :" + Thread.currentThread().getPriority() + " count " + i);
            Thread.yield();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority l = new ThreadPriority("Neetesh low");
        ThreadPriority m = new ThreadPriority("Neetesh medium");
        ThreadPriority h = new ThreadPriority("Neetesh high");


        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}
