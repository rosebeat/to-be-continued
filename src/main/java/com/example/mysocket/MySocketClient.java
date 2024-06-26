package com.example.mysocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: kai·yang
 * @Date: 2024/4/12 10:21
 * @Description:
 *
 */
public class MySocketClient {


    public static final String HOST = "127.0.0.1";

    public static final int PORT = 8899;


    public static void main(String[] args) throws IOException, InterruptedException {
        client();
    }

    public static void client() throws IOException, InterruptedException {

        Socket client = new Socket(HOST, PORT);
        OutputStream outputStream = client.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        for (int i =1; i < 11; i++ ){
            writer.write("hello socket ");
            writer.flush();
        }

        writer.close();
        client.close();

    }


}
