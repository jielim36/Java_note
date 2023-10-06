package Set.HastSet.example02;
/*
HashSet的底层是HashMap，HashMap底层是（数组+链表+红黑树）
 */
public class example02 {
    public static void main(String[] args) {
        //模拟一个HashMap的底层结构(数组+单向链表)
        //创建一个Node类型数组
        Node [] table = new Node[16];//有些人直接把Node[] 数组称为table表
        System.out.println("table:"+table);

        //创建节点
        Node john = new Node("john",null);

        //要求把john放在table的索引位置2上
        table[2] = john;

        Node jack = new Node("jack",null);//创建新节点
        john.next = jack;//将jack节点挂载到john（john的右边连接了jack，也就是说table数组的索引2是一个链表）

        Node rose = new Node("rose",null);
        jack.next = rose;
        //由此在table数组索引2有了一个以 john->jack->rose 形成的链表（不是双向链表，是单向）

        Node lucy = new Node("lucy",null);
        table[3] = lucy;


    }
}

class Node{ //Node节点，存储数据，可以指向下一个节点，从而执行链表
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}