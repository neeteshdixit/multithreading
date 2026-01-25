package lock;

public class Test {

    public static void main(String[] args) {
        BankSystem ba = new BankSystem();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                ba.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"thread 1");
        Thread t2 = new Thread(task,"thread 2");
        t1.start();
        t2.start();

    }
}
