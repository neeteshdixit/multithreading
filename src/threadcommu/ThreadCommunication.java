package threadcommu;

class SharedResources {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResources resource;

    public Producer(SharedResources resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResources resource;

    public Consumer(SharedResources resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.consume();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources sr = new SharedResources();

        Thread producerThread = new Thread(new Producer(sr));
        Thread consumerThread = new Thread(new Consumer(sr));

        producerThread.start();
        consumerThread.start();
    }
}
