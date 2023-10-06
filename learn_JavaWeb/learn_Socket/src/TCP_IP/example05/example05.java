package TCP_IP.example05;
/*
TCP网络通讯的细节：
1.当客户端连接到服务器端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是由TCP/IP来分配的( 不确定/随机的)

无法给予案例，可以尝试使用example04的复制文件去复制一个视频（因为复制耗费时间比较长），在复制过程中使用netstat -an | more
可以看到在显示结果的比较下面的位置可以看到我们服务器端的IP地址+端口 ， 右边的外部连接就会是我们的客户端IP地址+TCP/IP随机分配的端口
比如：
TCP  xxx.xxx.xx.x.9999      xxx.xxx.xx.x.60285  ESTABLISHED  类似这行信息，60285端口是随机的


 */
public class example05 {
    public static void main(String[] args) {



    }
}
