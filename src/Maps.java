public interface Maps<K,V> {
        boolean insert(Object key);
        boolean remove(Object key);
        void clear();
        boolean replace(K key,V oldValue,V newValue);
        int containsKey(Object K);
        int containsValues(Object V);
        boolean isEmpty();
        boolean equals(Object o);
        V get(Object key);

    }
