package Exercise.ex05;

import java.util.HashSet;
import java.util.Objects;
/*
判断：
Person类重写了hashCode和equals方法，问下面的代码输出什么
 */
public class ex05 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);

        p1.setName("CC");
        set.remove(p1);
        /*
        这里的remove无法成功删除p1，原因：
        原本的p1的hash值是通过id:1011和name AA来计算出来的
        但是当p1的setName把属性更改后，hash值并不会重新计算更新

        所以当我们remove p1时，会通过现在的的p1属性CC计算的一个hash值查找，但是找不到，所以删除失败

         */

        System.out.println("第一次："+set);//输出了CC 和 BB 两个

        set.add(new Person(1001,"CC"));
        /*
        可以添加进去，因为之前的p1的name更改成CC后，它的hash值其实还是通过name AA计算出来的，更改成CC时并没有更新hash值，
        所以现在这里要添加的元素的hash值是1001,CC计算出来的，所以算出来的hash值还是有所区别
         */
        System.out.println("第二次:"+set);//CC和BB CC 三个

        set.add(new Person(1001,"AA"));//可以添加
        /*
        可以添加，虽然计算出来的hash值是通过和p1一样的1001,AA计算出来的，所以他们的hash值一样
        然后系统就会通过这个hash值去到数组的该索引位置发现该索引位置已经有了一个元素，那就是p1
        但是并不会立刻添加失败，系统还需要使用equals方法来再次确定是不是同一个对象
        如果equals方法返回false，就代表不同对象，然后双方会形成链表
        此时p1就会和当前要添加的这个1001,AA使用equals方法比较，却发现p1是CC，当前的是AA
        发现了他们的name不一样，所以返回了false
        然后就添加成功且双方就会形成链表
         */
        System.out.println("第三次：" + set);//BB CC CC AA 4个

    }
}

class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
