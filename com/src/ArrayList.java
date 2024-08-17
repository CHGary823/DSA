package com.src;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArrayList<T extends Comparable<T>> implements ListInterface<T> ,Iterable<T> {
    //Create a simple list data structure
    int size;
    int capacity = 10;
    T[] list;

    //Constructor
    public ArrayList() {
        this(10);  // Default capacity
    }

    // Constructor with custom capacity
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Comparable[capacity];  // Initialize array with Comparable to match T
    }


    //Add functions
    @Override
    public void add(T data) {
        if (this.size >= this.capacity) {
            this.grow();
        }

        this.list[this.size] = data;
        ++this.size;
    }

    @Override
    public void insert(int index,T data) {
        //Exception throw
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }


        if (this.size >= this.capacity) {this.grow();}

        //Shift elements to the right from the starting position to insert the new data into the list
        for (int i = this.size; i > index; --i) {this.list[i] = this.list[i - 1];}

        this.list[index] = data;
        ++this.size;
    }

    //read
    @Override
    public void read() {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            System.out.println(data);
        }
    }

    //remove functions
    @Override
    public boolean remove(int index) {
        // Return false if index is out of bounds
        if (index < 0 || index >= this.size) {return false;}

        // Shift elements to the left starting from the removal index
        for (int i = index; i < this.size - 1; i++) {this.list[i] = this.list[i + 1];}

        // Remove the last element as it duplicated
        this.list[this.size - 1] = null;
        --this.size;

        //shrink for free space
        if (this.size <= this.capacity / 3) {this.shrink();}
        return true;
    }

    public boolean remove(ArrayList<Donation> donationList,T data){
        boolean removed = false;
        for (int i = 0; i < donationList.size(); i++) {
            Donation donation = donationList.get(i);
            // Assuming you have a way to compare Donation with T
            if (donation.equals(data)) {
                donationList.remove(i);
                removed = true;
                i--; // Decrement index to handle removed element
            }
        }
        return removed;
    }


    //Update
    @Override
    public boolean update(int index,T oldData, T newData) {
        if (index < 0 || index >= this.size) {
            return false; // Index out of bounds
        }

        // Check if the current data at the index matches the provided old data
        if (this.list[index].equals(oldData)) {
            // Update the donor information with the new data
            this.list[index] = newData;
            return true; // Update successful
        }

        // Old data does not match, no update performed
        return false;
    }

    //Search
    public boolean search(ArrayList<Donation> donationList, int index, String values) {
        for (Donation donation : donationList) {
            if (donation == null) continue; // Skip null elements

            String attribute = getAttributeByIndex(donation, index); // Get the attribute by index

            if (attribute != null && attribute.equals(values)) {
                return true; // Match found
            }
        }
        return false;
    }

    private String getAttributeByIndex(Donation donation, int index) {
        switch (index) {
            case 0:
                return donation.getDonationID();
            case 1:
                return donation.getArrayListKey();
            case 2:
                return donation.getDate();
            case 3:
                return String.valueOf(donation.getAmount());
            default:
                return null;
        }
    }

    //List specialize functions - expansion and shrink
    private void grow() {
        int newCapacity = this.capacity * 2;
        T[] newList = (T[]) new Comparable[newCapacity]; // Cast to Comparable

        for (int i = 0; i < this.size; ++i) {
            newList[i] = this.list[i];
        }

        this.capacity = newCapacity;
        this.list = newList;
    }

    private void shrink() {
        int newCapacity = Math.max(this.capacity / 2, 10); // Prevent shrinking below initial capacity
        T[] newList = (T[]) new Comparable[newCapacity]; // Cast to Comparable

        for (int i = 0; i < this.size; ++i) {
            newList[i] = this.list[i];
        }

        this.capacity = newCapacity;
        this.list = newList;
    }


    @Override
    public boolean isEmpty() {return this.size == 0;}


    @Override
    public T get(int index)
    {
        if (index < 0 || index >= this.size)
        {throw new IndexOutOfBoundsException("Index: " + index + "\t Size: " + size);}
        return this.list[index];
    }

    @Override
    public int size(){
        return this.size;
    }


    //Sorting functions
    //@Override
    public void bubbleSort(int index, ArrayList<Donation> donationList, boolean ascending) {
        int n = donationList.size();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Donation donation1 = donationList.get(j);
                Donation donation2 = donationList.get(j + 1);
                boolean shouldSwap = false;

                if (index == 0)
                { // Sort by DonationID
                    shouldSwap = ascending
                            ? donation1.getDonationID().compareTo(donation2.getDonationID()) > 0
                            : donation1.getDonationID().compareTo(donation2.getDonationID()) < 0;
                }
                else if (index == 1)
                { // Sort by ArrayListKey
                    shouldSwap = ascending
                            ? donation1.getArrayListKey().compareTo(donation2.getArrayListKey()) > 0
                            : donation1.getArrayListKey().compareTo(donation2.getArrayListKey()) < 0;
                }
                else if (index == 2)
                { // Sort by Amount
                    shouldSwap = ascending
                            ? donation1.getAmount() > donation2.getAmount()
                            : donation1.getAmount() < donation2.getAmount();
                }
                else if (index == 3)
                { // Sort by Date
                    try {
                        Date date1 = dateFormat.parse(donation1.getDate());
                        Date date2 = dateFormat.parse(donation2.getDate());
                        int comparisonResult = date1.compareTo(date2);
                        shouldSwap = ascending ? comparisonResult > 0 : comparisonResult < 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (shouldSwap)
                {
                    // Correct way to swap without casting issues
                    donationList.set(j, donation2);
                    donationList.set(j + 1, donation1);
                }
            }
        }
    }


    //Set
    public void set(int index, T data) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        this.list[index] = data;
    }





    //Iterator
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // Inner class for the iterator
    private class ListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {return currentIndex < size;}

        @Override
        public T next() {
            if (!hasNext()) {throw new NoSuchElementException();}
            return list[currentIndex++];
        }
    }
}
