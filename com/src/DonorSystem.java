package com.src;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DonorSystem {
    public static void main(String[] args) {
        TreeAVL<Donor> donorTree = new TreeAVL<Donor>();
        ArrayList<Donation> donationList = new ArrayList<Donation>();

        Scanner scan = new Scanner(System.in);
        Donor donor= new Donor();
        int option;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("===========================================");
        System.out.println("=   Welcome to Donor Management System    =");
        System.out.println("===========================================");
        System.out.println("=       1.Create a Record                 =");
        System.out.println("=       2.Read Database                   =");
        System.out.println("=       3.Update an Record                =");
        System.out.println("=       4.Delete a Record                 =");
        System.out.println("=       5.Exit                            =");
        System.out.println("===========================================");

        do {
            System.out.println("Please Select your option: ");
            option = scan.nextInt();

            if (option < 1 || option > 5) {System.out.println("Invalid option. Please enter a number between 1 and 5.");}
        } while (option < 1 || option > 5);

        switch (option) {
            case 1:
                Donor newDonor = donor.createDonor(donorTree);
                donorTree.insert(newDonor);
                System.out.println("New donor created: " + newDonor);
                break;
            case 2:
                donorTree.read();
                break;
            case 3:
                donor.updateDonor(donorTree);
                break;
            case 4:
                donor.deleteDonor(donorTree);
                break;
            case 5:
                System.out.println("Exiting Donor Management System.");
                break;
        }//switch
    }//main
}//Class
