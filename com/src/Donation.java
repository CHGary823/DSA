package com.src;
import java.util.Date;
import java.util.Objects;

public class Donation implements Comparable<Donation> {
    private String ArrayListKey;
    private String date;
    private double amount;

    public Donation(String arrayListKey, String date, double amount) {
        ArrayListKey = arrayListKey;
        this.date = date;
        this.amount = amount;
    }

    public String getArrayListKey() {
        return ArrayListKey;
    }

    public void setArrayListKey(String arrayListKey) {
        ArrayListKey = arrayListKey;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "ArrayListKey='" + ArrayListKey + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return amount == donation.amount && Objects.equals(ArrayListKey, donation.ArrayListKey) && Objects.equals(date, donation.date);
    }

    @Override
    public int compareTo(Donation anotherDonation) {
        int result = 0;
        if (this.amount < anotherDonation.getAmount()){result =-1;}
        else if (this.amount > anotherDonation.getAmount()) {result =1;}
        else{result =0;}
        return result;
    }
}
