package example10_exercise_JUnit;

import org.junit.jupiter.api.Test;

import java.util.*;
/*
什么是JUnit？
介绍：
1.JUnit是一个Java语言的单元测试框架
2.多数Java的开发环境都已经集成了JUnit作为单元测试的工具

为什么需要它？
1.一个类有很多个功能代码需要测试，为了测试，就需要写入到main方法中
2.如果有多个功能代码测试，就需要来回注销，切换很麻烦
3.如果可以直接运行一个方法，就方便很多，并且可以给出相关的信息，就好了


使用方法：
在方法上面写上@Test + alt+ Enter 选择最新版本的JUnit 5.8.x 然后载入后，编译器的左边绿色箭头可以直接运行了

 */
public class example10 {
    public static void main(String[] args) {

        DAO<User> daoMap = new DAO<>();
        daoMap.save("1",new User(1,19,"Lim Yee Jie"));
        daoMap.save("2",new User(1,19,"KaiYang"));
        daoMap.save("3",new User(1,19,"HoHoHo"));

        List show = daoMap.list();
        System.out.println(show);

        System.out.println("key 2的value："+daoMap.get("2"));

        daoMap.update("1",new User(1,19,"Jie"));
        System.out.println("update后：");
        daoMap.print();

        daoMap.delete("3");
        daoMap.print();

    }

    @Test  //JUnit单元测试框架使用@Test + alt+ Enter 选择最新版本的JUnit 5.8.x 然后载入后，编译器的左边可以直接运行了
    public void learn_JUnit(){
        System.out.println("方法已被调用...");
    }
}

class DAO<T>{

    Map<String,T> map = new HashMap<>();

    @Test
    public void save(String id,T entity){
        map.put(id,entity);
    }

    @Test
    public T get(String id){
        return map.get(id);
    }
    @Test
    public void update(String id,T entity){
        map.put(id , entity);
    }
    @Test
    public List <T> list(){
        Set set = map.keySet();
        List list = new ArrayList();
        for (Object obj : set){
            list.add(map.get(obj));
        }
        return list;
    }

    @Test
    public void delete(String id){
        map.remove(id);
    }

    public void print(){
        System.out.println(list());
    }

}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}