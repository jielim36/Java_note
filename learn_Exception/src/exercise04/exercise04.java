package exercise04;
/*
输出结果：
B
C
D
 */
public class exercise04 {
    public static void main(String[] args) {
        System.out.println("Exercise 04: ");
        try{
            showExce();
            System.out.println("A");
        }catch (Exception e){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void showExce() throws Exception{
        throw new Exception();
    }
}
