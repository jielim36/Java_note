package example03;

/*
example03是演示了 自己做一个定制排序（即决定从大到小还是小到大的排序方式）
 */

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortCustom {
    public static void main(String[] args) {
        int [] arr1 = {9,2,3,-4,5,-6};

//        bubble(arr1); 普通冒泡方法
//        System.out.println(Arrays.toString(arr1));

        //自制的冒泡排序定制版
        bubble2(arr1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i2-i1;  //这里决定我们使用从大到小还是小到大的排序，当i2-i1的号码大于0代表i2大于i1 :比如9-2=7,代表9大于2，如果得到的号码是负数，代表i2小于i1
                /*
                1.c.compare( arr[j] , arr[j+1] ) > 0  : 我们接收的arr[j]和[j+1]对应了o1和o2
                2.这时如果我们使用 i2-i1 ,就是当9-2=7(7>0 = true,true就会交换两个数值的位置),如果i2-i1是-4 - 3 = -7(-7>0 = false,不执行，意味着右边的号码小过左边的号码就不会移动)
                   也就代表i2-i1是：当第二个位置的数字大过第一个位置的数值时，较大的数字会往前移动，较小的往后移动（交换位置），最终的效果就是大的在左边，小的在右边

                 */
            }
        });
        System.out.println(Arrays.toString(arr1));

    }

//    public static void bubble(int [] arr){
//        int temp = 0;
//        for (int i = 0 ; i < arr.length-1; i++){
//            for (int j = 0; j < arr.length-1; j++){
//                if(arr[j]>arr[j+1]){
//                    temp = arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }

    public static void bubble2(int [] arr , Comparator c){
        int temp = 0;
        for (int i = 0 ; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1; j++){
                if(c.compare( arr[j] , arr[j+1] ) > 0 ){  //这个if语句是决定我们使用从大到小的排序还是小到大
                    /*
                    这里的c.compare( arr[j] , arr[j+1] ) ,意思是每次循环都将这两个号码传入main方法的匿名内部类里进行比较（动态绑定，因为匿名内部类实现了该方法）
                     */
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
