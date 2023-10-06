package TCP_IP.example01_ByteStream;

/*
TCP/IP网络通信编程
1.基于客户端——服务端的网络通信
2.底层使用的是TCP/IP协议
3.应用场景举例：客户端发送数据，服务端接收并显示
4.基于Socket的TCP编程

 */
/*
题目要求：
1.编写一个服务器端和一个客户端
2.服务端在9999端口监听
3.客户端连接到服务器端，发送"hello,server!"，然后退出
4.服务器端接收到客户端发送的信息，输出并退出

思路:

客户端：                           服务器端：
1.连接服务器IP(需要IP和端口)        1.在本机的9999端口监听，等待连接（当没有客户端连接时，程序会阻塞，等待连接）
2.连接后生成Socket                 2.通过socket.getInputStream() 读取客户端写入到数据通道并显示
  socket.getOutputStream()
3.通过该输出流，写入数据到
  数据通道

 */
public class example01 {
    public static void main(String[] args) {



    }
}
