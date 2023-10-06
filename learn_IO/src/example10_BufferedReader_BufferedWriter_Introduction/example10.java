package example10_BufferedReader_BufferedWriter_Introduction;
/*

节点流 和 处理流

1.节点流可以从一个特定的数据源读写数据，如FileReader , FileWriter

2.处理流（也叫包装流）是”连接“是已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能
  如BufferedReader , BufferedWriter

  -BufferedReader就像是一个可以对节点流FileReader增强的工具，它可以容纳/接受任何Reader抽象基类的子类（类似与int和Integer的关系，Integer有更多的功能）
  -BufferedWriter也同理，可以封装任意一个Writer抽象基类的子类，比如FileWriter
  -BufferedReader和BufferedWriter的原理：他们的源码中有个属性是Writer/Reader抽象基类的对象，比如：
   BufferedReader接受了一个FileReader类型，内部就是一个Reader obj = new FileReader(); 体现了多态
   BufferedReader是体现了一种设计模式：装饰器/修饰器


节点流和处理流的区别和联系
1.节点流是底层流/低级流，直接和数据源相接
2.处理流会包装节点流，即可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输出。
3.处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相接

处理流的功能主要体现以下两方面
1.性能的提高：主要以增加缓冲的方式来提高输入输出的效率
2.操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便



 */
public class example10 {
    public static void main(String[] args) {

    }
}
