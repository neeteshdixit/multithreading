package Thread;

public class MyThread1 extends Thread {

    public MyThread1(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + " priority " + Thread.currentThread().getPriority() + " count " + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 l = new MyThread1("low priority");
        MyThread1 h = new MyThread1("high priority");
        MyThread1 m = new MyThread1("Medium priority");
        l.setPriority(Thread.MIN_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        l.start();
        h.start();
        m.start();
    }
}
