package ru.tpu.threading;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT = 10;

        Storage storage = new Storage(10);

        Runnable consumeTask = () -> {
            while (true) {
                synchronized (storage) {
                    storage.consume();
                }
            }
        };

        Runnable produceTask = () -> {
            while (true) {
                synchronized (storage) {
                    storage.produce();
                }
            }
        };

        for(int i=0; i<THREAD_COUNT; i++) {
            Thread ct = new Thread(consumeTask);
            ct.setName("ConsumerThread"+ i);
            Thread ft = new Thread(produceTask);
            ft.setName("FabricThread"+ i);
            ft.start();
            ct.start();
        }
        Thread.sleep(1000);
    }

}
