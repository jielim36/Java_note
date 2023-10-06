package Set.LinkedHashSet.example03;

import java.util.LinkedHashSet;
import java.util.Objects;

/*
练习题：
Car类（属性：name，price），如果name和price一样
则认为是相同的元素，就不能添加
 */
public class example03 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Cat("花花",33000));
        linkedHashSet.add(new Cat("红花",300));
        linkedHashSet.add(new Cat("花花",33000));
        linkedHashSet.add(new Cat("紫花",3000));
        linkedHashSet.add(new Cat("紫花",2000));
        System.out.println(linkedHashSet);
    }
}

class Cat {
    private String name;
    private double price;

    public Cat(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
    /*
    注意：如果要相同的内容不同的对象不能添加的话，equals和hashcode缺一不可，因为如果hashcode相同但是equals使用Object类的话判断出是两个不同的对象所以还是可以添加进去即使内容相同。
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(cat.price, price) == 0 && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
