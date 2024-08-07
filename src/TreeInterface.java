public interface TreeInterface<K> {
        boolean insert(K key);
        boolean remove(K key); // Remove the entry with the specified key
        void clear(); // Clear all entries
        boolean containsKey(K key); // Check if the map contains the specified key
        boolean isEmpty(); // Check if the map is empty

}
