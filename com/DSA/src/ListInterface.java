public interface ListInterface<T> {

    void add(T data);
    void insert(int index,T data);

    T read(int index,T data);

    boolean remove(int index);

    boolean update(int index,T oldData,T newData);

    boolean isEmpty();
    T get(int index);

    void mergeSort(T list[],int length);
}
