# java-io-demo
主要是java-io操作
javaIO流
概念 ：输出输出，java在通信中，向计算机端口写一些数据
BIO 阻塞IO
 NIO  new IO -->非阻塞IO
 AIO 
-- 文件操作--向Xx写入写出
 --  网络流
应用场景：
  -- 物联网 -- 设备-- 服务端进行通信
-- 心跳的通信
-- 及时状态的上报
-- 服务端对客户端的远程操作

BIO阻塞IO高并发情况下会导致性能急剧下降。卡死，内存急涨


NIO工作流程：
thead -> selector ->channel ->buffer -->threadPool（接受请求处理具体业务逻辑）

NIO：new IO，非阻塞IO

可以解决BIO阻塞的不足
比BIO学习和使用复杂
可以用阻塞、非阻塞两种方式工作
在非阻塞的模式下，可以用少量线程（可以一个）线程处理大量的的连接

NIO 和BIO 比较


NIO框架


 ## 后面netty相关演示可以写在这里

相关截图放在百度云笔记
