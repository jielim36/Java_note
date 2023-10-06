package example07;
//@SuppressWarnings({"all"})
public class example07 {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method(){
        try{
            String[] names = new String[3];//里面每个都是null
            if (names[1].equals("tom")){//在这一行代码就会发生NullPointerException
                System.out.println(names[1]);
            }else{
                names[3] = "Jie";//ArrayIndexOutOfBoundException
            }
            return 1;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("发生了数组越界");
            return 2;//即使return了2也方法也不会立刻结束而是继续执行finally语句
        }catch(NullPointerException e){
            System.out.println("发生了空指针异常");
            return 3;//即使return了2也方法也不会立刻结束而是继续执行finally语句
        }finally {
            return 4;//无论如何都是会执行finally
        }
    }
}
