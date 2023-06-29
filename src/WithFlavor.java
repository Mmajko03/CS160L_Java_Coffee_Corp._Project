/**
 * WithFlavor
 * A Coffee Decorator sub-class that adds syrup enum values to a user's coffee
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.util.List;

public class WithFlavor extends CoffeeDecorator {

    private Syrup flavor;

    /**
     * takes in a user-selected enumeration from Syrup and a user-selected coffee object as parameter
     * flavor is assigned with an enumeration from the Syrup class
     * the coffee object is being passed to the super class, thereby invoking the
     * super class constructor and passing the coffee object as a parameter
     * @param c
     * @param s
     */
    public WithFlavor (Coffee c, Syrup s){
        super(c);
        flavor = s;
    }

    public double getCost(){

        return super.getCost() + 0.35;
    }

    /**
     * gets the ingredients of the enumeration and passes it to its superclass
     * @return
     */
    public List<String> getIngredients(){

        List<String> Ingredients = super.getIngredients();
        Ingredients.add(String.valueOf(flavor));

        return Ingredients;
    }

    @Override
    public String printCoffee(){

        return super.printCoffee() + " with " + flavor + " flavor";

    }
}
