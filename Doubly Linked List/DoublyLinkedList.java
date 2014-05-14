import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a Doubly LinkedList that has both a head an tail pointer.
 * and size
 * 
 * @author Jackson Chan
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T>, Iterable<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public boolean add(int index, T data) {
		boolean isAdded = false;
		if (data != null) {
			if (isEmpty() && index == 0) {
				head = new Node<>(data, null, null);
				tail = head;
				isAdded = true;
			} else 	if (index == 0) {
				head.setPrev(new Node<>(data, head, null));
				head = head.getPrev();
				isAdded = true;
			} else if (index == size) {
				tail.setNext(new Node<>(data, null, tail));
				tail = tail.getNext();
				isAdded = true;
			} else if (index > 0 && index < size) {
				Node<T> temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
				temp.getPrev().setNext(new Node<>(data, temp, temp.getPrev()));
				temp.setPrev(temp.getPrev().getNext());
				isAdded = true;
			}
		}
		if (isAdded) {
			size++;
		}
		return isAdded;
	}
	
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public boolean contains(Object o) {
		Node<T> temp = head;
		boolean isFound = false;
		if (o != null) {
			while (!isFound && temp != null) {
				if (temp.getData().equals(o)) {
					isFound = true;
				} else {
					temp = temp.getNext();
				}
			}
		}
		return isFound;
	}
	
	@Override
	public T get(int index) {
		Node<T> temp = head;
		T data = null;
		if (index >= 0 && index < size) {
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			data = temp.getData();
		}
		return data;
	}
	
	@Override
	public int indexOf(T data) {
		int index = -1;
		Node<T> temp = head;
		int i = 0;
		boolean isFound = false;
			while (!isFound && temp != null) {
				if (temp.getData().equals(data)) {
					index = i;
					isFound = true;
				} else {
					temp = temp.getNext();
					i++;
				}
			}
		return index;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T remove(Object o) {
		return remove(indexOf((T) o));
	}
	
	@Override
	public T remove(int index) {
		T data = null;
		if (!isEmpty()) {
			if (size == 1 && index == 0) {
				data = head.getData();
				clear();
			} else if (index == 0) {
				data = head.getData();
				head = head.getNext();
				head.setPrev(null);
				size--;
			} else if (index == size - 1) {
				data = tail.getData();
				tail = tail.getPrev();
				tail.setNext(null);
				size--;
			} else if (index > 0 && index < size - 1) {
				Node<T> temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
				data = temp.getData();
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				size--;
			}
		}
		return data;	
	}
	
	@Override
	public T replace(int index, T data) {
		Node<T> temp = head;
		T tempData = null;
			if (index >= 0 && index < size) {
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
				tempData = temp.getData();
				temp.setData(data);
			}
		return tempData;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Node<T> getHead() {
		return head;
	}
	
	@Override
	public void reverseList() {
		Node<T> temp = tail;
		tail = head;
		head = temp;
		if (!isEmpty()) {
			while (temp.getPrev() != null) {
				temp = temp.getPrev();
				temp.getNext().setPrev(temp.getNext().getNext());
				temp.getNext().setNext(temp);

			}
			temp.setPrev(temp.getNext());
			temp.setNext(null);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(head);
	}
	
	
	/**
	 * Private inner class that implements a generic Iterator
	 * that allows you to use a for-each loop on the linked list
	 * 
	 * @author Jackson
	 *
	 * @param <E> The type of data
	 */
	private class MyIterator<E> implements Iterator<E> {
		private Node<E> current;
		
		/**
		 * Create an Iterator that starts at the given node
		 * @param temp The node to start from
		 */
		private MyIterator(Node<E> temp) {
			current = temp;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public E next() {
			if (hasNext()) {
				E data = current.getData();
				current = current.getNext();
				return data;
			} else {
				throw new NoSuchElementException("There are no more elements in the list.");
			}
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException("You can not remove.");
		}
	}
	
	
}