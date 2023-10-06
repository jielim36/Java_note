package example02;

public class example02 {
/*
如何实现使用IDEA 这个IDE进行对main方法进行传值

写了代码后在执行前往IDE的右上角看，绿色run键的左边那个多选框，
点击后再点击edit configurations,然后找到Build and run里的program argument
传入的值如果有三个，就有空格来隔开比如传入jielim,hoho,hi 这三个值就写成 jielim hoho hi
 */
    public static void main(String[] args) {

        for (int i = 0 ; i < args.length ; i++){
            System.out.println("第 "+(i+1)+" 个参数是 : " + args[i]);
        }

    }

}
