package Collection.example04;

import java.util.ArrayList;
import java.util.Collection;

/*
第二种遍历集合的方式：增强for循环
 */
public class example04 {
    public static void main(String[] args) {

        Collection col = new ArrayList();
        col.add(22);
        col.add("hihi");
        col.add("jack");

        //增强for循环可以用于集合
        //1.增强for循环的底层原理其实仍然是example03的迭代器
        //2，可以理解成一个简化版的迭代器遍历
        //增强for循环的快捷方式：I 大写的I
        for (Object next : col){
            System.out.println(next);
        }


        //顺带一提，增强for循环也可以用于数组
        System.out.println("\n===数组===");
        int [] nums = {1,8,10,90};
        for (int show : nums){
            System.out.println(show);
        }


    }
}
