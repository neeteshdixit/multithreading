package Thread;

public class World extends Thread{
    @Override
    public void run() {
        super.run();
        for (; ;) {
            System.out.println("Hello");
        }
    }
}
