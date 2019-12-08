package com.yx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yx start
 * @create 2019/12/8,14:59
 */
public class NIOSocketServer {

    public static void main(String[] args) throws IOException {
        // 1.创建主入口 管家
        Selector selector = Selector.open();
        // 2.创建将channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             // 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(1234));
             //  设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 3. 注册到 管家
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while(true){
            int readChannelNum = selector.select(); // 有多少channel准备就绪
            if(readChannelNum == 0){
                continue;
            }

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
         while(iterator.hasNext()){
             SelectionKey selectionKey = iterator.next();

           // 请求的 key当前状态
            if( selectionKey.isAcceptable()){
                // 表示准备就绪。这个channel该干啥？
                SelectableChannel channel = selectionKey.channel();
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) channel;
                SocketChannel accept = serverSocketChannel1.accept();
                accept.configureBlocking(false) ;// 设置不阻塞
                accept.register(selector,SelectionKey.OP_READ);
            }else if(selectionKey.isReadable()){ // 可读
                    // 执行其他操作
                    // 具体的业务事情
            }else if(selectionKey.isWritable()){ //可写

            }else if(selectionKey.isConnectable()){ //可连接

            }
             iterator.remove();

         }

    } }

}
