package com.example.mysocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author: kai·yang
 * @Date: 2024/4/12 10:21
 * @Description:
 *
 */
public class MySocketClient2 {


    public static final String HOST = "127.0.0.1";

    public static final int PORT = 8899;


    public static void main(String[] args) throws IOException, InterruptedException {
        client();
    }

    public static void client() throws IOException, InterruptedException {

        Socket client = new Socket(HOST, PORT);
        OutputStream outputStream = client.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        for (int i =1; i < 21; i++ ){
            writer.write("hello socket I`M client two, time: " + i);
            writer.write("\r\n");
            writer.flush();
            Thread.sleep(1000);
        }
        writer.close();
        client.close();

    }


}
