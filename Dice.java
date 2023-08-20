import static java.lang.Math.*;

public class Dice{

    public static int numberOnDice(){

        int randomNumber = (int)(Math.random()*10);

        if(randomNumber <=0 || randomNumber >=7){

            return 0;
        }

        return randomNumber;
    }

}