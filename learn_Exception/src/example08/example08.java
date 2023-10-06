package example08;

public class example08 {
    public static void main(String[] args) {
        System.out.println("main method: i = " + method());//3
    }
    public static int method(){
        int i = 1;

        try{
            i++;//i=2
            String[] names = new String[3];//里面每个都是null
            if (names[1].equals("tom")){//在这一行代码就会发生NullPointerException
                System.out.println(names[1]);
            }else{
                names[3] = "Jie";//ArrayIndexOutOfBoundException
            }
            return 1;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("发生了数组越界");
            return 2;
        }catch(NullPointerException e){
            System.out.println("发生了空指针异常");
            return ++i;
        }finally {
            ++i;//注意这里的i没有return，所以main方法接收的和finally语句块里的i没有印象
            System.out.println("(finally) i = " + i);//4
        }
    }

}
