import java.util.List;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee c){

        coffee = c;


    }

    public double getCost(){

        return coffee.getCost();
    }

    public List<String> getIngredients(){
        List<String> ingredients = coffee.getIngredients();

        return ingredients;
    }


    public String printCoffee(){

        return coffee.printCoffee();
    }
}
