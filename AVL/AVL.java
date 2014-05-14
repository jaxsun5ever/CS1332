import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A self balancing AVL Tree that can add data, remove data, get a specific node,
 * check if it contains a node, return lists in preorder, inorder, post order,
 * and levelorder, check if it's empty, give its size, clear out the data, and
 * print a string representation of the AVL.
 * 
 * @author Jackson Chan
 *
 * @param <T> The type of data the AVL holds
 */
public class AVL<T extends Comparable<? super T>> implements BSTInterface<T> {
	private int size;
	private Node<T> root;
	
	
	@Override
	public void add(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		} else {
			root = add(root, data);
		}
	}
	
	/**
	 * Recursively adds data to the BST depending on if
	 * it is smaller or larger than the current node
	 * 
	 * @param current Current node you're at
	 * @param data The data to add
	 * @return The node you added
	 */
	private Node<T> add(Node<T> current, T data) {
		if (current == null) {
			size++;
			Node<T> temp = new Node<>(data);
			readjust(temp);
			return temp;
		}
		if (data.compareTo(current.getData()) < 0) {
			current.setLeft(add(current.getLeft(), data));
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRight(add(current.getRight(), data));
		}
		current = rotate(current);
		return current;
	}

	@Override
	public void addAll(Collection<T> c) {
		if (c == null) {
			throw new IllegalArgumentException();
		} else {
			for (T data : c) {
				add(data);
			}
		}
	}

	@Override
	public T remove(T data) {
		T temp;
		if (data == null) {
			throw new IllegalArgumentException();
		} else {
			temp = get(data);
			if (temp != null) {
				root = remove(root, data);
				size--;
			}
		}
		return temp;
	}
	
	/**
	 * Recursively removes a node from the BST and replaces
	 * it with its successor if it has two children
	 * 
	 * @param current Current node you're at
	 * @param data Data you want to remove
	 * @return The node with the data you want to remove
	 */
	private Node<T> remove(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (data.compareTo(current.getData()) < 0) {
			current.setLeft(remove(current.getLeft(), data));
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRight(remove(current.getRight(), data));
		} else {
			if (current.getLeft() != null && current.getRight() != null) {
				Node<T> successor = getMin(current.getRight());
				current.setData(successor.getData());
				current.setRight(remove(current.getRight(), current.getData()));
			} else if (current.getLeft() != null) {
				current = current.getLeft();
			} else if (current.getRight() != null) {
				current = current.getRight();
			} else {
				current = null;
			}
		}
		current = rotate(current);
		return current;
	}
	
	/**
	 * Rotate the node if it is unbalanced
	 * 
	 * @param parent The node to balance
	 * @return The balanced subtree
	 */
	private Node<T> rotate(Node<T> parent) {
		if (parent != null) {
			readjust(parent);
			int balanceFactor = parent.getBalanceFactor();
			Node<T> child;
			if (balanceFactor > 1) { // Left side is heavier
				child = parent.getLeft();
				if (child.getBalanceFactor() < 0) { // LeftRight case
					parent.setLeft(rotateLeft(child));
				}
				parent = rotateRight(parent); // LeftLeft case
			} else if (balanceFactor < -1) {
				child = parent.getRight();
				if (child.getBalanceFactor() > 0) { // RightLeft case
					parent.setRight(rotateRight(child));
				}
				parent = rotateLeft(parent); // RightRight case
			}
		}
		return parent;
	}
	
	/**
	 * Readjusts the height and balance factor for the node
	 * 
	 * @param current The node to readjust
	 */
	private void readjust(Node<T> current) {
		if (current != null) {
			int leftHeight = getHeight(current.getLeft());
			int rightHeight = getHeight(current.getRight());
			current.setHeight(Math.max(leftHeight, rightHeight) + 1);
			current.setBalanceFactor(leftHeight - rightHeight);
		}
	}
	
	/**
	 * Gets the height of the current node
	 * 
	 * @param current The node to calculate height
	 */
	private int getHeight(Node<T> current) {
		/*int height = 0;
		if (current != null) {
			height = current.getHeight();
		}
		return height;*/
		return current == null ? 0 : current.getHeight();
	}

	/**
	 * Rotate the left subtree because it is too long
	 * to correct the balance
	 * 
	 * @param grandParent The node to balance
	 * @return The balanced subtree
	 */
	private Node<T> rotateRight(Node<T> grandParent) {
		Node<T> parent = grandParent.getLeft();
		Node<T> child = null;
		if (parent.getRight() != null) {
			child = parent.getRight();
		}
		grandParent.setLeft(child);
		parent.setRight(grandParent);
		readjust(grandParent);
		readjust(parent);
		return parent;
	}
	
	/**
	 * Rotate the right subtree because it is too long
	 * to correct the balance
	 * 
	 * @param grandParent The node to balance
	 * @return The balanced subtree
	 */
	private Node<T> rotateLeft(Node<T> grandParent) {
		Node<T> parent = grandParent.getRight();
		Node<T> child = null;
		if (parent.getLeft() != null) {
			child = parent.getLeft();
		}
		grandParent.setRight(child);
		parent.setLeft(grandParent);
		readjust(grandParent);
		readjust(parent);
		return parent;
	}

	
	/**
	 * Finds the node with the smallest value in the subtree
	 * 
	 * @param current Root of the subtree
	 * @return Node with the smallest value in that subtree
	 */
	private Node<T> getMin(Node<T> current) {
		if (current.getLeft() == null) {
			return current;
		} else {
			return getMin(current.getLeft());
		}
	}
	
	/**
	 * Finds the node with the largest value in the subtree
	 * 
	 * @param root Root of the subtree
	 * @return Node with the largest value in that subtree
	 */
	private Node<T> getMax(Node<T> current) {
		if (current.getRight() == null) {
			return current;
		} else {
			return getMax(current.getRight());
		}
	}

	@Override
	public T get(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		} else {
			return get(root, data);
		}
	}
	
	/**
	 * Recursively gets the node that contains the data specified
	 * 
	 * @param current The current node you're at
	 * @param data The data you're looking for
	 * @return The data you're looking for or null if not found
	 */
	private T get(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (data.compareTo(current.getData()) < 0) {
			return get(current.getLeft(), data);
		} else if (data.compareTo(current.getData()) > 0) {
			return get(current.getRight(), data);
		} else {
			return current.getData();
		}
	}

	@Override
	public boolean contains(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		} else {
			return contains(root, data) != null;
		}
	}
	
	/**
	 * Recursively looks for the data you specified
	 * 
	 * @param current The current node you're at
	 * @param data The data you're looking for
	 * @return True if the data is found, false if not found
	 */
	private Node<T> contains(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		if (data.compareTo(current.getData()) < 0) {
			return contains(current.getLeft(), data);
		} else if (data.compareTo(current.getData()) > 0) {
			return contains(current.getRight(), data);
		} else {
			return current;
		}
	}

	@Override
	public List<T> preOrder() {
		List<T> linkedList = new LinkedList<>();
		preOrder(root, linkedList);
		return linkedList;
	}
	
	/**
	 * Recursively traverses the BST and adds nodes in preorder
	 * 
	 * @param current Current node you're on
	 * @param list The list to add to
	 */
	private void preOrder(Node<T> current, List<T> list) {
		if (current == null) {
			return;
		}
		list.add(current.getData());
		preOrder(current.getLeft(), list);
		preOrder(current.getRight(), list);
	}

	@Override
	public List<T> inOrder() {
		List<T> linkedList = new LinkedList<>();
		inOrder(root, linkedList);
		return linkedList;
	}
	
	/**
	 * Recursively traverses the BST and adds nodes in inorder
	 * 
	 * @param current Current node you're on
	 * @param list The list to add to
	 */
	private void inOrder(Node<T> current, List<T> list) {
		if (current == null) {
			return;
		}
		inOrder(current.getLeft(), list);
		list.add(current.getData());
		inOrder(current.getRight(), list);
	}

	@Override
	public List<T> postOrder() {
		List<T> linkedList = new LinkedList<>();
		postOrder(root, linkedList);
		return linkedList;
	}

	/**
	 * Recursively traverses the BST and adds nodes in postorder
	 * 
	 * @param current Current node you're on
	 * @param list The list to add to
	 */
	private void postOrder(Node<T> current, List<T> list) {
		if (current == null) {
			return;
		}
		postOrder(current.getLeft(), list);
		postOrder(current.getRight(), list);
		list.add(current.getData());
	}

	@Override
	public List<T> levelOrder() {
		List<T> list = new LinkedList<>();
		levelOrder(root, list);
		return list;
	}
	
	/**
	 * Traverses the BST and adds nodes in levelorder
	 * 
	 * @param node Current node you're on
	 * @param list The list to add to
	 */
	private void levelOrder(Node<T> node, List<T> list) {
		if (node != null) {
			Queue<Node<T>> queue = new LinkedList<>();
			queue.add(node);
			while (!queue.isEmpty()) {
				Node<T> current = queue.poll();
				if (current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				if (current.getRight() != null) {
					queue.add(current.getRight());
				}
				list.add(current.getData());
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}
	
	@Override
	public String toString() {
		if (root == null) {
			return "()";
		}
		return root.toString();
	}

	
	//DO NOT MODIFY OR USE ANY OF THE METHODS BELOW IN YOUR IMPLEMENTATION
	//These methods are for testing purposes only
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
