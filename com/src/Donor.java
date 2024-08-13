package com.src;

import java.util.Objects;

public class Donor implements Comparable<Donor> {
    private String donorID;
    private String name;
    private String phoneNumber;
    private String email;
    private String donorType; // e.g., government, private, public
    private String ArrayListKey; // Foreign Key

    // Constructor
    public Donor(String donorID, String name, String phoneNumber, String email, String donorType, String ArrayListKey) {
        this.donorID = donorID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donorType = donorType;
        this.ArrayListKey = ArrayListKey;
    }

    // Getters for all fields
    public String getDonorID() {
        return donorID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDonorType() {
        return donorType;
    }

    public String getArrayListKey() {
        return ArrayListKey;
    }

    //Setter for all fields


    public void setId(String donorID) {
        this.donorID = donorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public void setArrayListKey(String ArrayListKey) {
        this.ArrayListKey = ArrayListKey;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "id='" + donorID + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", donorType='" + donorType + '\'' +
                ", avlTreeKey='" + ArrayListKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donor donor = (Donor) o;
        return Objects.equals(donorID, donor.donorID) && Objects.equals(name, donor.name) && Objects.equals(phoneNumber, donor.phoneNumber) && Objects.equals(email, donor.email) && Objects.equals(donorType, donor.donorType) && Objects.equals(ArrayListKey, donor.ArrayListKey);
    }

    @Override
    public int compareTo(Donor anotherDonor) {
        return this.ArrayListKey.compareTo(anotherDonor.getArrayListKey());
    }
}