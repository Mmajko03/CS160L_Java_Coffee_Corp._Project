import java.util.ArrayList;
import java.util.List;

public class BlackCoffee implements Coffee{

    public BlackCoffee(){

    }

    public double getCost(){

        return 1.00;
    }

    public List<String> getIngredients(){ //wiwi
        List<String> blackCoffeeIngredients = new ArrayList<>();
        blackCoffeeIngredients.add("Black Coffee");

        return blackCoffeeIngredients;
    }

    @Override
    public String printCoffee(){

        return "A black coffee";
    }
}
