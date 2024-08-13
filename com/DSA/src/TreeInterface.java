public interface TreeInterface<T extends Comparable<T>> {

        void insert(T data);
        void remove(T data);

        void read();
        boolean update(T data);

        boolean contains(T data);

        boolean equals(Object other);

        boolean isEmpty();

        int size();
}
