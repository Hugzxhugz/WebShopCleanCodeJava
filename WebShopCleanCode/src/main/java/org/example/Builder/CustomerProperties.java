package org.example.Builder;

public class CustomerProperties {

    public String firstName;
    public String lastName;
    public String email;
    public int age;
    public String address;
    public String phoneNumber;


    public CustomerProperties(String firstName, String lastName, String email, int age, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
