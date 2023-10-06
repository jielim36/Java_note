package List.zSummary;
/*

Vector和ArrayList的比较

名称               底层结构     版本         线程安全（同步）和效率         扩容倍数
ArrayList         可变数组     jdk1.2        线程不安全，但效率高          如果是有参构造器（指定大小）1.5倍；如果无参第一次初始+10容量，第二次满容量开始按1.5倍扩容
Vector            可变数组     jdk1.0        线程安全，效率不高            如果是无参，默认10，满后，就按2倍扩容；如果指定大小，则每次按两倍扩容

如何选择Vector和ArrayList：如果多线程的情况下使用Vector，否则使用ArrayList（效率高）


ArrayList和 LinkedList的比较

名称             底层结构         增删                改查的效率
ArrayList       可变数组        较低，数组扩容           较高
LinkedList      双向链表        较高，通过链表追加        较低

如何选择ArrayList和LinkList：
1.如果我们改查的操作多，选择ArrayList（LinkedList低是因为查找的时候会从头开始找）
2.如果我们增删的操作多，选择LinkedList
3.一般来说，在程序中，80-90%都是查询，由此大部分情况选择ArrayList
4.在一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是ArrayList，另一个模块使用LinkedList
5.总之还是需要根据项目业务的要求选择使用

 */
public class summary {
    public static void main(String[] args) {

    }
}
