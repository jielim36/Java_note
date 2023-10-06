package example04_arrayExercise;

import java.util.Arrays;
import java.util.Comparator;

/*
创建Book类，里面包含name和price，按price排序（大到小）。
要求使用两种方式排序（price和name），对对象的某个属性排序，有一个Book [] books = 5个对象；

 */
public class example03 {
    public static void main(String[] args) {

        Book [] books = new Book[5];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("元神",120);
        books[2] = new Book("言情小说",90);
        books[3] = new Book("玄幻奇幻小说",200);
        books[4] = new Book("Java从入门到入土~",400);
        for (Book display : books){
            display.toString();
        }

        Arrays.sort(books, new Comparator() {
            //这里是对Book数组的排序，因此 o1和o2就是Book对象
            @Override
            public int compare(Object o1 , Object o2) {
                Book book1 = (Book)o1;//向下转型
                Book book2 = (Book)o2;//向下转型

                //以下的代码都是为了解决return必须是int类型，但是price是double所以不能直接用return，
                // 普通的int数据可以直接return两个值相减后的值，但是double数据直接强转成int会损失精度，
                // 所以我们自己写代码判断两个对象的price对比大小
                //思路：模拟普通的return 排序从大到小 ：当左边小于右边，交换双方的位置(第二个对象 - 第一个对象：如果是正数表示第二个对象较大，负数反之)
                //如果排序本来想要大到小，效果确实小到大，那么就直接让return 1 和 return -1的代码调换就行了
                double priceValue = book2.getPrice() - book1.getPrice();
                if (priceValue > 0){ //如果book2大于book1
                    return 1;//正数表示不交换位置（不一定要1，只要是正数意思都一样）
                }else if (priceValue < 0){//如果book2小于book1
                    return -1;//负数意味着两个对象需要交换位置
                }else { //当两个对象的值相等时
                    return 0;
                }
            }
        });

//        System.out.println(books[0].toString()); //这样只能输出一个对象

        //这里的toString是Book类重写的toString方法，然后用Arrays类调用（因为不能直接调用Book的）时，
        // 此时会使用Book类的toString重写方法，而且可以对books数组的每一个都执行
        System.out.println("书籍价格排序（从大到小）");
        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book name1 = (Book)o1;
                Book name2 = (Book)o2;

                return name2.getName().length() - name1.getName().length();
            }
        });

        System.out.println("\n====================\n书籍名称排序（长到短）");
        System.out.println(Arrays.toString(books));
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
