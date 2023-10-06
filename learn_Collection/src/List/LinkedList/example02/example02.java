package List.LinkedList.example02;
//追溯LinkedList的源码

import java.util.LinkedList;

public class example02 {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        System.out.println(linkedList);

        /*
        解析：当我们使用add方法时
        1.刚创建LinkList时...
        List.LinkedList linkedList = new List.LinkedList(); //这时的属性：first = null ; last = null;


        2.当我们第一次add方法时...（我们add方法时，最终会跑到linkLast方法）
        void linkLast(E e) {
        final Node<E> l = last; //这时候的last是null，所以l也是null
        final Node<E> newNode = new Node<>(l, e, null);  //newNode就是我们现在正在创建的节点
        last = newNode; //last引用至我们现在创建的节点
        if (l == null)  //如果l == null 是true的情况就是我们第一次add的时候
            first = newNode; //如果是第一次add节点，就把first也指向我们现在创建的节点，所以我们第一次add时，first和last都指向同一个节点
        else
            l.next = newNode;
        size++;  因为我们创建了一个新的节点，所以size++ ， 用于我们之后的集合名.size()获取集合的长度/大小
        modCount++;
    }


    3. 当我们第二次使用add方法时，也就是创建第二个节点时
    void linkLast(E e) {
        final Node<E> l = last; //last是第一个节点，赋给了l
        final Node<E> newNode = new Node<>(l, e, null);  这里的new Node里面会把newNode对象（我们正在创建的新节点）的prev（前面（左）一个节点）连接l，也就是: l(旧节点) <-- （新节点）,然后next = null，因为我们add新节点代表这个节点是最新的不会有人在他前面（右边）
        last = newNode; //处理完后把last变成我们现在创建的节点，因为现在的节点是最新的（最后面/右边），所以last就是该节点，这个行为也可以为之后创建新节点时成为它的旧节点
        if (l == null)//l已经不是null了，所以不执行，转而执行else语句
            first = newNode;
        else
            l.next = newNode;  //l是旧节点，也就是第二新的节点（仅次于现在正在创建的节点），l.next = newNode代表第二新的节点的next指向我们现在新创建的新节点
        size++;
        modCount++;
    }

         */

        linkedList.remove();//remove默认先删除最旧的元素（最左边）
        System.out.println(linkedList);
        /*
        注意：解析中的三个方法都是只有remove第一个节点时才会进入的方法，remove中间节点有其他的方法
        解析：如果使用remove()方法且没有传入参数...
            1.第一步会去到removeFirst()方法(因为没有指定remove哪个元素，所以默认删除第一个元素，也就是first)

            2.进入removeFirst方法后
            public E removeFirst() {
            final Node<E> f = first; //把first也就是当前这个需要被remove的节点赋给f
            if (f == null)//判断我们的first（第一个节点是不是为空）
                throw new NoSuchElementException();//如果我们的LinkedList没有任何元素，也就是first=null，抛出该异常NoSuchElementException
            return unlinkFirst(f);//如果不是null，返回unlinkFirst(f)方法：传入了f也就是我们的first（第一个节点）


            3.进入unlinkFirst(f)方法 （只有删除第一个节点时才会进入这个方法，如果删除中间的节点有其他的方法）
            private E unlinkFirst(Node<E> f) {
                // assert f == first && f != null; 这个是开发者注释掉的东西
                final E element = f.item;  //把要删除的节点的内容赋给element
                final Node<E> next = f.next; //把要删除的节点.next付给next
                f.item = null;//目标节点的内容指向null
                f.next = null; // help GC  //目标节点的.next指向null
                first = next; //要删除的节点的.next已经赋给了该类的next。这时这里就把该类的next赋给了first，也就是说因为我们删除的是第一个节点，所以删除后第一个节点的next就会替代它成为现任的first，所以这里把first指向要删除的节点.next
                if (next == null)//这个情况是当我们删除的节点是最后一个节点，该节点的.next就是null
                    last = null;
                else //如果要删除的节点不是最后一个节点的话执行...
                    next.prev = null; //这里是要删除的节点的prev（右边的）节点主动与即将删除的节点断开连接，执行完这一句代码后我们的节点也成功被删除了，因为它的next和prev都为null
                size--;//因为删除了一个节点，所以更新我们该LinkedList的信息，把大小-1
                modCount++;
                return element; //返回我们删除的节点的内容,如果我们一开始的remove方法有进行输出的话就会输出被删除的节点的内容
            }






         */


    }
}
