package com.src;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DonorSystem {
    public static void main(String[] args) {
        TreeAVL<Donor> donorTree = new TreeAVL<Donor>();
        ArrayList<Donation> donationList = new ArrayList<Donation>();

        Scanner scan = new Scanner(System.in);
        Donor donor = new Donor();
        int option;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Donor donor1 = new Donor("001", "Alice", "123456789", "alice@example.com", "Personal", "001");
        Donor donor2 = new Donor("002", "Bob", "987654321", "bob@example.com", "Public", "002");
        Donor donor3 = new Donor("003", "Charlie", "555555555", "charlie@example.com", "Personal", "003");
        donorTree.insert(donor1);
        donorTree.insert(donor2);
        donorTree.insert(donor3);


        while (true) {
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
                System.out.print("Please Select your option: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scan.next();
                }
                option = scan.nextInt();
                scan.nextLine();
            } while (option < 1 || option > 5);

            // Handle user option
            switch (option) {
                case 1:
                    Donor newDonor = donor.createDonor(donorTree);
                    donorTree.insert(newDonor);
                    System.out.println("New donor created: " + newDonor);
                    break;

                case 2:
                    int readChoice;
                    do {
                        System.out.println("Please select what you want to read: ");
                        System.out.println("1. Read All Donors");
                        System.out.println("2. Read Specific Donor");
                        System.out.println("3. Read with Filter");
                        System.out.println("4. Back to Main Menu");

                        while (!scan.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number between 1 and 4.");
                            scan.next(); // Clear invalid input
                        }
                        readChoice = scan.nextInt();
                        scan.nextLine(); // Clear the buffer

                        if (readChoice < 1 || readChoice > 4) {
                            System.out.println("Unknown choice. Please select again.");
                        }
                    } while (readChoice < 1 || readChoice > 4);

                    switch (readChoice) {
                        case 1:
                            donor.readAllDonors(donorTree);
                            break;
                        case 2:
                            System.out.println("Please enter the donor ID you want to read:");
                            String readDonorID = scan.nextLine();
                            donor.readSpecificDonor(donorTree, readDonorID);
                            break;
                        case 3:
                            System.out.println("Please enter the filter criteria:");
                            String filter = scan.nextLine();
                            donor.readFilteredDonors(donorTree, filter);
                            break;
                        case 4:
                            break; // Back to Main Menu
                    }
                    break;

                case 3:
                    donor.updateDonor(donorTree);
                    break;

                case 4:
                    donor.deleteDonor(donorTree);
                    break;

                case 5:
                    System.out.println("Exiting Donor Management System.");
                    scan.close();
                    System.exit(0); // Exit the program
                    break;
            }

            System.out.println("\nReturning to Main Menu...\n");
        } // End of while loop
    } // End of main
} // End of class
