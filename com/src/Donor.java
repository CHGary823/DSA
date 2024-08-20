package com.src;

import java.util.Objects;
import java.util.Scanner;

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

    public Donor(){}

    public Donor(String donorID) {this.donorID = donorID;}

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
    public int compareTo(Donor anotherDonor) {return this.ArrayListKey.compareTo(anotherDonor.getArrayListKey());}

    public String donorIdGenerator(TreeAVL<Donor> donorTree){
        NodeAVL<Donor> current = donorTree.getRoot();

        //First Insertion
        if (current == null) {return "001";}

        while (current.right != null) {current = current.right;}

        String largestId = current.data.getDonorID();
        int newId = Integer.parseInt(largestId) + 1;
        return String.format("%03d", newId);
    }

    public Donor createDonor(TreeAVL<Donor> donorTree){
        Scanner scan = new Scanner(System.in);

        String newDonorId = donorIdGenerator(donorTree);

        System.out.println("Please enter your name: ");
        String name = scan.nextLine();

        System.out.println("Please enter your phone number: ");
        String phoneNumber = scan.nextLine();

        System.out.println("Please enter your email: ");
        String email = scan.nextLine();

        System.out.println("Please Select your category (1: Personal, 2: Government, 3: Public): ");
        int donorTypeIn = scan.nextInt();
        scan.nextLine();

        switch (donorTypeIn) {
            case 1:
                donorType = "Personal" ;
                break;
            case 2:
                donorType = "Government" ;
                break;
            case 3:
                donorType = "Public" ;
                break;
            default: System.out.println("Unknown choices");
        }
        String arrayListKey = newDonorId;
        return new Donor(newDonorId, name, phoneNumber, email, donorType, arrayListKey);
    }

    public void readDonor(TreeAVL<Donor> donorTree){
        Scanner scan = new Scanner(System.in);

    }

    public void updateDonor(TreeAVL<Donor> donorTree) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your donorID: ");
        String donorId = scan.nextLine();

        Donor donorToUpdate = donorTree.search(new Donor(donorId));

        if (donorToUpdate != null) {System.out.println("Donor not found.");}

        System.out.println("Please select the data you want to update:");
        System.out.println("1: Name");
        System.out.println("2: Phone Number");
        System.out.println("3: Email");
        System.out.println("4: Donor Type");

        int updateChoice = scan.nextInt();
        scan.nextLine(); // Clear the newline character

        switch (updateChoice) {
            case 1:
                System.out.println("Please enter your new name: ");
                donorToUpdate.setName(scan.nextLine());
                break;
            case 2:
                System.out.println("Please enter your new phone number: ");
                donorToUpdate.setPhoneNumber(scan.nextLine());
                break;
            case 3:
                System.out.println("Please enter your new email: ");
                donorToUpdate.setEmail(scan.nextLine());
                break;
            case 4:
                System.out.println("Please Select your category (1: Personal, 2: Government, 3: Public): ");
                int donorTypeIn = scan.nextInt();
                scan.nextLine(); // Clear the newline character

                String donorType = null;
                switch (donorTypeIn) {
                    case 1:
                        donorType = "Personal";
                        break;
                    case 2:
                        donorType = "Government";
                        break;
                    case 3:
                        donorType = "Public";
                        break;
                    default:
                        System.out.println("Unknown choice");
                }
                donorToUpdate.setDonorType(donorType);
                break;
            default:
                System.out.println("Unknown choice");
                break;
        }

        // Update the donor in the tree
        if (donorTree.update(donorToUpdate)) {System.out.println("Donor updated successfully.");}
        else {System.out.println("Failed to update donor.");}

    }

    public void deleteDonor(TreeAVL<Donor> donorTree){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your donorID: ");
        String donorId = scan.nextLine();

        Donor donorToDelete = donorTree.search(new Donor(donorId));
        if (donorToDelete != null) {System.out.println("Donor not found.");}
        if(donorTree.remove(donorToDelete)){System.out.println("Donor deleted success.");}
        else {System.out.println("Failed to delete donor.");}
    }
}