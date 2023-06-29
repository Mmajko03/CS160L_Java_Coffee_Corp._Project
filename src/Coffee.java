/**
 * Coffee
 * This program will act as an interface when creating a coffee.
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */
import java.util.List;
public interface Coffee {

    /**
     * this is a method to be used by all classes that implement this interface
     * this method will return the cost of an enumeration of Syrup, a Coffee decorator, or a
     * coffee.
     * @return
     */
    public double getCost();


    /**
     * this is a method that return a list which would contain the ingredients of a user-selected
     * coffee and the user-selected coffee decorators.
     * @return
     */
    public List<String> getIngredients();

    /**
     * this method, which would be implemented by all classes that will implement this interface,
     * will return a string that would be either the coffee itself or a coffee decorator
     * @return
     */
    public String printCoffee();

}
