/**
 * This class implements the bag interface.
 * Can do things that you would expect to do
 * on a bag.
 * 
 * @author Jackson Chan
 */

import java.util.ArrayList;
import java.util.Random;


public class ArrayListBag<T> implements BagInterface<T> {
	private ArrayList<T> list;
	
	/**
	 * Constructor that initializes an
	 * array list of a generic type.
	 */
	public ArrayListBag() {
		list = new ArrayList<T>();
	}
	
	@Override
	public int getCurrentSize() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return getCurrentSize() == 0;
	}

	@Override
	public boolean add(T newEntry) {
		return list.add(newEntry);
	}

	@Override
	public T remove() {
		return list.remove(new Random().nextInt(getCurrentSize()));
	}

	@Override
	public boolean remove(T anEntry) {
		return list.remove(anEntry);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		for (T obj : list)
			if (obj.equals(anEntry))
				count++;
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[])list.toArray();
	}

}
