package exercise01;

public class exercise01 {
    public static void main(String[] args) {
        String str = "abcedf";
        System.out.println("交换前：");
        System.out.println(str);
        System.out.println("交换后：");
        try {
            System.out.println(reverse(str,-1,4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str,int start , int end){
        //防护机制  编程思想：联想程序错误情况  （ 不推荐，我们应该联想正确的情况）
//        if(start < 0 || start > reverseArray.length-1){
//            return "Invalid start value";
//        }else if(end < 0 || end > reverseArray.length-1){
//            return "Invalid end value";
//        }else if(start >= end){
//            return "错误：起点和终点位置一样或超过终点位置...";
//        }

        /*
        编程技巧：关于写防护机制
        我们只要想出正确的情况，然后取反后都是错误的情况
        因为正确的情况容易想到，错误的情况太多
         */
        //编程思想：写正确情况
        if( str != null && start >= 0 && start < str.length()-1 && end > 0 && end < str.length()-1 && start <= end){
            char[] reverseArray = str.toCharArray();
            char temp = ' ';
            for (int i = start , j = end ; i < j ; j-- , i++){
                temp = reverseArray[i];
                reverseArray[i] = reverseArray[j];
                reverseArray[j] = temp;
            }
//        String result = Arrays.toString(reverseArray);第一种返回方式
            return new String(reverseArray);//第二种方法

        }else {
            if (str == null){
                throw new RuntimeException("传入的字符串不能是null ~");
            }else if(start < 0 || start > str.length()-1){
                throw new RuntimeException("传入的start数值不在传入的字符串长度内~");
            } else if (end < 0 || end > str.length() - 1) {
                throw new RuntimeException("传入的end数值不在传入的字符串长度内~");
            }else if(start >= end){
                throw new RuntimeException("start数值必须小于end数值");
            }else {
                throw new RuntimeException("参数有误捏~ 但不知道在哪里");//细节：平时方法内必须要有一个无条件的return语句，但是如果我们的条件语句else里有抛出异常是可以替代return的
            }
        }
    }
}
