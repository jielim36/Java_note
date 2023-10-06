package Set.HastSet.example04;

import java.util.HashSet;

/*
测试HashSet的扩容机制
 */
public class example04 {
    public static void main(String[] args) {
        //7.HashSet的底层是HashMap，第一次添加时，table的数组扩容到16(默认)，临界点(threshold)是16*加载因子（loadFactory）是0.75 = 6*0.75 = 临界点12
        //8.如果table数组的长度到达了临界值12，就会扩容到数组的长度*2，也就是扩容到32大小。然后再重新计算临界点准备下一次扩容的时机:32*0.75=临界点24.接下来的每一次扩容都以此类推...

        //测试：下断点然后使用调式模式Debug来测试
        HashSet hashSet = new HashSet();
        for (int i = 1; i < 100 ; i++){
            hashSet.add(i);
        }


    }
}
