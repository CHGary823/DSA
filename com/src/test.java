package com.src;

import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {

        TreeAVL<Donor> donorTree = new TreeAVL<Donor>();
        ArrayList<Donation> donationList = new ArrayList<Donation>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Add donors to the tree and list
        Donor donor1 = new Donor("001", "Alice", "123456789", "alice@example.com", "private", "001");
        Donor donor2 = new Donor("002", "Bob", "987654321", "bob@example.com", "government", "002");
        Donor donor3 = new Donor("003", "Charlie", "555555555", "charlie@example.com", "public", "003");

        //Donation Example insertion
        Donation donation1 = new Donation("001","11/11/2011",123124.00);
        Donation donation2 = new Donation("002","14/01/2011",1124);
        Donation donation3 = new Donation("004","11/02/2011",1324);
        Donation donation4 = new Donation("003","01/02/2021",11324);


        donorTree.insert(donor1);
        donorTree.insert(donor2);
        donorTree.insert(donor3);


        donationList.add(donation1);
        donationList.add(donation2);
        donationList.add(donation3);
        donationList.insert(0,donation4);

        // Test read and add/insert methods -Success as at 13/8/2024
        donorTree.read();
        donationList.read();





//        System.out.println("Is Donor 'Alice' in the tree? " + donorTree.search(donor1)); // true
//        System.out.println("Is Donor 'David' in the tree? " + donorTree.search(new Donor("004", "David", "444444444", "david@example.com", "private", "004"))); // false
//
//        System.out.println("Remove Donor 'Charlie' from the tree:");
//        donorTree.remove(donor3);
//        donorTree.read(); // Should not include Charlie anymore
//
//        System.out.println("Tree Size: " + donorTree.size()); // Should be 2 after removal
//        System.out.println("Is tree empty? " + donorTree.isEmpty()); // false
//
//        // Test ArrayList methods
//        System.out.println("\nDonorList - All Donors:");
//        for (Donor donor : donationList) {
//            System.out.println(donor);
//        }
//
//        System.out.println("Update Donor 'Bob's phone number:");
//        donor2.setPhoneNumber("111111111");
//        donationList.update(1, donor2, donor2); // Update Bob's phone number
//
//        System.out.println("After update:");
//        for (Donor donor : donationList) {
//            System.out.println(donor);
//        }
//
//        System.out.println("Remove Donor 'Alice' from the list:");
//        donationList.remove(0);
//        for (Donor donor : donationList) {
//            System.out.println(donor);
//        }
//
//        System.out.println("List Size: " + donationList.size()); // Should be 1 after removal
//        System.out.println("Is list empty? " + donationList.isEmpty()); // false
//
//        // MergeSort Test
//        System.out.println("\nTesting Merge Sort on Donor List:");
//        Donor donor4 = new Donor("004", "David", "444444444", "david@example.com", "private", "004");
//        donationList.add(donor4);
//        donationList.mergeSort(donationList.list, donationList.size());
//        for (Donor donor : donationList) {
//            System.out.println(donor);
//        }
            }
        }
