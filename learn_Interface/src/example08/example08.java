package example08;

public class example08 {
    public static void main(String[] args) {
        //接口的多态


      // AAA interFaceOBJ = new AAA();报错，因为接口不能实例化对象
        AAA interFaceOBJ = new BBB(); //接口类型的变量interFaceOBJ 可以指向实现了AAA接口的类的对象实例
        interFaceOBJ = new CCC();//可以让interFaceOBJ再次指向另一个实现了AAA接口的类的对象实例（体现了多态）


        //继承的多态
        aaa obj = new aaa();
        aaa obj2 = new bbb();
        obj2 = new ccc();


    }
}

interface AAA{}

class BBB implements AAA{}

class CCC implements AAA{}

class aaa{}
class bbb extends aaa{}
class ccc extends aaa{}