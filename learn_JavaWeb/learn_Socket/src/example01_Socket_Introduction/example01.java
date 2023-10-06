package example01_Socket_Introduction;
/*
Socket基本介绍：
1.套接字（Socket）开发 网络应用程序被广泛采用，以至于成为事实上的标准
2.通信的两端都要有Socket，是两台机器间通信的端点
3.网络通信其实就是Socket间的通信。
4.Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输
5.一般主动发起通信的应用程序称作“客户端”， 等待通信请求的则称为”服务端“

当我们需要通讯时（读写数据）
1. socket.getOutputStream()
2.socket.getInputStream

比如客户端用socket.getOutputStream发送数据，服务端用socket.getInputStream接收数据
然后服务端又要发送数据给回客户端就socket.getOutputStream发送数据，客户端用socket.getInputStream接收数据

Socket的理解
有TCP协议编程和UDP协议的编程
1.TCP可靠
2.UDP不可靠

注意：客户端和服务端通常情况下是在不同主机的
但是这里学习时，客户端和服务端是在同一台主机

 */
public class example01 {
    public static void main(String[] args) {

    }
}
