/**
 * WithMilk
 * A Coffee Decorator sub-class that adds milk to a coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.ArrayList;
import java.util.List;

public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee c){
        super(c);

    }

    public double getCost(){

        return super.getCost() + 0.55;
    }

    public List<String> getIngredients(){
        List<String> Ingredients = super.getIngredients();
        Ingredients.add("Milk");

        return Ingredients;
    }
    @Override
    public String printCoffee(){

        return super.printCoffee() + " with milk";
    }
    
}
