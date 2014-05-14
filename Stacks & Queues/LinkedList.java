/**
 * Generic Linked list with a head and tail 
 * reference that keeps track of its size
 * 
 * @author Jackson
 *
 * @param <T> Type of data the Linked List stores
 */
public class LinkedList<T> implements LinkedListInterface<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	@Override
	public void addToFront(T t) {
		Node<T> temp = new Node<>(t);
		if (size == 0) { // list is empty
			head = temp;
			tail = temp;
		} else { // list has one entry or more
			temp.next = head;
			head = temp;
		}
		size++;
	}

	@Override
	public void addToBack(T t) {
		Node<T> temp = new Node<>(t);
		if (size == 0) { // list is empty
			head = temp;
			tail = temp;
		} else { // list has one entry or more
			tail.next = temp;
			tail = temp;
		}
		size++;
	}

	@Override
	public T removeFromFront() {
		Node<T> temp = null;
		if (size != 0) { // if list is not empty grab head
			temp = head;
			if (size == 1) { // if list has 1 entry null out head and tail
				head = null;
				tail = null;
			} else { // if list has more than one entry, scoot it down
				head = head.next;
			}
			size--;
			return temp.data;
		} else {	//list had no entries
			return null;
		}
	}

	@Override
	public T removeFromBack() {
		Node<T> temp = null;
		if (size != 0) { // if list is not empty grab head
			if (size == 1) { // if list has 1 entry null out head and tail
				temp = tail;
				head = null;
				tail = null;
			} else { // if list has more than one entry, scoot it down
				temp = head;
				while (temp.next != tail) { // gets 2nd to last entry
					temp = temp.next;
				}
				tail = temp;
				temp = tail.next;
				tail.next = null;
			}
			size--;
			return temp.data;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toList() {
		Node<T> temp = null;
		T[] tempArray = (T[]) new Object[size];
		if (size > 0) {
			temp = head;
			for (int i = 0; i < size; i++) {
				tempArray[i] = temp.data;
				temp = temp.next;
			}
		}
		return tempArray;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public T getTail() {
		return tail.data;
	}

	/**
	 * The node class. Remember that this is a singularly linked list.
	 * 
	 * @author Steven Wojcio
	 */
	private class Node<T> {
		private Node<T> next;
		private T data;

		/**
		 * Creates a node with the specified data.
		 * 
		 * @param data The data you want to store
		 */
		private Node(T data) {
			this(null, data);
		}

		/**
		 * Creates a node with the specified data
		 * that points to the node you specify.
		 * 
		 * @param next The node you specified.
		 * @param data The data you want to store.
		 */
		private Node(Node<T> next, T data) {
			this.next = next;
			this.data = data;
		}
	}

}
