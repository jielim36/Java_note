package exercise01;

public class main {

//    Question： 定义person类，name,age,job ， 初始化Person对象数组，有三个person对象，
//    并按照age的从大到小进行排序，使用冒泡排序

    public static void main(String[] args) {

        Person [] personArray = new Person[3];

        personArray[0] = new Person("Lim Yee Jie" , 19 , "Student");
        personArray[1] = new Person("Sonia" , 18 , "Worker");
        personArray[2] = new Person("Kai Yang" , 20 , "Oja Cashier");

        //show info
        for (int i = 0; i < personArray.length; i++) {
            System.out.println(personArray[i].toString());
        }
        System.out.println("\nAfter change\n");
        //冒泡排序 ： 针对age进行从大到小的排序
        personArray = temp(personArray);

        for (int i = 0; i < personArray.length; i++) {
            System.out.println(personArray[i]);
        }


    }

    public static Person [] temp(Person[] arrayOld){
        Person [] temp = new Person[1];
        temp[0] = arrayOld[0];

        if(arrayOld.length < 1) {
            return arrayOld;
        }



        for (int i = 0; i < arrayOld.length - 1 ; i++)
        {

            for (int j = 0; j < arrayOld.length - 1 - i; j++)
            {
                if(arrayOld[j].getAge() < arrayOld[j+1].getAge()){

                    temp[0] = arrayOld[j];
                    arrayOld[j] = arrayOld[j+1];
                    arrayOld[j+1] = temp[0];

                }


            }

        }

        return arrayOld;
        }

    }



