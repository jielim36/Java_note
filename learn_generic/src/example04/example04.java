package example04;

import java.util.*;

/*
练习题：
HashMap
1.创建三个学生对象
1.把学生对象放入到HashSet中
2.放入到HashMap中，要求key是String name，Value是学生对象
3.使用两种遍历方式

 */
public class example04 {
    public static void main(String[] args) {

        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(new Student("Jie"));
        hashSet.add(new Student("Jack"));
        hashSet.add(new Student("Smith"));

        System.out.println("HashSet第一种遍历方式：");
        for (Student obj : hashSet){
            System.out.println(obj.getName());
        }

        System.out.println("\nHashSet第二种遍历方式：");
        Iterator<Student> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Student next = (Student) iterator.next();
            System.out.println(next.getName());
        }


        //HashMap  提示：HashMap底层里的接收是： HashMap<K,V> 对应了Key 和 Value
        HashMap<String,Student> hashMap = new HashMap<String,Student>();
        hashMap.put("Jie",new Student("Jie"));
        hashMap.put("HoHo",new Student("HoHo"));
        hashMap.put("KaiYang",new Student("KaiYang"));

        System.out.println("\nHashMap的第一种遍历方式");
        Set<String> set = hashMap.keySet();
        for (String obj : set){
            System.out.println(obj + " - " + hashMap.get(obj));
        }

        System.out.println("\nHashMap的第二种遍历方式");
        Iterator<String> iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            System.out.println(next + "-" + hashMap.get(next));
        }

        //下面代码解析：使用Set时的泛型定义成Map.Entry, 但是Map.Entry也需要定义泛型，然后定义了String和Value
        Set<Map.Entry<String,Student>> entrySet = hashMap.entrySet();
        /*
        底层代码：
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        System.out.println("\nHashMap第三种遍历：Map.Entry");
        Iterator<Map.Entry<String,Student>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String,Student> next2 = entryIterator.next();
            System.out.println(next2.getKey() + "-" + next2.getValue());
        }


    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
