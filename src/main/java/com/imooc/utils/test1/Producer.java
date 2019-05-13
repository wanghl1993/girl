package com.imooc.utils.test1;

import java.util.concurrent.*;

public class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //创建十个生产者
        for(int i = 0;i < 10; i++){
            Future<String> future = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String threadName = Thread.currentThread().getName();
                    queue.put(threadName + ":一条消息");
                    return threadName + "生产了一条消息";
                }
            });

            try{
                System.out.println(future.get());
            }catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }

        }

        service.shutdown();


    }
}
