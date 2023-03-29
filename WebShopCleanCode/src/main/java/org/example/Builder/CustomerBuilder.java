package org.example.Builder;

import org.example.*;
import org.example.Interface.ICustomerBuilder;

import java.util.ArrayList;

public class CustomerBuilder implements ICustomerBuilder {

    GetInputClass getInputClass = new GetInputClass();

    @Override
    public Customer CreateCustomer() {
        String firstName = SetFirstName();
        String lastName = SetLastName();
        String email = SetEmail();
        int age = SetAge();
        String address = SetAddress();
        String phoneNumber = SetPhoneNumber();
        ArrayList<Order> orders = new ArrayList<>();
        int funds = 0;

        CustomerProperties customerProperties = new CustomerProperties(firstName,
                 lastName, email, age, address,phoneNumber);

        Customer customer = new Customer(null, null, customerProperties);
        return customer;
    }

    public String SetUsername(){
        String username = getInputClass.GetString("Please write your username.");
        return username;
    }

    public String SetPassword(){
        String password = getInputClass.GetString("Please write your password.");
        return password;
    }

    public String SetFirstName(){
        String firstName = getInputClass.GetString("Please write your first name.");
        return firstName;
    }

    public String SetLastName(){
        String lastName = getInputClass.GetString("Please write your last name.");
        return lastName;
    }

    public String SetEmail(){
        String email = getInputClass.GetString("Please write your email.");
        return email;
    }
    public Integer SetAge(){
        int age = getInputClass.GetAnInt("Please write your age.");
        return age;
    }
    public String SetAddress(){
        String address = getInputClass.GetString("Please write your address.");
        return address;
    }
    public String SetPhoneNumber(){
        String phoneNumber = getInputClass.GetString("Please write a number.");
        return phoneNumber;
    }

    public Integer SetFunds(){
        int funds = getInputClass.GetAnInt("How many funds would you like to add?");
        try {
            if (funds < 0) {
                System.out.println("\nDon't add negative amounts.\n");
            } else {
                MenuContextAndProxy.GetInstance().GetLoggedInCustomer().AddFunds(funds);
                System.out.println("\n" + funds + " added to your profile.\n");
                return funds;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nPlease write a number next time.\n");
        }
        return funds;
    }
}
