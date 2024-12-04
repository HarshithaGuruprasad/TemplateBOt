import java.util.Scanner;


public class Main {
   private static final String[] misunderstandings = {
       "I'm sorry, I didn't catch that.",
       "Could you say that again?",
       "I'm not sure what you mean.",
       "Can you try asking in a different way?",
       "Hmm, that's beyond my expertise."
   };
   private static final String[] greetings = {
       "Hello! Welcome to Chipotle! How can I help you today?",
       "Hi there, welcome in! What would you like to order?",
       "Hey there! Ready to place your order?"
   };
   private static final String[] goodbye = {
       "Thank you for coming! Have a great day!",
       "Thanks for stopping by! Hope to see you again soon!",
       "Thanks for choosing Chipotle! Have an awesome day!",
       "Have a great one, and enjoy your meal!",
       "Take care! Hope to see you again soon!",
       "Thanks a lot! Enjoy your food, and we will see you next time!"
   };


   private static final Scanner scanner = new Scanner(System.in);
   private static double totalPrice = 0.0;
   private static String orderSummary = "";


   private static final MenuItem[] menuItems = {
       new MenuItem("Taco", 7.99, "Dish"),
       new MenuItem("Burrito", 8.69, "Dish"),
       new MenuItem("Burrito Bowl", 9.49, "Dish"),
       new MenuItem("Smoked Brisket", 4.00, "Protein"),
       new MenuItem("Chicken", 0.00, "Protein"),
       new MenuItem("Steak", 2.00, "Protein"),
       new MenuItem("Beef Barbacoa", 2.00, "Protein"),
       new MenuItem("Carnitas", 0.00, "Protein"),
       new MenuItem("Sofritas", 0.00, "Protein"),
       new MenuItem("White Rice", 0.00, "Carbs"),
       new MenuItem("Brown Rice", 0.00, "Carbs"),
       new MenuItem("Black Beans", 0.00, "Beans"),
       new MenuItem("Pinto Beans", 0.00, "Beans"),
       new MenuItem("Guacamole", 2.95, "Topping"),
       new MenuItem("Mild Salsa", 0.00, "Topping"),
       new MenuItem("Medium Salsa", 0.00, "Topping"),
       new MenuItem("Hot Salsa", 0.00, "Topping"),
       new MenuItem("Corn", 0.00, "Topping"),
       new MenuItem("Sour Cream", 0.00, "Topping"),
       new MenuItem("Cheese", 0.00, "Topping"),
       new MenuItem("Lettuce", 0.00, "Topping"),
       new MenuItem("Queso", 2.10, "Topping"),
       new MenuItem("Chips", 2.50, "Side"),
       new MenuItem("Fountain Drink", 2.15, "Drink")
   };


   public static void main(String[] args) {
       System.out.println(getRandomResponse(greetings));
       while (true) {
           System.out.println("We have Burritos, Tacos, and Burrito Bowls. Which would you prefer?");
           String mainDish = scanner.nextLine().toLowerCase();


           if (mainDish.contains("exit")) {
               System.out.println("Thank you for visiting Chipotle Chatbot. Have a great day!");
               break;
           }


           if (!processMainDish(mainDish)) {
               System.out.println(getRandomResponse(misunderstandings));
           } else {
               System.out.println("Would you like another dish or do you want to check out?");
               String choice = scanner.nextLine().toLowerCase();
               if (choice.contains("check out")) {
                   checkout();
                   break;
               }
           }
       }
       System.out.println(getRandomResponse(goodbye));
   }


   private static boolean processMainDish(String mainDish) {
       for (MenuItem menuItem : menuItems) {
           if (menuItem.getType().equals("Dish") && mainDish.contains(menuItem.getName().toLowerCase())) {
               orderSummary += menuItem.getName() + ", ";
               totalPrice += menuItem.getPrice();
               processDishOptions(menuItem.getName());
               return true;
           }
       }
       return false;
   }


   private static void processDishOptions(String mainDish) {
       System.out.println("Would you like white rice, brown rice, or no rice?");
       String rice = scanner.nextLine().toLowerCase();
       addItemsToOrder(rice);


       System.out.println("What protein would you like? Options: Smoked Brisket, Chicken, Steak, Beef Barbacoa, Carnitas, Sofritas, or none?");
       String protein = scanner.nextLine().toLowerCase();
       addItemsToOrder(protein);


       System.out.println("Would you like black beans, pinto beans, or no beans?");
       String beans = scanner.nextLine().toLowerCase();
       addItemsToOrder(beans);


       System.out.println("Do you want Guacamole, Mild salsa, Medium salsa, Hot salsa, Corn, Sour Cream, Fajitas, Cheese, Lettuce, or Queso?");
       String toppings = scanner.nextLine().toLowerCase();
       addItemsToOrder(toppings);
   }


   private static void addItemsToOrder(String input) {
       for (MenuItem menuItem : menuItems) {
           if (input.contains(menuItem.getName().toLowerCase())) {
               orderSummary += menuItem.getName() + ", ";
               totalPrice += menuItem.getPrice();
           }
       }
   }


   private static void checkout() {
       System.out.println("Here’s your order:");
       System.out.println(orderSummary);
       System.out.println("Your total is $" + totalPrice + ". Chips or a drink for $2 each?");
       String extra = scanner.nextLine().toLowerCase();
       if (extra.contains("chips")) {
           orderSummary += "Chips, ";
           totalPrice += 2.50;
       }
       if (extra.contains("drink")) {
           orderSummary += "Fountain Drink, ";
           totalPrice += 2.00;
       }
       System.out.println("Final Order:");
       System.out.println(orderSummary);
       System.out.println("Your final total is $" + totalPrice + ". Thanks for choosing Chipotle!");
   }


   private static String getRandomResponse(String[] responses) {
       return responses[(int) (Math.random() * responses.length)];
   }
}


class MenuItem {
   private String name;
   private double price;
   private String type;


   public MenuItem(String name, double price, String type) {
       this.name = name;
       this.price = price;
       this.type = type;
   }


   public String getName() {
       return name;
   }


   public double getPrice() {
       return price;
   }


   public String getType() {
       return type;
   }
}




public class MenuItem {
   private String name;
   private double price;
   private String type; // Type of food (e.g., Protein, Beans, Dairy, etc.)


   public MenuItem(String name, double price, String type) {
       this.name = name;
       this.price = price;
       this.type = type;
   }


   public String getName() {
       return name;
   }


   public double getPrice() {
       return price;
   }


   public String getType() {
       return type;
   }
}

