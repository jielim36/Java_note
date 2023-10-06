package example06;
/*
判断输出结果
 */
public class example06 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false : 注意上面是new一个对象出来，所以i和j绝对是两个对象，地址不同

        Integer m = 1;//底层：Integer.valueOf(1)
//        Integer.valueOf();可以Ctrl+b 去看源码
        Integer n = 1;
        System.out.println(m == n);//true : 对比的是值的大小，所以true
        /*
        Integer包装类的valueOf重写方法 源代码：
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
        }
        解读：
        1.IntegerCache.low和 IntegerCache.high 的是一个范围，该范围是-128 to 127 (源代码注释有说明)
        2.如果i大于等于IntegerCache.low(-128)和小于IntegerCache.high(127)就会返回一个基本数据类型
        3.反之，如果不在该范围内，返回一个新的对象
         */


        Integer x = 128;//IntegerCache.low和 IntegerCache.high 的是一个范围，该范围是-128 to 127 (源代码注释有说明)，刚好x和y超过了范围，所以返回新对象
        Integer y = 128;
        System.out.println(x == y);//这里对比的是两个对象，地址不相同，所以false

        part2();
    }

    public static void part2(){
        System.out.println("===========Part2============");
        Integer i1 = new Integer(127);//即使valueOf方法里超过了127后才会返回对象，但如果自己手动new对象是话还是一个新的对象
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//false：对比的是两个对象

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3==i4);//false

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);//true：对比的是双方的值，因为没有在-128-127的范围之外

        Integer i7 = 128;//超出范围，创建新对象
        Integer i8 = 128;
        System.out.println(i7 == i8);//false

        Integer i9 = 127;//没有创建新的对象，系统原本的
        Integer i10 = new Integer(127);//创建了新对象
        System.out.println(i9 == i10);//false , 对比的是两个对象

        Integer i11 = 127;
        int i12 = 127;//基本数据类型
        System.out.println(i11 == i12);//true，只要有基本数据类型，那么判断的就是双方的值

        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);//true 只要有基本数据类型，那么判断的就是双方的值

    }
}
