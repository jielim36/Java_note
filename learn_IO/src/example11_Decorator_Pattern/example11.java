package example11_Decorator_Pattern;
/*
Decorator Pattern 装饰器设计模式

 */
public class example11 {
    public static void main(String[] args) {

        //处理流BufferedReader对FileReader的对象进行封装
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFile(5);

        BufferedReader_ bufferedReader_1 = new BufferedReader_(new StringReader_());
        bufferedReader_1.readString(3);


    }
}

abstract class Reader_{ //抽象基类
    public void readFile(){} //空方法，节点流有去实现
    public void readString(){} //空方法，节点流有去实现
}

class BufferedReader_ extends Reader_{//处理流
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_){
        this.reader_ = reader_;  //如果reader_接受的是FileReader_对象，就会变成 Reader_ reader_ = new FileReader_();
    }

    public void readFile(int num) { //处理流提供的方法可能更多功能（这里的代码是随便乱编的，本意就是告诉你可以扩展原本的方法）
        for (int i = 0; i < num; i++) {
            reader_.readFile(); //相当于扩展（增强）了原本reader_对象所在的类的readFile方法
                                //Reader_ reader_ = new FileReader_(); 体现了多态，所以这里会调用运行类型FileReader_的readFile方法，然后循环10次
        }
    }

    public void readString(int num) {
        for (int i = 0; i < num ; i++) {
            reader_.readString();
        }
    }
}


class FileReader_ extends Reader_ { //节点流
    @Override
    public void readFile(){
        System.out.println("对文件进行读取");
    }
}


class StringReader_ extends Reader_{ //节点流
    @Override
    public void readString(){
        System.out.println("读取字符串");
    }
}


