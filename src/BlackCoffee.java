/**
 * BlackCoffee
 * This program will create a Black Coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.ArrayList;
import java.util.List;

public class BlackCoffee implements Coffee{

    public BlackCoffee(){

    }

    public double getCost(){

        return 1.00;
    }

    public List<String> getIngredients(){
        List<String> blackCoffeeIngredients = new ArrayList<>();
        blackCoffeeIngredients.add("Black Coffee");

        return blackCoffeeIngredients;
    }

    @Override
    public String printCoffee(){

        return "A black coffee";
    }
}
