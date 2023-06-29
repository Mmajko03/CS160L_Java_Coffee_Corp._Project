/**
 * CoffeeOrder
 * This class will allow a collection of coffees and their decorators to be printed in a specific time with a specific cost
 * CS160L-1001-1002
 * 6/28/2023
 * @author Maeki Kas Hana
 */

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder{

    private List<Coffee> coffees;
    private LocalDateTime orderDate;

    /**
     * class constructor to initialize the private variables in the class
     */
    public CoffeeOrder(){

        coffees = new ArrayList<>();
        orderDate = LocalDateTime.now();
    }

    /**
     * method whose purpose is to retrieve the current date and time for later use
     * @param orderDate
     */
    public CoffeeOrder(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }

    /**
     * adds the user coffee to the list coffees
     * @param c
     */
    public void addCoffee(Coffee c){

        coffees.add(c);

    }

    /**
     * returns the list coffees
     * @return
     */
    public List<Coffee> getCoffees(){

        return coffees;
    }

    /**
     * returns orderDate which stores the current date and time
     * @return
     */
    public LocalDateTime getOrderDate(){

        return orderDate;
    }

    /**
     * gets the total cost of the coffee(s) and the decorator(s) that the user selected by
     * calling print costs for each coffee in coffees and adding the sum to total
     * @return
     */
    public double getTotal(){
        double total = 0;

        for (int i=0;i<coffees.size();i++) {
           total += coffees.get(i).getCost();
        }

        return total;
    }

    /**
     * prints the user-selected coffee(s) and decorator(s) in addition to the total price and
     * the date and time
     * @return
     */
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
