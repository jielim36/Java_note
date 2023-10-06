package example13;

public class CustomException {
    public static void main(String[] args) {
        int age = 130;
        if (!(age >=18 && age <= 120)){
            throw new ageException("年龄必须在18-120岁之间");
        }

        System.out.println("你的年龄范围是正确的");
    }
}

//自定义的异常
/*
目的：当我们接收Person对象年龄时，要求范围在18-120之间，否则抛出一个自定义异常
 */
class ageException extends RuntimeException{//继承RuntimeException，
        // 如果直接继承Exception父类是编译时异常，做成运行时异常的好处是我们可以省略在方法语句中使用throws处理异常
    public ageException(String message) {//使用构造器快捷键有许多选项
        super(message);
    }
}
