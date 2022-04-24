package ru.tpu.threading;

public class Storage {
    private int products;
    private int maxProducts;

    public Storage(int maxProducts) {
        this.products = 0;
        this.maxProducts = maxProducts;
    }

    public synchronized void consume() {
        while (products <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println(Thread.currentThread().getName() + ": Item consumed. Products: " + products);
        notify();
    }

    public synchronized void produce() {
        while (products >= maxProducts) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products++;
        System.out.println(Thread.currentThread().getName() + ": Item produced. Products: " + products);
        notify();
    }

    public int getMaxProducts() {
        return maxProducts;
    }

    public void setMaxProducts(int maxProducts) {
        this.maxProducts = maxProducts;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }


}
