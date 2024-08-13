public interface HashInterface<K,V>{
        boolean insert(K key, V value); // Insert a key-value pair
        boolean remove(K key);
        void clear(); // Clear all entries
        boolean replace(K key, V oldValue, V newValue); // Replace old value with new value for a given key
        boolean containsKey(K key);
        boolean containsValue(V value); // Check if the map contains the specified value
        V get(K key); // Get the value associated with the specified key
    }

