package com.example.myapplication;

public class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String dob;

    public Contact(String name, String phoneNumber, String address, String dob) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Character getProfileLetter() {
        return name.charAt(0);
    }

    public String getDob() {
        return dob;
    }


}
