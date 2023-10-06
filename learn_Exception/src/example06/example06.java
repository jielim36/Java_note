package example06;
/*
1.当try中有多行代码，第一行代码就发生了异常的话，后面的代码就不会执行直接跳过到catch中
2.如果没有发生异常，就正常执行try中的代码并且不会进入catch中
3.无论如何finally代码块都会被执行
3.可以有多个catch语句，捕获不同的异常（进行不同的业务处理），要求父类异常在后，子类异常在前，（建议看好异常体系图）
  比如先写(NullPointerException e)，然后才写父类(Exception e)，
  原因：因为如果父类在前面，异常一定会被父类捕获，这种情况下子类没有存在的必要，所以才会报错（因为是没有意义的代码）
4.如果发生异常，只会匹配一个catch(最先发生和最先匹配上的catch语句)
6.可以使用try-finally异常处理,这种用法相当于没有捕获异常，因此程序会直接崩溃，但是崩溃前会先执行finally代码块，
  应用场景：执行一段代码，不管是否发生异常，都必须执行某个业务逻辑
 */
public class example06 {
    public static void main(String[] args) {

        try {
            String str = "hahaha";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);//当上面的代码发生异常时，这行代码就不会执行直接跳过到catch
        } catch (NumberFormatException e) {
            System.out.println("异常信息：" + e.getMessage());//没有异常的话就不会来到catch
        }finally{
            System.out.println("finally代码块被执行...");
        }

        System.out.println("程序继续运行...");//因为我们使用try catch对异常进行处理了，所以程序并没有崩溃，而是可以继续执行


        //catch语句可以有多个
        System.out.println("\n=================================\n演示多个catch语句...\n");

        try {
            Person person1 = new Person();
            person1 = null;
            System.out.println(person1.getName());//NullPointerException
            int n1 = 10;
            int n2 = 0;
            int result = n1 / n2;//ArithmeticException
        }catch(NullPointerException e){//Exception类的子类NullPointerException类（子类写在上面）
            System.out.println("哈哈哈哈发生空指针异常：" + e.getMessage());
        } catch(ArithmeticException e){ //Exception类的子类ArithmeticException （子类写在上面）
            System.out.println("哈哈哈，发生数学运算异常：" + e.getMessage());
        }catch (Exception e) {//父类：Exception类可以包含NullPointer 和 Arithmetic 异常（父类写在下面）
            e.printStackTrace();
        }finally {

        }

        System.out.println("\n=======================\n演示try-finally异常处理");

        int n1 = 10;
        int n2 = 0;
        try {
            int result = n1 / n2;//ArithmeticException
        } finally {
            System.out.println("执行了finally");
        }
        System.out.println("程序继续执行...");//运行不了

    }
}

class Person{
    private String name = "jack";

    public String getName() {
        return name;
    }
}

