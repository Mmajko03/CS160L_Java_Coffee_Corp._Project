import java.util.List;

public class WithSugar extends CoffeeDecorator {

    public WithSugar(Coffee c){
        super(c);

    }

    public double getCost(){

        return super.getCost() + 0.15;
    }

    public List<String> getIngredients(){

        List<String> Ingredients = super.getIngredients();
        Ingredients.add("Sugar");

        return Ingredients;
    }
    @Override
    public String printCoffee(){

        return super.printCoffee() + " with sugar";
    }
}
