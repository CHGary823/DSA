package com.src;
public interface ListInterface<T> {

    void add(T data);
    void insert(int index,T data);

    void read();

    boolean remove(int index);


    boolean update(int index,T oldData,T newData);

    boolean isEmpty();
    T get(int index);
    int size();
}