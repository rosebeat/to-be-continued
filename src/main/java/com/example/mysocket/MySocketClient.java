package com.example.mysocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: kai·yang
 * @Date: 2024/4/12 10:21
 * @Description:
 *
 */
public class MySocketClient {

    public static final int PORT = 8899;


    /**
     * 测试 socket server
     * @param args
     */
    public static void main(String[] args) {

    }


    /**
     *
     */
    public static void serverV1() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        //server 尝试接收其他socket的连接请求。 server的accept是阻塞的
        Socket accept = server.accept();
        //建立好和客户端的连接，就可以通过 socket 的 InputStream 读取客户端发过来的消息
        InputStream inputStream = accept.getInputStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
        while( (temp = bufferedReader.readLine()) != null){
            sb.append(temp);
        }
        System.out.println("server receive: " + sb.toString());
        bufferedReader.close();
        inputStream.close();
        accept.close();

    }

}
