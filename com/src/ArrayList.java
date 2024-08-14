package com.src;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    @Override
    public void mergeSort(int index, int length) {
        int middle = length / 2;
        T[] leftList = (T[]) new Comparable[middle];
        T[] rightList = (T[]) new Comparable[length - middle];

        System.arraycopy(list, 0, leftList, 0, middle);
        System.arraycopy(list, middle, rightList, 0, length - middle);

        mergeSort(index, middle);
        mergeSort(index, length - middle);
        merge(leftList, rightList, list, index);
    }

    public void merge(T[] leftList, T[] rightList, T[] list, int index) {
        int leftSize = leftList.length;
        int rightSize = rightList.length;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (compareByIndex(leftList[l], rightList[r], index) < 0) {
                list[i++] = leftList[l++];
            } else {
                list[i++] = rightList[r++];
            }
        }

        while (l < leftSize) {
            list[i++] = leftList[l++];
        }

        while (r < rightSize) {
            list[i++] = rightList[r++];
        }
    }

    private int compareByIndex(T left, T right, int index) {
        Donation leftDonation = (Donation) left;
        Donation rightDonation = (Donation) right;

        String leftAttribute = getAttributeByIndex(leftDonation, index);
        String rightAttribute = getAttributeByIndex(rightDonation, index);

        return leftAttribute.compareTo(rightAttribute);
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
