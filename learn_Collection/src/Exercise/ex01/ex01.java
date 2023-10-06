package Exercise.ex01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*

1.封装一个新闻类，包含标题和内容属性，提供get，set方法，重写toString方法，打印对象时只打印标题
2.值提供一个带参数的构造器，实例化对象时，值初始化标题；并且实例化两个标题：
-新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引起民众担忧
-男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生

3.将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
4.在遍历集合过程中，对新闻标题进行处理，超过15个字的只保留前15个，然后在后边加上“...”
5.在控制台打印遍历出经过处理的新闻标题


 */
public class ex01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引起民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);

//        Collections.reverse(arrayList); 简洁的方法，但是会影响数组本身
        for (int i = arrayList.size()-1 ; i >= 0 ; i--){
            System.out.println(arrayList.get(i));//倒序，所以迭代是i--
        }

    }
}

class News{
    private String title;
    private String content;//内容

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
//        if (title.length() > 15){  实现title超过十五个字数以后只是...
//            char [] tt = Arrays.copyOf(title.toCharArray(),15);
//            return "\nTitle: " + new String(tt) + "...\nContent: " + content + "\n===============================";
//
//        }
        if (title.length() > 15){
            return "\nTitle: " + title.substring(0,15) + "...\nContent: " + content + "\n===============================";
        }


        return "\nTitle: " + title + "\nContent: " + content + "\n===============================";
    }
}
