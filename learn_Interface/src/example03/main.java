package example03;

import javax.xml.crypto.Data;

public class main {
    public static void main(String[] args) {

        //如果我想要连接MySQL
        A a = new A(); //A类是负责MySQL的
        DB(a);

        System.out.println("================");

        //连接Oracle
        B b = new B();
        DB(b);

    }

    public static void DB(DataBase_Interface db){
        db.connect();
        db.close();
    }

}
