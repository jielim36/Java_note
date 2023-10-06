package exercise02;

public class exercise02 {

    public static void main(String[] args) {

    }
    public int addOne(final int x){
 //       ++x;//这一步错了，++x会导致x这个常量的值变化，所以报错
        return x + 1; //这一步没有错, return x + 1 并不会导致x的值产生变化
    }
}

