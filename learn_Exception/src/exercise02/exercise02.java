package exercise02;

public class exercise02 {
    public static void main(String[] args) {

        if (args[4].equals("john")){//出现两种异常，第一个是ArrayIndexOutOfBound,第二个是NullPointerException
            //数组越界因为如果没有对args参数修改，默认就是args.length = 0，所以索引args[4]会错误
            //空指针异常因为如果没有输入参数就等于null,所以索引args[4] 会报错
            System.out.println("AA");
        }else{
            System.out.println("BB");
        }
        Object o = args[2]; //String -> Object 向上转型，没有问题
        Integer I = (Integer) o;//ClassCastException
                                //String运行类型的o对象，不能对Integer进行向下转型（String和Integer都是Object的子类）
    }
}

