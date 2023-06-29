/**
 * Espresso
 * This class will create an "espresso" coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.ArrayList;
import java.util.List;

public class Espresso implements Coffee {

    public Espresso(){

    }

    public double getCost(){

        return 1.75;
    }

    public List<String> getIngredients(){
        List<String> espressoIngredients = new ArrayList<>();
        espressoIngredients.add("Espresso");

        return espressoIngredients;
    }

    public String printCoffee(){

        return "An espresso";
    }
}
