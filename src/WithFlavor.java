import java.util.List;

public class WithFlavor extends CoffeeDecorator {

    private Syrup flavor;

    public WithFlavor (Coffee c, Syrup s){
        super(c);
        flavor = s;
    }

    public double getCost(){

        return super.getCost() + 0.35;
    }

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
