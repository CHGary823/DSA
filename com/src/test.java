package com.src;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class test {
    public static void main(String[] args) throws Exception{

        TreeAVL<Donor> donorTree = new TreeAVL<Donor>();
        ArrayList<Donation> donationList = new ArrayList<Donation>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Add donors to the tree and list
        Donor donor1 = new Donor("001", "Alice", "123456789", "alice@example.com", "private", "001");
        Donor donor2 = new Donor("002", "Bob", "987654321", "bob@example.com", "government", "002");
        Donor donor3 = new Donor("003", "Charlie", "555555555", "charlie@example.com", "public", "003");

        //Donation Example insertion
        Donation donation1 = new Donation("D001","001","11/11/2011",123124.00);
        Donation donation2 = new Donation("D002","003","14/01/2011",1124);
        Donation donation3 = new Donation("D004","002","11/02/2011",1324);
        Donation donation4 = new Donation("D003","001","01/02/2021",11324);


        donorTree.insert(donor1);
        donorTree.insert(donor2);
        donorTree.insert(donor3);


        donationList.add(donation1);
        donationList.add(donation2);
        donationList.add(donation3);
        donationList.insert(0,donation4);

        // Test read and add/insert methods -Success as at 13/8/2024
        donorTree.read();

        System.out.println("Should clear");
        donationList.read();

        //Search Test
        boolean found = donationList.search(donationList, 1, "001");
        System.out.println("Is ArrayListKey ID '001' found? " + found);

        System.out.println("Search donor 1 true? " + donorTree.search(donor1));

        //Remove test
        donorTree.remove(donor3);
        donorTree.read();

        donationList.remove(donationList,donation4);
        donationList.read();

        //Donor Tree size and is Empty size
        System.out.println("Tree Size: " + donorTree.size()); // Should be 2 after removal
        System.out.println("Is tree empty? " + donorTree.isEmpty()); // false

        System.out.println("List Size: " + donationList.size());
        System.out.println(donationList.isEmpty());

        //Array List Update
        System.out.println("Update Donor 'Bob's phone number:");
        Donation newData = new Donation("D002","003","14/01/2011",331224);
        donationList.update(1, donation2, newData); // Update Bob's phone number
        donationList.read();


        // MergeSort Test
        System.out.println("\nTesting Merge Sort on Donor List:");
        Donation donation5 = new Donation("D005","002","21-11-2005",9999);
        donationList.add(donation5);

        donationList.read();

        System.out.println("\nTesting removeALL on Donor List:");
        donationList.removeAll(donationList);

        donationList.read(); // Should be empty
    }//main

}//test
