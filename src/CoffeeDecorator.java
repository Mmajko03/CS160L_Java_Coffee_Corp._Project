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

    /**
     * gets user coffee and passes it as a parameter to later be printed or modified
     * @param c
     */
    public CoffeeDecorator(Coffee c){

        coffee = c;


    }

    /**
     * gets the cost of the coffee selected by the user; implemented throughout the types of Coffees and coffee decorators
     * @return
     */
    public double getCost(){

        return coffee.getCost();
    }

    /**
     * gets ingredients of the coffee and coffee decorators that the user selected; implemented throughout
     * the different types of coffees and throughout all coffee decorators.
     * @return
     */
    public List<String> getIngredients(){
        List<String> ingredients = coffee.getIngredients();

        return ingredients;
    }

    /**
     * prints the user-selected coffee and any of the user selected decorators; used throughout the coffee
     * decorator classes and the coffee classes
     * @return
     */
    public String printCoffee(){

        return coffee.printCoffee();
    }
}
