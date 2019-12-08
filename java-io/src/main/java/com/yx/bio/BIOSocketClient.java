package com.yx.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yx start
 * @create 2019/12/8,15:00
 */
public class BIOSocketClient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        Socket socket = new Socket(host,1234);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("this is bio".getBytes());
    }
}
