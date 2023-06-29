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
