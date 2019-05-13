package com.imooc.utils.test1;

import java.util.concurrent.*;

public class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(12);
        //创建12个线程
        for(int i=0; i < 12;i++){
            Future<String> future = service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String element = queue.take();
                    return "消费者消费: " + element;
                }
            });

            try{
                System.out.println(future.get());
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }

            service.shutdown();

        }
    }

}
