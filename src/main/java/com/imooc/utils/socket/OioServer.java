package com.imooc.utils.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OioServer {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建socket服务,监听10101端口
        try {
            ServerSocket server = new ServerSocket(10101);
            while (true) {
                final Socket socket = server.accept();
                System.out.println("来一个新客户端!");
                newCachedThreadPool.execute(new Runnable() {

                    @Override
                    public void run() {
                        //业务处理
                        handler(socket);
                    }

                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务器启动!");


    }

    private static void handler(Socket socket) {

        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();

            while(true){
                //读取数据(阻塞)
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println(new String(bytes,0,read));
                }else{
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                System.out.println("socket关闭");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}


