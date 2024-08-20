package com.src;

import java.util.Objects;
import java.util.Scanner;

public class Donor implements Comparable<Donor> {
    private String donorID;
    private String name;
    private String phoneNumber;
    private String email;
    private String donorType; // e.g., government, private, public
    private String donationKey; // Foreign Key

    // Constructor
    public Donor(String donorID, String name, String phoneNumber, String email, String donorType, String donationKey) {
        this.donorID = donorID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donorType = donorType;
        this.donationKey = donationKey;
    }

    public Donor(){}
    public Donor(String donorID) {
        this.donorID = donorID;
    }

    // Getters for all fields
    public String getDonorID() {return donorID;}
    public String getName() {return name;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmail() {return email;}
    public String getDonorType() {return donorType;}
    public String getDonationKey() {return donationKey;}

    //Setter for all fields
    public void setId(String donorID) {this.donorID = donorID;}
    public void setName(String name) {this.name = name;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setEmail(String email) {this.email = email;}
    public void setDonorType(String donorType) {this.donorType = donorType;}
    public void setDonationKey(String donationKey) {this.donationKey = donationKey;}

    @Override
    public String toString() {
        return "Donor{" +
                "donorID='" + donorID + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", donorType='" + donorType + '\'' +
                ", donationKey='" + donationKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donor donor = (Donor) o;
        return Objects.equals(donorID, donor.donorID);
    }

    @Override
    public int compareTo(Donor anotherDonor) {
        if (this.donationKey == null || anotherDonor.donationKey == null) {
            return this.donationKey == null ? -1 : 1;
        }
        return this.donationKey.compareTo(anotherDonor.getDonationKey());
    }

    public String donorIdGenerator(TreeAVL<Donor> donorTree){
        NodeAVL<Donor> current = donorTree.getRoot();

        //First Insertion
        if (current == null) {return "001";}

        while (current.right != null) {current = current.right;}

        String largestId = current.data.getDonorID();
        int newId = Integer.parseInt(largestId) + 1;
        return String.format("%03d", newId);
    }

    public Donor createDonor(TreeAVL<Donor> donorTree) {
        Scanner scan = new Scanner(System.in);
        String newDonorId = donorIdGenerator(donorTree);

        System.out.println("Please enter your name: ");
        String name = scan.nextLine();

        System.out.println("Please enter your phone number: ");
        String phoneNumber = scan.nextLine();

        System.out.println("Please enter your email: ");
        String email = scan.nextLine();

        String donorType = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please Select your category (1: Personal, 2: Government, 3: Public): ");
            int donorTypeIn;
            try {
                donorTypeIn = scan.nextInt();
                scan.nextLine(); // Clear the newline character
                switch (donorTypeIn) {
                    case 1:
                        donorType = "Personal";
                        validInput = true;
                        break;
                    case 2:
                        donorType = "Government";
                        validInput = true;
                        break;
                    case 3:
                        donorType = "Public";
                        validInput = true;
                        break;
                    default:
                        System.out.println("Unknown choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scan.nextLine(); // Clear the invalid input
            }
        }

        String arrayListKey = newDonorId;
        return new Donor(newDonorId, name, phoneNumber, email, donorType, arrayListKey);
    }

    public void readAllDonors(TreeAVL<Donor> donorTree) {
        System.out.println("\n");
        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
        System.out.println("| Donor ID |       Name       | Phone Number |        Email       | Donor Type | Donation Key |");
        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");

        int count = 0;
        count = readAllDonorsHelper(donorTree.getRoot(), count);

        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
        System.out.println("Total donors: " + count);
    }

    public void readSpecificDonor(TreeAVL<Donor> donorTree, String donorId) {
        Donor donor = donorTree.search(new Donor(donorId));

        if (donor != null) {
            System.out.println("\n");
            System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
            System.out.println("| Donor ID |       Name       | Phone Number |        Email       | Donor Type | Donation Key |");
            System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");

            System.out.printf("| %-8s | %-16s | %-12s | %-18s | %-10s | %-12s |\n",
                    donor.getDonorID(), donor.getName(), donor.getPhoneNumber(),
                    donor.getEmail(), donor.getDonorType(), donor.getDonationKey());

            System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
        } else {
            System.out.println("Donor not found.");
        }
    }

    public void readFilteredDonors(TreeAVL<Donor> donorTree, String filter) {
        System.out.println("\n");
        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
        System.out.println("| Donor ID |       Name       | Phone Number |        Email       | Donor Type | Donation Key |");
        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");

        int count = 0;
        count = readFilteredDonorsHelper(donorTree.getRoot(), count, filter);

        System.out.println("+----------+------------------+--------------+--------------------+------------+--------------+");
        System.out.println("Total filtered donors: " + count);
    }

    private int readFilteredDonorsHelper(NodeAVL<Donor> node, int count, String filter) {
        if (node != null) {
            count = readFilteredDonorsHelper(node.left, count, filter);

            Donor donor = node.data;
            // Assuming you want to filter by donor's ID, name, or another attribute
            if (donor.getDonorID().equals(filter) || donor.getName().equals(filter) ||
                    donor.getPhoneNumber().equals(filter) || donor.getEmail().equals(filter) ||
                    donor.getDonorType().equals(filter)) {

                System.out.printf("| %-8s | %-16s | %-12s | %-18s | %-10s | %-12s |\n",
                        donor.getDonorID(), donor.getName(), donor.getPhoneNumber(),
                        donor.getEmail(), donor.getDonorType(), donor.getDonationKey());
                count++;
            }

            count = readFilteredDonorsHelper(node.right, count, filter);
        }
        return count;
    }

    private int readAllDonorsHelper(NodeAVL<Donor> node, int count) {
        if (node != null) {
            count = readAllDonorsHelper(node.left, count);

            Donor donor = node.data;
            System.out.printf("| %-8s | %-16s | %-12s | %-18s | %-10s | %-12s |\n",
                    donor.getDonorID(), donor.getName(), donor.getPhoneNumber(),
                    donor.getEmail(), donor.getDonorType(), donor.getDonationKey());

            count++;
            count = readAllDonorsHelper(node.right, count);
        }
        return count;
    }

    public void updateDonor(TreeAVL<Donor> donorTree) {
        Scanner scan = new Scanner(System.in);

        String donorId;
        Donor donorToUpdate;

        while (true) {
            System.out.println("Please enter your donorID: ");
            donorId = scan.nextLine();
            donorToUpdate = donorTree.search(new Donor(donorId));

            if (donorToUpdate != null) break;

            System.out.println("Donor not found. Please try again.");
        }

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Please select the data you want to update:");
            System.out.println("1: Name");
            System.out.println("2: Phone Number");
            System.out.println("3: Email");
            System.out.println("4: Donor Type");

            int updateChoice;
            try {
                updateChoice = scan.nextInt();
                scan.nextLine(); // Clear the newline character

                switch (updateChoice) {
                    case 1:
                        System.out.println("Please enter your new name: ");
                        donorToUpdate.setName(scan.nextLine());
                        validChoice = true;
                        break;
                    case 2:
                        System.out.println("Please enter your new phone number: ");
                        donorToUpdate.setPhoneNumber(scan.nextLine());
                        validChoice = true;
                        break;
                    case 3:
                        System.out.println("Please enter your new email: ");
                        donorToUpdate.setEmail(scan.nextLine());
                        validChoice = true;
                        break;
                    case 4:
                        String donorType = null;
                        while (donorType == null) {
                            System.out.println("Please Select your category (1: Personal, 2: Government, 3: Public): ");
                            int donorTypeIn = scan.nextInt();
                            scan.nextLine(); // Clear the newline character

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
                                    System.out.println("Unknown choice. Please try again.");
                            }
                        }
                        donorToUpdate.setDonorType(donorType);
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Unknown choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.nextLine(); // Clear the invalid input
            }
        }

        if (donorTree.update(donorToUpdate)) {
            System.out.println("Donor updated successfully.");
        } else {
            System.out.println("Failed to update donor.");
        }
    }

    public void deleteDonor(TreeAVL<Donor> donorTree) {
        Scanner scan = new Scanner(System.in);

        String donorId;
        Donor donorToDelete;

        while (true) {
            System.out.println("Please enter your donorID: ");
            donorId = scan.nextLine();
            donorToDelete = donorTree.search(new Donor(donorId));

            if (donorToDelete != null) break;

            System.out.println("Donor not found. Please try again.");
        }

        if (donorTree.remove(donorToDelete)) {
            System.out.println("Donor deleted successfully.");
        } else {
            System.out.println("Failed to delete donor.");
        }
    }
}