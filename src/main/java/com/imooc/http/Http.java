package com.imooc.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xeshen_channelsoft on 2018/7/5.
 */
public class Http {

    public static void main(String[] args) throws IOException {
//        1.
            String path ="https://www.baidu.com/abc";


            URL url = new URL(path);

//        2.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

//        3.
            conn.setRequestMethod("GET");   //设置本次请求的方式 ， 默认是GET方式， 参数要求都是大写字母
            conn.setConnectTimeout(5000);//设置连接超时
            conn.setDoInput(true);//是否打开输入流 ， 此方法默认为true
            conn.setDoOutput(true);//是否打开输出流， 此方法默认为false
            conn.connect();//表示连接



//        4.
            InputStream is = conn.getInputStream();

            String name = path.substring(path.lastIndexOf("/abc")+1);

            System.out.println("name = " + name);


            FileOutputStream fos = new FileOutputStream("D:\\pro\\"+name+".html");

            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = is.read(buffer))!=-1) {

                fos.write(buffer, 0, len);
            }



    }


}
