import java.io.*;
import java.util.*;

public class Main {

    private static Map<String, Integer> inventory = new TreeMap<>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();
    private static String logFile = "OrderLog.txt";
    private static String inventoryFile = "Inventory.txt";
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        char choice;

        try {
            inventory = readInventory(inventoryFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        do {
                System.out.println("Please select one of the following menu options:");
                System.out.print("1: New Order\n" + "2: Reload Inventory\n" + "3: Update Inventory\n" + "4: Update Order Log\n" + "5: Exit Application\n");
                choice = scnr.next().charAt(0);
                switch (choice){
                    case '1': // create new order
                        CoffeeOrder order = buildOrder();
                        orders.add(order);
                        System.out.println(order.printOrder());
                        break;
                    case '2': // reload inventory
                        try {
                            inventory = readInventory(inventoryFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(inventory + "\n");
                        break;
                    case '3': // update inventory
                        try {
                            writeInventory(inventoryFile);
                            System.out.println("Inventory written successfully".toUpperCase() + "\n");
                        }

                        catch(IOException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case '4': // update order log
                        writeOrderLog(logFile);
                        System.out.println("Order written succesfully".toUpperCase()+"\n");
                        break;
                    case '5': // exit Application
                        System.out.println("You successfully existed the application".toUpperCase());
                        break;
                    default:
                        System.out.println(("Invalid input, returning to main menu").toUpperCase() + "\n");
                        break;
                }
        }
        while(choice != '5');

    }
    private static Map<String, Integer> readInventory(String filePath) throws IOException {
        Map<String,Integer> filledInventory = new HashMap<>();
        BufferedReader inventoryReader = new BufferedReader(new FileReader(filePath));
        String readerLine;

        while ((readerLine = inventoryReader.readLine()) != null){
            String[] readerParts = readerLine.split("=");
            if (readerParts.length == 2){
                String ingredient = readerParts[0].trim();
                int quantity = Integer.parseInt(readerParts[1].trim());
                filledInventory.put(ingredient,quantity);
            }
        }

        return filledInventory;
    }
    private static void writeInventory(String filePath) throws IOException {

            BufferedWriter orderWriter = new BufferedWriter(new FileWriter(filePath,false));
            for (Map.Entry<String,Integer> ingredientAndQuantity : inventory.entrySet()){
                String ingredient = ingredientAndQuantity.getKey(); // gets ingredient name
                Integer quantity = ingredientAndQuantity.getValue(); // gets ingredient amount

                orderWriter.write(ingredient + " = " + quantity); // writes data to file
                orderWriter.newLine();
            }
            orderWriter.flush(); // forces the buffered writer to write the buffered data to the file
            orderWriter.close(); // closes the buffered writer

    }
    private static List<CoffeeOrder> readOrderLog(String filePath) {
        return null;
    }
    private static void writeOrderLog(String filePath) {


        try (BufferedWriter orderWriter = new BufferedWriter(new FileWriter(filePath, true))){

            for (int i=0;i<orders.size();i++){
                orderWriter.write(orders.get(i).printOrder());
                orderWriter.newLine();
            }

            for (int i=orders.size()-1;i>=0;i--){
                orders.remove(i);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static boolean isInInventory(String i) {
        if (inventory.containsKey(i) && inventory.get(i) > 0 ){
            return true;
        }
        return false;
    }


    private static CoffeeOrder buildOrder(){

        Scanner scnr = new Scanner(System.in);

        Coffee userCoffee;
        CoffeeOrder userOrder = new CoffeeOrder();
        char choice;

        System.out.println("Would you like to add a coffee to your order? Type y for 'yes' or type n for 'no'");
        choice = scnr.next().charAt(0);

        while (choice == 'y'){

            userCoffee = null;

                System.out.println("Which coffee would you like? type e for 'espresso' or type b for 'black coffee'");
                choice = scnr.next().charAt(0);

                switch (choice) {
                    case 'e', 'E':
                        String type = "Espresso";
                        boolean isAvailable;

                        isAvailable = isInInventory(type);
                        if (isAvailable) {
                            userCoffee = new Espresso();
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Espresso in Inventory, returning to main menu\n".toUpperCase());
                            continue;
                        }
                        break;
                    case 'b', 'B':
                         type = "Black Coffee";
                         isAvailable = isInInventory(type);

                        if (isAvailable) {
                            userCoffee = new BlackCoffee();
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Black Coffee in Inventory, returning to Main Menu\n".toUpperCase());
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Not a valid option, would you like to try again? type y for yes n for no");
                        choice = scnr.next().charAt(0);
                        continue;
                }

            System.out.println("Would you like to customize your coffee? Type y for yes or n for no");
            choice = scnr.next().charAt(0);

            while (choice == 'y'){

                System.out.println("Which addon would you prefer? Type s for sugar, m for milk, w for whipped cream, " + "\n" +
                                   "h for hot water, 'a' for mocha flavor, v for vanilla flavor, and/or c for caramel flavor.");
                choice = scnr.next().charAt(0);

                switch (choice){
                    case 's','S':
                        String type = "Sugar";
                        boolean isAvaliable;

                        isAvaliable = isInInventory(type);

                        if (isAvaliable){
                            userCoffee = new WithSugar(userCoffee);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Sugar in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'm','M':
                        type = "Milk";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithMilk(userCoffee);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Milk in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'w','W':
                        type = "Whipped Cream";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithWhippedCream(userCoffee);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Whipped Cream in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'h','H':
                        type = "Hot Water";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithHotWater(userCoffee);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Hot Water in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'a','A':
                        type = "MOCHA Syrup";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithFlavor(userCoffee,Syrup.Mocha);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Mocha Syrup in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'v','V':
                        type = "VANILLA Syrup";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithFlavor(userCoffee,Syrup.Vanilla);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Vanilla Syrup in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    case 'c','C':
                        type = "CARAMEL Syrup";
                        isAvaliable = isInInventory(type);

                        if(isAvaliable){
                            userCoffee = new WithFlavor(userCoffee,Syrup.Caramel);
                            inventory.replace(type, inventory.get(type)-1);
                        }
                        else{
                            System.out.println("Error: No more Caramel Syrup in Inventory\n".toUpperCase());
                            break;
                        }
                        break;
                    default:
                        System.out.println("Invalid input. Would you like to try again? y for yes n for no.");
                        choice = scnr.next().charAt(0);
                        continue;
                }

                System.out.println("Would you like to add more customization? type y for yes or n for no");
                choice = scnr.next().charAt(0);

            }

            userOrder.addCoffee(userCoffee);
            System.out.println("Would you like to create another coffee to add to your order? type y for yes or n for no");
            choice = scnr.next().charAt(0);
            System.out.println();
        }

        return userOrder;
    }
}
