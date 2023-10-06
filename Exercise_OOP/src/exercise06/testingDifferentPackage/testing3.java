package exercise06.testingDifferentPackage;

import exercise06.testingModifier;

public class testing3 extends testingModifier {

    public void getNumber(){
        this.num1 = 0;
        this.num2 = 0;
//        this.num3 = 0;//default在不同包的子类中就不能用
//        this.num4 = 0;
    }

}
