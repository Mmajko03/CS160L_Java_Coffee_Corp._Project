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
