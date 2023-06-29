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
