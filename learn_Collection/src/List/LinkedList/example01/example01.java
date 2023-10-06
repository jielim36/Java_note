package List.LinkedList.example01;
/*
LinkedList底层结构：
1.LinkedList实现了双向链表和双端队列特点
2.可以添加任意元素（且元素可以重复），包括null
3.线程不安全，没有实现同步

底层操作机制：
1.LinkedList底层维护了一个双向链表
2.LinkedList中维护了两个属性field：first 和 last 分别指向 首节点 和 尾节点
3.每个节点都是Node对象，里面又维护了prev,next,item三个属性，
  其中通过prev指向前一个节点，通过next指向后一个节点。最终实现双向链表
4.所以LinkedList的元素的添加和删除，不是通过数组完成的，相对来说效率较高。


 */

public class example01 {
    public static void main(String[] args) {
        //所以这里模拟一个简单的双向链表的底层原理，所以我们自己写一个Node类
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node jerry = new Node("jerry");

        //连接三个节点，形成双向链表
        jack.next = tom;//jack对象的属性next是Node类的对象，然后指向了Node类的tom对象，换句话说就是jack对象的next属性连接了tom对象
        tom.next = jerry;//和上面一样
        //由此就形成了jack --> tom --> jerry

        //然后我们还需要反方向再来一次
        jerry.pre = tom;
        tom.pre = jack;
        //由此形成了 jack <-- tom <-- jerry

        Node first = jack;//让first引用指向jack，就是双向链表的首节点
        Node last = jerry;//尾节点

        /*
        最终变成了这样一个双向链表
        jack --> tom --> jerry
        jack <-- tom <-- jerry
         */

        //尝试遍历
        System.out.println("\n=========First=========");
        while(true){ //死循环
            if (first == null){//循环终止条件
                break;
            }

            System.out.println(first);//first就是jack
            first = first.next;//意思是jack = jack.next,然后下一次循环的first就是jack.next也就是tom了
            //当first = jerry时，这时的first.next = null，所以下一次循环就会break
        }

        System.out.println("\n=========Last=========");
        while(true){ //死循环
            if (last == null){//循环终止条件
                break;
            }

            System.out.println(last);
            last = last.pre;

        }

        //演示链表的添加对象/数据
        //要求，在tom插入
        Node smith = new Node("smith");
        smith.next = jerry;
        smith.pre = tom;
        tom.next = smith;
        jerry.pre = smith;

        System.out.println("\n====添加了smith对象后用first遍历=====");
        first = jack;//重置first引用jack
        while(true){ //死循环
            if (first == null){//循环终止条件
                break;
            }

            System.out.println(first);//first就是jack
            first = first.next;//意思是jack = jack.next,然后下一次循环的first就是jack.next也就是tom了
            //当first = jerry时，这时的first.next = null，所以下一次循环就会break
        }

        System.out.println("\n====添加了smith对象后用last遍历=====");
        last = jerry;//前面遍历时last被更改了，所以现在需要重置回去last引用jerry
        while(true){ //死循环
            if (last == null){//循环终止条件
                break;
            }

            System.out.println(last);
            last = last.pre;

        }

    }
}

class Node{
    public Object item;
    public Node next;//指向后一个节点
    public Node pre;//指向前一个节点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
