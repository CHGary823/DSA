import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T extends Comparable<T>> implements ListInterface<T> ,Iterable<T> {
    //Create a simple list data structure
    int size;
    int capacity = 10;
    T[] list;

    //Constructor
    public ArrayList() {this.list = (T[]) new Object[this.capacity];}

    //Constructor with custom capacity
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Object[capacity];
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
    public T read(int index,T data)
    {
            if (index < 0 || index >= this.size) {throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);}
            return this.list[index];
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

    //List specialize functions - expansion and shrink
    private void grow() {
        int newCapacity = this.capacity * 2;
        T[] newList = (T[]) new Object[newCapacity];

        for(int i = 0; i < this.size; ++i) {
            newList[i] = this.list[i];
        }

        this.capacity = newCapacity;
        this.list = newList;
    }

    private void shrink() {
        int newCapacity = this.capacity / 2;
        T[] newList = (T[]) new Object[newCapacity];

        for(int i = 0; i < this.size; ++i) {
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

    //Sorting functions
    @Override
    public void mergeSort(T[] list, int length) {
        if (length <= 1) return;

        int middle = length / 2;
        T[] leftList = (T[]) new Comparable[middle];
        T[] rightList = (T[]) new Comparable[length - middle];

        System.arraycopy(list, 0, leftList, 0, middle);
        System.arraycopy(list, middle, rightList, 0, length - middle);

        mergeSort(leftList, middle);
        mergeSort(rightList, length - middle);
        merge(leftList, rightList, list);
    }

    public void merge(T[] leftList, T[] rightList, T[] list) {
        int leftSize = leftList.length;
        int rightSize = rightList.length;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftList[l].compareTo(rightList[r]) < 0) {
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
    }//Merge Sort - merge function

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
