package org.bank.people;

public class Owner {
    private String firstName;
    private String lastName;

    public Owner(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
