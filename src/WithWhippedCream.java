/**
 * WithWhippedCream
 * A Coffee Decorator sub-class that adds whipped cream to a coffee.
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.List;

public class WithWhippedCream extends CoffeeDecorator {

    public WithWhippedCream(Coffee c){

        super(c);

    }

    public double getCost(){

        return super.getCost() + 0.25;
    }

    public List<String> getIngredients(){

        List<String> Ingredients = super.getIngredients();
        Ingredients.add("Whipped Cream");

        return Ingredients;
    }
    @Override
    public String printCoffee(){

        return super.printCoffee() + " with whipped cream";
    }
}

