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

