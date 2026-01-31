package lamdaexpression;

public class LambdaExpression {
    public static void main(String[] args) {

        Runnable runnable = ()->{
            System.out.println("Hello");
        };
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
        Thread t1 = new Thread();
        t1.start();
    }
}
