package Map.example01;


import java.util.HashMap;
import java.util.Map;

public class example01 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        /*
        Map接口实现类的特点
        1.Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value（双列元素）（Collection的Value是系统给予的一个Object(PRESENT)）
        2.Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
        3.Map中的key不允许重复。原因和HashSet一样，因为需要判断hash值。如果遇到相同的key，新的key带着value“替换”旧的key和value
        4.Map的value可以重复
        5.Map的key可以为null，但是只能一个
        6.Map的value也可以为null，而且可以多个
        7.常用String类作为Map的key，但是也可以用其他的（系统要求是Object类都可以）
        8.key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
        9.个人理解：一个元素有key和value属性，key属性代表着个人身份证，必须要保证与他人不同。value属性属于内在/内容，没有太多限制。
        10.Map的输出和添加时的顺序不一致：无序的，原理和Collection一样，存放元素的位置根据hash值判断的

         */

        Map map = new HashMap();
        map.put("no1","Lim Yee Jie");//key:"no1"  ; value:"Lim Yee Jie"
        map.put("no1","Jie Lim");//Map和Collection遇到重复key元素时的差别是：Map是通过替换元素的，所以Lim Yee Jie被替换成Jie Lim
        map.put("no2","Lo Kai Yang");
        map.put("no3","Lo Kai Yang");//key不一样value一样是可以接受添加的
        System.out.println(map);//{no2=Lo Kai Yang, no1=Jie Lim, no3=Lo Kai Yang} 注意：输出是无序的

        //为什么说key是身份证号？
        System.out.println(map.get("no3"));//输出：Lo Kai Yang   -> 通过get方法传入一个key，会返回对应的value

    }
}
