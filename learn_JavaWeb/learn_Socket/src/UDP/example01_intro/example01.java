package UDP.example01_intro;
/*
UDP基本介绍：
1.类DatagramSocket数据包 和 DatagramPacket数据报 实现了基于UDP协议网络程序。
2.UDP数据报通过数据报套接字DatagramSocket发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不确定什么时候可以抵达。

基本流程：
1.核心的两个类/对象 DatagramSocket 和 DatagramPacket
2.建立发送端，接收端
3.建立数据包
4.调用Datagram的发送，接受方法
5.关闭DatagramSocket

说明：
1.UDP没有明确的服务端和客户端，只有->接收端和发送端(双方可以随时变化)
2.接收数据和发送数据是通过DatagramSocket对象完成
3.将数据封装到DatagramPacket对象/装包然后发送
4.然后接收方收到数据后，需要拆包，取出数据

 */
public class example01 {
    public static void main(String[] args) {

    }
}
