/**
 * Node class for the Doubly Linked List
 * The node holds a piece of generic data
 * and references a previous and next node
 * 
 * @author Jackson Chan
 */
public class Node<E> {
	private E data;
	private Node<E> next;
	private Node<E> prev;
	
	/**
	 * Creates a node holding the given data
	 * with no references
	 * 
	 * @param data The data
	 */
	public Node(E data) {
		this.data = data;
		next = null;
		prev = null;
	}
	
	/**
	 * Creates a node holding the given data
	 * and references next and previous nodes
	 * 
	 * @param data The data
	 * @param next The next node
	 * @param prev The previous node
	 */
	public Node(E data, Node<E> next, Node<E> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Get the data held in the node
	 * 
	 * @return data
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set the data in the node
	 * 
	 * @param data The data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get the next node
	 * 
	 * @return The next node
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set the next node
	 * 
	 * @param node Node to set next
	 */
	public void setNext(Node<E> node) {
		this.next = node;
	}

	/**
	 * Get the previous node
	 * 
	 * @return The previous node
	 */
	public Node<E> getPrev() {
		return prev;
	}

	/**
	 * Set the previous node
	 * 
	 * @param node The node to set previous
	 */
	public void setPrev(Node<E> node) {
		this.prev = node;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}