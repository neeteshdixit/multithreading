package lock;

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " your balance is " + balance);

        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + " processing your cash ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }

            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " your balance is after withdrawing " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance your balane is " + balance);
        }
    }
}
