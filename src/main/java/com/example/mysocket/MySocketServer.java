package com.example.mysocket;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringJoiner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @author: kai·yang
 * @Date: 2024/4/12 10:20
 * @Description:
 */
@Slf4j
public class MySocketServer {
    public static final int PORT = 8899;


    /**
     * socket 与 socket 直接是双向通信的，所以可以同时接收和发送消息
     *
     * 测试 socket server
     * @param args
     */
    public static void main(String[] args) throws IOException {
        serverV2();
    }


    /**
     *
     */
    public static void serverV1() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        //server 尝试接收其他socket的连接请求。 server的accept是阻塞的
        System.out.println("server starting， waiting Client connection");
        Socket accept = server.accept();
        //建立好和客户端的连接，就可以通过 socket 的 InputStream 读取客户端发过来的消息
        InputStream inputStream = accept.getInputStream();
        StringJoiner sb = new StringJoiner("\n");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
        System.out.println("客户端已连接，等待……");
        while( (temp = bufferedReader.readLine()) != null){
            sb.add(temp);
        }
        System.out.println("server receive: " + sb.toString());
        bufferedReader.close();
        inputStream.close();
        accept.close();

    }

    // 固定大小线程池
    static ExecutorService executor = Executors.newFixedThreadPool(10);
    static AtomicInteger SOCKET_ID = new AtomicInteger(0);

    /**
     * 使用多线程，实现多个客户端连接
     */
    public static void serverV2(){
        try {
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                //阻塞 等待客户端连接
                Socket accept = server.accept();
                int id = SOCKET_ID.incrementAndGet();
                executor.submit(() -> handleClientConnection(accept,id));
            }
        } catch (IOException e) {
            log.error(" created server socket failed ");
            log.error(" Error: ",e);
        }

    }
    public static void handleClientConnection(Socket socket, int socketId){
        log.info(" client: [{}] connected", socketId);
        try (
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream))
                ){
            String line;
            StringJoiner sj = new StringJoiner("\n\t");
            while((line = reader.readLine()) != null){
                sj.add(line);
            }
            System.out.println(("client: ["+socketId+"+] content: ["+sj.toString()+"]"));
        } catch (IOException e) {
            log.error("Exception caught during handling client connection");
            log.error(" Error: ", e);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
