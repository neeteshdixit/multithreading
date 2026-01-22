package synchronization;

public class Test {

    public static void main(String[] args) {
        Counter c = new Counter();
        Mythread mt1 = new Mythread(c);
        Mythread mt2 = new Mythread(c);
        mt1.start();
        mt2.start();

        try{
            mt1.join();
            mt2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(c.getCount());
    }
}
