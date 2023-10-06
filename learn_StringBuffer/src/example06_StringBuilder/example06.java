package example06_StringBuilder;
/*
StringBuilder基本介绍：
1.一个可变的字符序列。此类提供一个与StringBuffer兼容的API，但不保证同步（StringBuilder不是线程安全）。
  该类被设计用作StringBuffer的一个简易替换，用在字符串缓冲区被单个线程使用的时候。
  如果使用场景在单线程时，建议优先使用该类。因为大多数实现中，它比StringBuffer要快
2.在StringBuilder上的主要操作是append和insert方法，可以重载这些方法，以接收任意类型的数据。
3.StringBuilder和StringBuffer的常用方法大致相同

细节：
1.StringBuilder是final（不能被继承）
2.继承了AbstractStringBuilder, 属性char [] value,内容存到value
3.实现了Serializable接口，序列化（所谓序列化即可以网络传输，或保存类型和数据本身）
4.字符串/字符序列存放在堆中，因为不是常量
5.StringBuilder的方法没有做互斥的处理，即没有synchronized 关键字，因此在单线程的情况下使用该类

 */
public class example06 {
}
