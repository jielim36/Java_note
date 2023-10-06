package example01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
InetAddress介绍：
1.该类实现了Serializable，可以序列化
2.
 */
public class example01 {
    public static void main(String[] args) throws UnknownHostException {

        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("根据getLocalHost获取本机信息："+localHost);//jielim36/192.168.100.28   计算机名称+IP地址

        //2.根据指定的主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("jielim36");
        System.out.println("根据主机名称获取IP："+host1);//jielim36/192.168.100.28

        //3. 根据域名获取InetAddress , 比如 www.baidu.com
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("Baidu地址返回 ：" + host2);//www.baidu.com/45.113.192.101

        //4. 通过InetAddress对象，获取对应的地址和主机名
        String hostAddress = host2.getHostAddress();
        String hostAddress2 = host2.getHostName();
        System.out.println("百度的IP地址：" + hostAddress);
        System.out.println("百度的主机名/域名：" + hostAddress2);

    }
}
