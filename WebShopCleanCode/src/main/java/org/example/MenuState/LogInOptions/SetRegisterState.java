package org.example.MenuState.LogInOptions;

import org.example.*;
import org.example.Abstract.MenuStateFactory;
import org.example.Builder.CustomerBuilder;
import org.example.Builder.CustomerProperties;
import org.example.Commands.MoveToMenuCommands.MoveToMainMenuCommand;

public class SetRegisterState extends MenuStateFactory {

    public boolean check = false;
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    int age;
    String address;
    String phoneNumber;

    CustomerBuilder builder = new CustomerBuilder();
    GetInputClass getInputClass = new GetInputClass();

    public SetRegisterState(){
        this.currentMenu = "Register Menu";
    }



    @Override
    public void DisplayMenu() {

        username = builder.SetUsername();
        password = GetUserPassword();
        firstName = GetFirstName();
        lastName = GetLastName();
        email = GetEmail();
        age = GetAge();
        address = GetAddress();
        phoneNumber = GetPhoneNumber();

        CustomerProperties customerProperties = new CustomerProperties(firstName,
                lastName, email, age, address,phoneNumber);
        Customer newCustomer = new Customer(username, password, customerProperties);

        System.out.println("\n" + newCustomer.GetUsername() + " successfully added and is now logged in.\n");

        MenuContextAndProxy context = MenuContextAndProxy.GetInstance();
        context.addToCustomerList(newCustomer);
        context.SetLoggedInCustomer(newCustomer);

        new MoveToMainMenuCommand().Execute();

    }

    private String GetUserPassword() {
        check = getInputClass.getYesNo("Do you want a password? y/n");
        if (check){
            return password = builder.SetPassword();
        }
        return password = null;
    }

    private String GetFirstName() {
        check = getInputClass.getYesNo("Do you want a first name? y/n");
        if (check){
            return firstName = builder.SetFirstName();
        }
        return firstName = null;
    }

    private String GetLastName() {
        check = getInputClass.getYesNo("Do you want a last name? y/n");
        if (check){
            return lastName = builder.SetLastName();
        }
        return lastName = null;
    }

    private String GetEmail() {
        check = getInputClass.getYesNo("Do you want an email? y/n");
        if (check){
            return email = builder.SetEmail();
        }
        return email = null;
    }

    private int GetAge() {
        check = getInputClass.getYesNo("Do you want an age? y/n");
        if (check){
            return age = builder.SetAge();
        }
        return -1;
    }

    private String GetAddress() {
        check = getInputClass.getYesNo("Do you want an address? y/n");
        if (check){
            return address = builder.SetAddress();
        }
        return address = null;
    }

    private String GetPhoneNumber() {
        check = getInputClass.getYesNo("Do you want a phone number? y/n");
        if (check){
            return phoneNumber = builder.SetPhoneNumber();
        }
        return phoneNumber = null;
    }


}
