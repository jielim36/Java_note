/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class MavenProject1 {

    static Pet [] products = new Pet[5];

    public static void main(String[] args)
    {
        initialization();
        WelcomePage();
        Menu();
    }

    public static void initialization(){
        //create the products first
        Pet cat = new Pet("Cat", 100.0, 10);
        Pet dog = new Pet("Dog", 200.0, 10);
        Pet rabbit = new Pet("Rabbit", 300.0, 10);
        Pet hamster = new Pet("Hamster", 400.0, 10);
        Pet fish = new Pet("Fish", 500.0, 10);

        //input to array
        products[0] = cat;
        products[1] = dog;
        products[2] = rabbit;
        products[3] = hamster;
        products[4] = fish;
    }


    public static void WelcomePage()
    {
        JOptionPane.showMessageDialog(null,
                String.format("                       / \\ _ / \\   (      . - \" - . \n"+
                        "                      (  ^ . ^  )   )  / | ^  ^ | \\ \n"+
                        "                          \\ \" /    (   { / (_0_) \\ } \n"+
                        "                      (   |   |  )       _ /  ^  \\ _ \n"+
                        "                    (__d b__)    (  /  / ^ \\  \\ )\n\n"+
                        "(*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~(\n"+
                        ")*   !          !    ^ ^ ^     [  *  *  *  \\  {  ~  ~ ~  \\  \\       /   *)\n"+
                        "(*   !          ! /             \\ [            ]  {             }   \\    /     *(\n"+
                        ")*   !$$$$$! |@@@@| [  *  *  * /   {  ~  ~ ~  /     <       *)\n"+
                        "(*   !          ! |             | [               {                    >      *(\n"+
                        ")*   !          ! |             | [               {                    <      *)\n"+
                        "(*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~(\n\n"+
                        "WELCOME TO HAPPY PETS SHOP!^^"));
    }
    public static void Menu()
    {
        while (true)
        {
            String Menu = JOptionPane.showInputDialog(
                    "Please select the number:\n"+
                            "1. About Us\n"+
                            "2. Buy Pets\n"+
                            "3. Buy Pets Food\n"+
                            "4. Confirm Payment\n"+
                            "5. Exit");

            int selection = Integer.parseInt(Menu);

            switch (selection)
            {
                case 1: AboutUs();break;
                case 2: BuyPets();break;
                case 3: BuyPetsFood();break;
                case 4: ConfirmPayment();break;
                case 5: JOptionPane.showMessageDialog(null,
                        String.format(" Thank you for visit Happy Pets Shop"));
                    System.exit(0); break;
                default:
                    JOptionPane.showMessageDialog(null,
                            String.format(" Invalid Selection"));
            }
        }
    }

    public static void AboutUs()
    {
        JOptionPane.showMessageDialog(null,
                String.format("############################################\n"+
                        "#                 ABOUT US                 #\n"+
                        "############################################\n"+
                        "# Company name    | Happy Pets Shop        #\n"+
                        "#-----------------|------------------------#\n"+
                        "# Registration No | 123456789101(1234567A) #\n"+
                        "#-----------------|------------------------#\n"+
                        "# Representative  | Su Zhi Lun             #\n"+
                        "#                 | Wong Jie Ying          #\n"+
                        "#                 | Beatrice Leong Zhi Xin #\n"+
                        "#                 | Angel Yong Zu Er       #\n"+
                        "#-----------------|------------------------#\n"+
                        "# Date of         | 19/08/2023             #\n"+
                        "# establishment   | 19 August 2023         #\n"+
                        "#-----------------|------------------------#\n"+
                        "$ Business        | Pets                   #\n"+
                        "# description     | Sales                  #\n"+
                        "#-----------------|------------------------#\n"+
                        "# Address         | Kajang, Malaysia       #\n"+
                        "# Address         | Kajang, Malaysia       #\n"+
                        "############################################\n"));
    }

    public static void BuyPets()
    {
//        String Pets [] = {"Cat", "Dog", "Fish", "Rabbit","Bird"};
//        double PetsPrice [] = {1800.00, 1500.00, 500.00, 1000.00, 1200.00};
        int PetsQuantity;

        //output each pet array
        String stock = "";
        for (int i = 0 ; i < products.length ; i++){
            stock = stock + products[i].toString() + "\n";
        }

        String PetsMenu = JOptionPane.showInputDialog(
                "Please select the number:\n"+ stock);

        int PetsSelection = Integer.parseInt(PetsMenu);

        if (PetsSelection >= 1 && PetsSelection <= 5)
        {
            String SelectedPets = products[PetsSelection - 1].getName();
            double SelectedPetsPrice = products[PetsSelection - 1].getPrice();
            JOptionPane.showMessageDialog(null,
                    String.format("You selected: %s\nPrice: RM %.2f",SelectedPets, SelectedPetsPrice));

            String InputPetsQuantity = JOptionPane.showInputDialog("Enter the quantity of pets: ");
            PetsQuantity = Integer.parseInt(InputPetsQuantity);
            if (PetsQuantity > products[PetsSelection - 1].getStock()) {
                JOptionPane.showMessageDialog(null,
                        String.format("Sorry, we only have %d %s left", products[PetsSelection - 1].getStock(), products[PetsSelection - 1].getName()));
            } else {
                products[PetsSelection - 1].setStock(products[PetsSelection - 1].getStock() - PetsQuantity);
                JOptionPane.showMessageDialog(null,
                        String.format("You have successfully purchased %d %s", PetsQuantity, products[PetsSelection - 1].getName()));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    String.format("Invalid Selection"));
        }
    }
    public static void BuyPetsFood()
    {
        String PetsFood [] = {"Cat Food", "Dog Food", "Fish Food", "Rabbit Food","Bird Food"};
        double PetsFoodPrice [] = {85.00, 80.00, 50.00, 65.00, 55.00};
        int PetsFoodQuantity;

        String PetsFoodMenu = JOptionPane.showInputDialog(
                "Please select the number:\n"+
                        "1. Cat Food (RM 85.00)\n"+
                        "2. Dog Food (RM 80.00)\n"+
                        "3. Fish Food (RM 50.00)\n"+
                        "4. Rabbit Food (RM 65.00)\n"+
                        "5. Bird Food (RM 55.00)\n");

        int PetsFoodSelection = Integer.parseInt(PetsFoodMenu);

        if (PetsFoodSelection >= 1 && PetsFoodSelection <= 5)
        {
            String SelectedPetsFood = PetsFood[PetsFoodSelection - 1];
            double SelectedPetsFoodPrice = PetsFoodPrice[PetsFoodSelection - 1];
            JOptionPane.showMessageDialog(null,
                    String.format("You selected: %s\nPrice: RM %.2f", SelectedPetsFood, SelectedPetsFoodPrice));

            String InputPetsFoodQuantity = JOptionPane.showInputDialog("Enter the quantity of pets food: ");
            PetsFoodQuantity = Integer.parseInt(InputPetsFoodQuantity);
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    String.format("Invalid Selection"));
        }
    }
    public static void ConfirmPayment()
    {

    }
}



