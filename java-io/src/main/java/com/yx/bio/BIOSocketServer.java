package com.yx.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞io
 * @author yx start
 * @create 2019/12/8,15:00
 */
public class BIOSocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        while(true){
            Socket socket = serverSocket.accept();

        /* 这段代码有问题。。。
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            String msg ;
            while((msg = bufferedReader.readLine())!=null){
                System.out.println(msg);
            }
*/
         InputStream inputStream = socket.getInputStream();
            byte[] data = new byte[1024];
            while (true){
                int len =inputStream.read(data)  ;
                while(len>-1){
                    System.out.println(new String(data, 0, len));
                }
             }

        }
    }
}
