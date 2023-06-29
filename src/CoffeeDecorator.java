/**
 * CoffeeDecorator
 * This class will be extended by coffee decorator sub-classes in order to "decorate" a coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.List;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee c){

        coffee = c;


    }

    public double getCost(){

        return coffee.getCost();
    }

    public List<String> getIngredients(){
        List<String> ingredients = coffee.getIngredients();

        return ingredients;
    }


    public String printCoffee(){

        return coffee.printCoffee();
    }
}
