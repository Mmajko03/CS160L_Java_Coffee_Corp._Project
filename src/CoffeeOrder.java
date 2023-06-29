import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder{

    private List<Coffee> coffees;
    private LocalDateTime orderDate;

    public CoffeeOrder(){

        coffees = new ArrayList<>();
        orderDate = LocalDateTime.now();
    }

    public CoffeeOrder(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }

    public void addCoffee(Coffee c){

        coffees.add(c);

    }

    public List<Coffee> getCoffees(){

        return coffees;
    }

    public LocalDateTime getOrderDate(){

        return orderDate;
    }

    public double getTotal(){
        double total = 0;

        for (int i=0;i<coffees.size();i++) {
           total += coffees.get(i).getCost();
        }

        return total;
    }

    public String printOrder(){

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mma");
        StringBuilder build = new StringBuilder();
        String order = "ORDER RECEIPT\n";
        order += "Timestamp: " + orderDate.format(timeFormat) + "\n";
        double total = getTotal();


        for (int i=0;i<coffees.size();i++){

            order += "Item " + (i+1) + ": " + coffees.get(i).printCoffee() + " - ";
            double cost = coffees.get(i).getCost();
            build.append(String.format("%.2f", cost));
            String formattedCost = build.toString();
            order += formattedCost + "\n";
            build.setLength(0);

        }

        order += "TOTAL = " + String.format("%.2f",total) + "\n";


        return order;
    }
}
