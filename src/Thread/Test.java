package Thread;

public class Test {
    public static void main(String[] args) {
//        System.out.println("hello");
//        System.out.println(Thread.currentThread().getName());
//        World world = new World();
        World world1 = new World(); // new
        Thread t1 = new Thread(world1);
        t1.start();// runnable
        //world.start();
        for (; ; ) {
            System.out.println("World");
        }
    }
}
