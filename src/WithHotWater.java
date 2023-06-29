/**
 * WithHotWater
 * A Coffee Decorator sub-class that adds hot water to a coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.List;

public class WithHotWater extends CoffeeDecorator {

    public WithHotWater(Coffee c){
        super(c);

    }

    public double getCost(){

        return super.getCost() + 0.00;
    }

    public List<String> getIngredients(){

        List<String> Ingredients = super.getIngredients();
        Ingredients.add("Hot Water");

        return Ingredients;
    }

    @Override
    public String printCoffee(){

        return super.printCoffee() + " with hot water";
    }
}
