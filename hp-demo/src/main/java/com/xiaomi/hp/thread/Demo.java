package com.xiaomi.hp.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Demo {
	
	public static void main(String[] args){

        int count = 3;
        CountDownLatch latch = new CountDownLatch(count);

        long start = System.currentTimeMillis();
        for (int i = 0;i<count;i++) {
            Thread thread = new Thread(new TestThread(latch));
            thread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("time: " + (System.currentTimeMillis() - start));

    }

    public static class TestThread implements Runnable {

        private CountDownLatch latch;

        public TestThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println("start " + Thread.currentThread().getName());
            Random random = new Random();
            try {
                int time = random.nextInt(5000000);
                System.out.println("" + Thread.currentThread().getName() + " sleep time: " + time);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end " + Thread.currentThread().getName() + ", cost: " + (System.currentTimeMillis() - start));
            latch.countDown();
        }
    }
	
}
