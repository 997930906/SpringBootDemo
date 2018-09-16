package cn.whu.test2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class MyThead extends Thread{
    private int tid;
    public MyThead(int tid){
        this.tid = tid;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(String.format("thread%d: %d",tid,i));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> q;
    public Consumer(BlockingQueue<String> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + q.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {
    private BlockingQueue<String> q;
    public Producer(BlockingQueue<String> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; ++i) {
                Thread.sleep(1000);
                q.put(String .valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiThread {

    public static Object obj = new Object();

    public static void testSynchronized1(){
        synchronized (obj){
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("thread1："+i);
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }
    public static void testSynchronized2(){
        synchronized (obj){
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("thread2："+i);
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void testRunnable() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(String.format("thread,%d:%d", finalI, j));
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void testSync(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int j = 0; j < 5; j++) {
                        testSynchronized1();
                        testSynchronized2();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void testBlockingQueue() {
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(10);
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q), "Consumer1").start();
        new Thread(new Consumer(q), "Consumer2").start();
    }

    public static void testExecutor() {
        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Executor1:" + i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Executor2:" + i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        service.shutdown();
        while (!service.isTerminated()) {
            try {
                Thread.sleep(1000);
                System.out.println("Wait for termination.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int counter = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void testWithoutAtomic(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 10; j++) {
                            Thread.sleep(1000);
                            System.out.println(++counter);
                        }
                    } catch (Exception e ){

                    }
                }
            }).start();
        }
    }

    public static void testWithAtomic(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 10; j++) {
                            Thread.sleep(1000);
                            System.out.println(atomicInteger.incrementAndGet());
                        }
                    } catch (Exception e ){

                    }
                }
            }).start();
        }
    }
    public static void main(String[] args) {
        //第一种方式继承Thread
        /*for (int i = 0; i < 10; i++) {
            new MyThead(i).start();
        }*/
        //第二种，实现Runnable接口
        /*
            testRunnable();
        */

        //测试synchronize
        /*
            testSync();
         */

        //测试blockingQueue
        //testBlockingQueue();

        //线程池
        //testExecutor();


        //atomic测试
        //testWithoutAtomic();
        testWithAtomic();
    }
}
