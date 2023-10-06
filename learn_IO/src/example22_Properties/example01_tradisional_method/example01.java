package example22_Properties.example01_tradisional_method;

import java.io.BufferedReader;
import java.io.FileReader;

/*
示范传统方式，比较麻烦
 */
public class example01 {
    public static void main(String[] args) throws Exception {
        getPropertiesOld();
    }

    //传统方法 - 麻烦
    public static void getPropertiesOld() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null){
//            System.out.println(line); 这个是输出 user = root ，但是我们想要输出root而已
            String[] split = line.split("=");
            System.out.println(split[0] + "的值是" + split[1]);
        }
    }

    public static void getPropertiesNew(){

    }

}
