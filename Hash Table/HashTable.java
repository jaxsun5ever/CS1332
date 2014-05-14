import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Generic hash table that uses linear probing to handle collisions.
 * New entries with an already existing key inside the hash table
 * will override the old value.
 * 
 * @author Jackson Chan
 * @author Julia Ting
 * 
 */
public class HashTable<K, V> implements HashTableInterface<K, V> {

	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining max load factor, or when you will
	 * have to regrow the table.
	 */
	private static final double MAX_LOAD_FACTOR = .71;
	
	/**
	 * DO NOT CHANGE THIS NUMBER.
	 * 
	 * This is the constant determining what size you will initialize your
	 * table array to.
	 */
	private static final int INITIAL_CAPACITY = 11;
	
	/**
	 * The number of entries in the table.
	 */
	private int size;
	
	/**
	 * The backing array of your hash table.
	 */
	private MapEntry<K, V>[] table;
	
	/**
	 * Initialize the backing array to the initial capacity and the size
	 * to the appropriate starting size.
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		table = (MapEntry<K, V>[]) new MapEntry[INITIAL_CAPACITY];
		size = 0;
	}
	
	@Override
	public V put(K key, V value) {
		if (value == null || key == null) {
			throw new IllegalArgumentException();
		}
		regrow();
		V oldValue = add(key, value);
		return oldValue;
	}
	
	/**
	 * Adds and entry to the hash table. If the key
	 * already exists then replace the old value
	 * with the new one. If a collision occurs then
	 * place it in the next open entry via linear 
	 * probing.
	 * 
	 * @param key The key of the entry
	 * @param value The value of the entry
	 * @return The old value it replaced
	 */
	private V add(K key, V value) {
		int index = Math.abs(key.hashCode()) % table.length;
		V oldValue = null;
		int duplicateKeyIndex = keyIndexFinder(key);
		if (duplicateKeyIndex != -1) {
			oldValue = table[duplicateKeyIndex].getValue();
			table[duplicateKeyIndex].setValue(value);
		} else {
			while (table[index] != null && !table[index].isRemoved()) {
				index = ++index % table.length;
			}
			table[index] = new MapEntry<K, V>(key, value);
			size++;
		}
		return oldValue;
	}
	
	/**
	 * Resizes the hash table to accommodate new entries
	 * and keep collisions at a minimum 
	 */
	@SuppressWarnings("unchecked")
	private void regrow() {
		double loadFactor = (size + 1) / (double) table.length;
		if (loadFactor > MAX_LOAD_FACTOR) {
			MapEntry<K, V>[] oldTable = table;
			table = (MapEntry<K, V>[]) new MapEntry[(oldTable.length * 2) + 1];
			size = 0;
			for (MapEntry<K, V> entry : oldTable) {
				if (entry != null && !entry.isRemoved()) {
					add(entry.getKey(), entry.getValue());
				}
			}
		}
	}

	@Override
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		V value = null;
		int index = Math.abs(key.hashCode()) % table.length;
		boolean isFound = false;
		while (!isFound && table[index] != null) {
			if (!table[index].isRemoved() && key.equals(table[index].getKey())) {
				value = table[index].getValue();
				isFound = true;
			} else {
				index = ++index % table.length;
			}
		}
		return value;
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		V value = null;
		int index = Math.abs(key.hashCode()) % table.length;
		boolean isFound = false;
		while (!isFound && table[index] != null) {
			if (!table[index].isRemoved() && key.equals(table[index].getKey())) {
				value = table[index].getValue();
				table[index].setRemoved(true);
				size--;
				isFound = true;
			} else {
				index = ++index % table.length;
			}
		}
		return value;
	}

	@Override
	public boolean contains(V value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		int index = 0;
		boolean isFound = false;
		while (!isFound && index < table.length) {
			if (table[index] != null && !table[index].isRemoved()) {
				if (value.equals(table[index].getValue())) {
					isFound = true;
				}
			}
			index++;
		}
		return isFound;
	}

	@Override
	public boolean containsKey(K key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		return keyIndexFinder(key) != -1;
	}
	
	/**
	 * Gets the index of the key if it exists in the table.
	 * Returns -1 if key is not found. Helps prevent duplicate keys.
	 * 
	 * @param key The key you're looking for
	 * @return The index the key is in
	 */
	private int keyIndexFinder(K key) {
		int index = Math.abs(key.hashCode()) % table.length;
		boolean isFound = false;
		int keyIndex = -1;
		while (!isFound && table[index] != null) {
			if (!table[index].isRemoved() && key.equals(table[index].getKey())) {
				keyIndex = index;
				isFound = true;
			} else {
				index = ++index % table.length;
			}
		}
		return keyIndex;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (MapEntry<K, V> entry : table) {
			if (entry != null && !entry.isRemoved()) {
				set.add(entry.getKey());
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Collection<V> collection = new ArrayList<V>();
		for (MapEntry<K, V> entry : table) {
			if (entry != null && !entry.isRemoved()) {
				collection.add(entry.getValue());
			}
		}
		return collection;
	}

	@Override
	public Set<MapEntry<K, V>> entrySet() {
		Set<MapEntry<K, V>> set = new HashSet<MapEntry<K, V>>();
		for (MapEntry<K, V> entry : table) {
			if (entry != null && !entry.isRemoved()) {
				set.add(entry);
			}
		}
		return set;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		table = (MapEntry<K, V>[]) new MapEntry[INITIAL_CAPACITY];
		size = 0;
	}

}
