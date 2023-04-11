/*
package org.example;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseCodeToCleanUp {


    public class WebShop {
        boolean running = true;
        Database database = new Database();
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Customer> customers = new ArrayList<Customer>();

        String currentMenu = "main menu";
        int currentChoice = 1;
        int amountOfOptions = 3;
        String option1 = "See Wares";
        String option2 = "Customer Info";
        String option3 = "Login";
        String option4 = "";
        String info = "What would you like to do?";

        String username = null;
        String password = null;
        Customer currentCustomer;

        Scanner scanner = new Scanner(System.in);

        public WebShop() {
            products = database.GetProducts();
            customers = database.GetCustomers();
        }

        public void Run() {
            System.out.println("Welcome to the WebShop!");
            while (running) {
                System.out.println(info);

                if (currentMenu.equals("purchase menu")) {
                    for (int i = 0; i < amountOfOptions; i++) {
                        System.out.println(i + 1 + ": " + products.get(i).getName() + ", " + products.get(i).getPrice() + "kr");
                    }
                    System.out.println("Your funds: " + currentCustomer.getFunds());
                } else {
                    System.out.println("1: " + option1);
                    System.out.println("2: " + option2);
                    if (amountOfOptions > 2) {
                        System.out.println("3: " + option3);
                    }
                    if (amountOfOptions > 3) {
                        System.out.println("4: " + option4);
                    }
                }

                for (int i = 0; i < amountOfOptions; i++) {
                    System.out.print(i + 1 + "\t");
                }
                System.out.println();
                for (int i = 1; i < currentChoice; i++) {
                    System.out.print("\t");
                }
                System.out.println("|");

                System.out.println("Your buttons are Left, Right, OK, Back and Quit.");
                if (currentCustomer != null) {
                    System.out.println("Current user: " + currentCustomer.getUsername());
                } else {
                    System.out.println("Nobody logged in.");
                }

                String choice = scanner.nextLine().toLowerCase();
                switch (choice) {
                    case "left":
                    case "l":
                        if (currentChoice > 1) {
                            currentChoice--;
                        }
                        break;
                    case "right":
                    case "r":
                        if (currentChoice < amountOfOptions) {
                            currentChoice++;
                        }
                        break;
                    case "ok":
                    case "k":
                    case "o":
                        if (currentMenu.equals("main menu")) {
                            switch (currentChoice) {
                                case 1:
                                    option1 = "See all wares";
                                    option2 = "Purchase a ware";
                                    option3 = "Sort wares";
                                    if (currentCustomer == null) {
                                        option4 = "Login";
                                    } else {
                                        option4 = "Logout";
                                    }
                                    amountOfOptions = 4;
                                    currentChoice = 1;
                                    currentMenu = "wares menu";
                                    info = "What would you like to do?";
                                    break;
                                case 2:
                                    if (currentCustomer != null) {
                                        option1 = "See your orders";
                                        option2 = "Set your info";
                                        option3 = "Add funds";
                                        option4 = "";
                                        amountOfOptions = 3;
                                        currentChoice = 1;
                                        info = "What would you like to do?";
                                        currentMenu = "customer menu";
                                    } else {
                                        System.out.println();
                                        System.out.println("Nobody is logged in.");
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    if (currentCustomer == null) {
                                        option1 = "Set Username";
                                        option2 = "Set Password";
                                        option3 = "Login";
                                        option4 = "Register";
                                        amountOfOptions = 4;
                                        currentChoice = 1;
                                        info = "Please submit username and password.";
                                        username = null;
                                        password = null;
                                        currentMenu = "login menu";
                                    } else {
                                        option3 = "Login";
                                        System.out.println();
                                        System.out.println(currentCustomer.getUsername() + " logged out.");
                                        System.out.println();
                                        currentChoice = 1;
                                        currentCustomer = null;
                                    }
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Not an option.");
                                    System.out.println();
                                    break;
                            }
                        } else if (currentMenu.equals("customer menu")) {
                            switch (currentChoice) {
                                case 1:
                                    currentCustomer.PrintOrders();
                                    break;
                                case 2:
                                    currentCustomer.PrintInfo();
                                    break;
                                case 3:
                                    System.out.println("How many funds would you like to add?");
                                    String amountString = scanner.nextLine();
                                    try {
                                        int amount = Integer.parseInt(amountString);
                                        if (amount < 0) {
                                            System.out.println();
                                            System.out.println("Don't add negative amounts.");
                                            System.out.println();
                                        } else {
                                            currentCustomer.addFunds(amount);
                                            System.out.println();
                                            System.out.println(amount + " added to your profile.");
                                            System.out.println();
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println();
                                        System.out.println("Please write a number next time.");
                                        System.out.println();
                                    }
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Not an option.");
                                    System.out.println();
                                    break;
                            }
                        } else if (currentMenu.equals("sort menu")) {
                            boolean back = true;
                            switch (currentChoice) {
                                case 1:
                                    bubbleSort("name", false);
                                    System.out.println();
                                    System.out.println("Wares sorted.");
                                    System.out.println();
                                    break;
                                case 2:
                                    bubbleSort("name", true);
                                    System.out.println();
                                    System.out.println("Wares sorted.");
                                    System.out.println();
                                    break;
                                case 3:
                                    bubbleSort("price", false);
                                    System.out.println();
                                    System.out.println("Wares sorted.");
                                    System.out.println();
                                    break;
                                case 4:
                                    bubbleSort("price", true);
                                    System.out.println();
                                    System.out.println("Wares sorted.");
                                    System.out.println();
                                    break;
                                default:
                                    back = false;
                                    System.out.println();
                                    System.out.println("Not an option.");
                                    System.out.println();
                                    break;
                            }
                            if (back) {
                                option1 = "See all wares";
                                option2 = "Purchase a ware";
                                option3 = "Sort wares";
                                if (currentCustomer == null) {
                                    option4 = "Login";
                                } else {
                                    option4 = "Logout";
                                }
                                amountOfOptions = 4;
                                currentChoice = 1;
                                currentMenu = "wares menu";
                                info = "What would you like to do?";
                            }
                        } else if (currentMenu.equals("wares menu")) {
                            switch (currentChoice) {
                                case 1:
                                    System.out.println();
                                    for (Product product : products) {
                                        product.PrintInfo();
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    if (currentCustomer != null) {
                                        currentMenu = "purchase menu";
                                        info = "What would you like to purchase?";
                                        currentChoice = 1;
                                        amountOfOptions = products.size();
                                    } else {
                                        System.out.println();
                                        System.out.println("You must be logged in to purchase wares.");
                                        System.out.println();
                                        currentChoice = 1;
                                    }
                                    break;
                                case 3:
                                    option1 = "Sort by name, descending";
                                    option2 = "Sort by name, ascending";
                                    option3 = "Sort by price, descending";
                                    option4 = "Sort by price, ascending";
                                    info = "How would you like to sort them?";
                                    currentMenu = "sort menu";
                                    currentChoice = 1;
                                    amountOfOptions = 4;
                                    break;
                                case 4:
                                    if (currentCustomer == null) {
                                        option1 = "Set Username";
                                        option2 = "Set Password";
                                        option3 = "Login";
                                        option4 = "Register";
                                        amountOfOptions = 4;
                                        info = "Please submit username and password.";
                                        currentMenu = "login menu";
                                        currentChoice = 1;
                                    } else {
                                        option4 = "Login";
                                        System.out.println();
                                        System.out.println(currentCustomer.getUsername() + " logged out.");
                                        System.out.println();
                                        currentCustomer = null;
                                        currentChoice = 1;
                                    }
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Not an option.");
                                    System.out.println();
                                    break;
                            }
                        } else if (currentMenu.equals("login menu")) {
                            switch (currentChoice) {
                                case 1:
                                    System.out.println("A keyboard appears.");
                                    System.out.println("Please input your username.");
                                    username = scanner.nextLine();
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("A keyboard appears.");
                                    System.out.println("Please input your password.");
                                    password = scanner.nextLine();
                                    System.out.println();
                                    break;
                                case 3:
                                    if (username == null || password == null) {
                                        System.out.println();
                                        System.out.println("Incomplete data.");
                                        System.out.println();
                                    } else {
                                        boolean found = false;
                                        for (Customer customer : customers) {
                                            if (username.equals(customer.getUsername()) && customer.CheckPassword(password)) {
                                                System.out.println();
                                                System.out.println(customer.getUsername() + " logged in.");
                                                System.out.println();
                                                currentCustomer = customer;
                                                found = true;
                                                option1 = "See Wares";
                                                option2 = "Customer Info";
                                                if (currentCustomer == null) {
                                                    option3 = "Login";
                                                } else {
                                                    option3 = "Logout";
                                                }
                                                info = "What would you like to do?";
                                                currentMenu = "main menu";
                                                currentChoice = 1;
                                                amountOfOptions = 3;
                                                break;
                                            }
                                        }
                                        if (found == false) {
                                            System.out.println();
                                            System.out.println("Invalid credentials.");
                                            System.out.println();
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Please write your username.");
                                    String newUsername = scanner.nextLine();
                                    for (Customer customer : customers) {
                                        if (customer.getUsername().equals(username)) {
                                            System.out.println();
                                            System.out.println("Username already exists.");
                                            System.out.println();
                                            break;
                                        }
                                    }
                                    // Would have liked to be able to quit at any time in here.
                                    choice = "";
                                    boolean next = false;
                                    String newPassword = null;
                                    String firstName = null;
                                    String lastName = null;
                                    String email = null;
                                    int age = -1;
                                    String address = null;
                                    String phoneNumber = null;
                                    while (true) {
                                        System.out.println("Do you want a password? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your password.");
                                                newPassword = scanner.nextLine();
                                                if (newPassword.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want a first name? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your first name.");
                                                firstName = scanner.nextLine();
                                                if (firstName.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want a last name? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your last name.");
                                                lastName = scanner.nextLine();
                                                if (lastName.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want an email? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your email.");
                                                email = scanner.nextLine();
                                                if (email.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want an age? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your age.");
                                                String ageString = scanner.nextLine();
                                                try {
                                                    age = Integer.parseInt(ageString);
                                                } catch (NumberFormatException e) {
                                                    System.out.println();
                                                    System.out.println("Please write a number.");
                                                    System.out.println();
                                                    continue;
                                                }
                                                next = true;
                                                break;
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want an address? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your address.");
                                                address = scanner.nextLine();
                                                if (address.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            next = false;
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }
                                    while (true) {
                                        System.out.println("Do you want a phone number? y/n");
                                        choice = scanner.nextLine();
                                        if (choice.equals("y")) {
                                            while (true) {
                                                System.out.println("Please write your phone number.");
                                                phoneNumber = scanner.nextLine();
                                                if (phoneNumber.equals("")) {
                                                    System.out.println();
                                                    System.out.println("Please actually write something.");
                                                    System.out.println();
                                                    continue;
                                                } else {
                                                    next = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (choice.equals("n") || next) {
                                            break;
                                        }
                                        System.out.println();
                                        System.out.println("y or n, please.");
                                        System.out.println();
                                    }

                                    Customer newCustomer = new Customer(newUsername, newPassword, firstName, lastName, email, age, address, phoneNumber);
                                    customers.add(newCustomer);
                                    currentCustomer = newCustomer;
                                    System.out.println();
                                    System.out.println(newCustomer.getUsername() + " successfully added and is now logged in.");
                                    System.out.println();
                                    option1 = "See Wares";
                                    option2 = "Customer Info";
                                    if (currentCustomer == null) {
                                        option3 = "Login";
                                    } else {
                                        option3 = "Logout";
                                    }
                                    info = "What would you like to do?";
                                    currentMenu = "main menu";
                                    currentChoice = 1;
                                    amountOfOptions = 3;
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Not an option.");
                                    System.out.println();
                                    break;
                            }
                        } else if (currentMenu.equals("purchase menu")) { //note
                            int index = currentChoice - 1;
                            Product product = products.get(index);
                            if (product.InStock()) {
                                if (currentCustomer.CanAfford(product.getPrice())) {
                                    currentCustomer.removeFunds(product.getPrice());
                                    product.decreaseStock();
                                    currentCustomer.getOrders().add(new Order(product.getName(), product.getPrice(), LocalDateTime.now()));
                                    System.out.println();
                                    System.out.println("Successfully bought " + product.getName());
                                    System.out.println();
                                } else {
                                    System.out.println();
                                    System.out.println("You cannot afford.");
                                    System.out.println();
                                }
                            } else {
                                System.out.println();
                                System.out.println("Not in stock.");
                                System.out.println();
                            }
                        }
                        break;
                    case "back":
                    case "b":
                        if (currentMenu.equals("main menu")) {
                            System.out.println();
                            System.out.println("You're already on the main menu.");
                            System.out.println();
                        } else if (currentMenu.equals("purchase menu")) {
                            option1 = "See all wares";
                            option2 = "Purchase a ware";
                            option3 = "Sort wares";
                            if (currentCustomer == null) {
                                option4 = "Login";
                            } else {
                                option4 = "Logout";
                            }
                            amountOfOptions = 4;
                            currentChoice = 1;
                            currentMenu = "wares menu";
                            info = "What would you like to do?";
                        } else {
                            option1 = "See Wares";
                            option2 = "Customer Info";
                            if (currentCustomer == null) {
                                option3 = "Login";
                            } else {
                                option3 = "Logout";
                            }
                            info = "What would you like to do?";
                            currentMenu = "main menu";
                            currentChoice = 1;
                            amountOfOptions = 3;
                        }
                        break;
                    case "quit":
                    case "q":
                        System.out.println("The console powers down. You are free to leave.");
                        return;
                    default:
                        System.out.println("That is not an applicable option.");
                        break;
                }
            }
        }

        private void bubbleSort(String variable, boolean ascending) {
            if (variable.equals("name")) {
                int length = products.size();
                for (int i = 0; i < length - 1; i++) {
                    boolean sorted = true;
                    int length2 = length - i;
                    for (int j = 0; j < length2 - 1; j++) {
                        if (ascending) {
                            if (products.get(j).getName().compareTo(products.get(j + 1).getName()) < 0) {
                                Product temp = products.get(j);
                                products.set(j, products.get(j + 1));
                                products.set(j + 1, temp);
                                sorted = false;
                            }
                        } else {
                            if (products.get(j).getName().compareTo(products.get(j + 1).getName()) > 0) {
                                Product temp = products.get(j);
                                products.set(j, products.get(j + 1));
                                products.set(j + 1, temp);
                                sorted = false;
                            }
                        }
                    }
                    if (sorted == true) {
                        break;
                    }
                }
            } else if (variable.equals("price")) {
                int length = products.size();
                for (int i = 0; i < length - 1; i++) {
                    boolean sorted = true;
                    int length2 = length - i;
                    for (int j = 0; j < length2 - 1; j++) {
                        if (ascending) {
                            if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                                Product temp = products.get(j);
                                products.set(j, products.get(j + 1));
                                products.set(j + 1, temp);
                                sorted = false;
                            }
                        } else {
                            if (products.get(j).getPrice() < products.get(j + 1).getPrice()) {
                                Product temp = products.get(j);
                                products.set(j, products.get(j + 1));
                                products.set(j + 1, temp);
                                sorted = false;
                            }
                        }
                    }
                    if (sorted == true) {
                        break;
                    }
                }
            }
        }
    }

}
*/