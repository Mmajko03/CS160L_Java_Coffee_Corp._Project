# CS160L_Java_Coffee_Corp._Project
When run, the application will prompt the user to choose from several options, in which the user would be allowed to create a coffee order, update the order log, update the ingredient inventory, and exit the application. When creating the order, the user can select from a few different coffees and the user will also be given the choice to add customizations to these coffees. After the user is done creating their coffee, the user is then asked if they would want to finalize their order or to add another coffee to the order.

The application has several files/classes created and implemented in order for this procces to work.

Coffee Interface File --> This file allows all the other file that are implementing this class to use specific methods such as
getCost(), printCoffee(), and/or getIngredients().

BlackCoffee File --> This is a file that will allow the user to print a coffee called a black coffee. The user will also be able to print the cost and ingredients of the black coffee object.

Espresso File --> This file, similar to the BlackCoffee file, will create a coffee called Espresso and invoke some methods that will get the cost of Espresso, get the ingredients, and print the coffee object.

CoffeeDecorator File --> This file will be extended by other files and act as a super class to CoffeeDecorator sub-classes. These sub-classses would be able to pass modified coffee objects to the super class and invoke several methods to get the cost, print the coffee, and/or get the ingredients. 

CoffeeOrder File --> This file will print the order that the user has created in the main menu along with the total cost of all the items, such as the coffee decorators and coffee objects, in addition to the date and time of when the order was created.

Main File --> This is the file that will act as the driver of the program. This file, in addition to the main method, has other methods to manipulate an inventory of ingredients as well as write an order log og of the user's orders. Another method that this file has allows it to build a coffee order with regard to the user's choices.

Syrup File --> This file will hold enumeration variables to be used in the WithFlavor file. These enums will act as addtional coffee decorators.

WithFlavor File --> This file acts as one of the coffee decorator classes but it instead it uses enumeration variables instead of having its own preset variable. This file is able to get the cost of these enums, as well as the ingredients. This file can also print these enums in addition to coffes objects

WithHotWater File --> 

WithMilk File --> 

WithSugar File --> 

WithWhippedCream File --> 
