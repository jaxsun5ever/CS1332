import java.util.Collection;

/**
 * A Dynamic Array that can resize dynamically.
 * This array will appear to have infinite capacity
 * 
 * @author Jackson Chan
 */
public class MyDynamicArray<T> implements DynamicArrayInterface<T> {
	private T[] array;
	private int numberOfEntries;
	private static final int INITIAL_CAPACITY = 10;
	
	/**
	 * Constructs a dynamic array with initial capacity of 10
	 */
	@SuppressWarnings("unchecked")
	public MyDynamicArray() {
		array = (T[]) new Object[INITIAL_CAPACITY];
		numberOfEntries = 0;
	}
	
	@Override
	public void add(T toAdd) {
		if (toAdd != null) {
			encureCapacity();
			array[numberOfEntries++] = toAdd;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addAll(Collection<T> collection) {
		if (collection != null) {
			T[] temp = (T[]) collection.toArray();
			for (int i = 0; i < collection.size(); i++) {
				add(temp[i]);
			}
		}
	}

	@Override
	public T remove(T toRemove) {
		T temp = null;
		boolean isRemoved = false;
		int index;
		if (toRemove != null) {
			for (index = 0; !isRemoved && index < numberOfEntries; index++) {
				if (array[index].equals(toRemove)) {
					temp = remove(index);
					isRemoved = true;
				}
			}
		}
		return temp;
	}

	@Override
	public T remove(int index) {
		T temp = null;
		if (index > -1 && index < numberOfEntries) {
			temp = array[index];
			numberOfEntries--;
			shift(index);
		}
		return temp;
	}

	@Override
	public T get(int index) {
		T temp = null;
		if (index > -1 && index < numberOfEntries) {
			temp = array[index];
		}
		return temp;
	}

	@Override
	public boolean contains(T obj) {
		boolean isFound = false;
		if (obj != null) {
			for (int i = 0; !isFound && i < numberOfEntries; i++) {
				if (array[i].equals(obj)) {
					isFound = true;
				}
			}
		}
		return isFound;
	}
	
	@Override
	public T[] toArray() {
		return array;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (T[]) new Object[INITIAL_CAPACITY];
		numberOfEntries = 0;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}
	
	/**
	 * Increases the size of the array to accommodate more entries
	 */
    @SuppressWarnings("unchecked")
	private void encureCapacity() {
        if (numberOfEntries == array.length) {
        	T[] temp = (T[]) new Object[array.length * 2];
        	for (int i = 0; i < numberOfEntries; i++) {
        		temp[i] = array[i];
        	}
        	array = temp;
        }
    }
    
    /**
     * Shifts the entries in the array by one whenever an entry is removed
     * 
     * @param index Where to start the shift
     */
    private void shift(int index) {
		for (; index < numberOfEntries; index++) {
			array[index] = array[index + 1];
		}
		array[numberOfEntries] = null;
    }

}
