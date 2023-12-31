package org.bank.people;

public class Owner {

    private int id;
    private String firstName;

    private String lastName;

    public Owner(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getId() {
        return id;
    }
}
