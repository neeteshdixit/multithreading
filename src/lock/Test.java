package lock;

public class Test {

    public static void main(String[] args) {
//        BankSystem ba = new BankSystem();
        UnFairLock uf = new UnFairLock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                ba.withdraw(50);
                uf.accessResource();
            }
        };
        Thread t1 = new Thread(task,"thread 1");
        Thread t2 = new Thread(task,"thread 2");
        Thread t3 = new Thread(task,"thread 3");
        t1.start();
        t2.start();
        t3.start();


    }
}
