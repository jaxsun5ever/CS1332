import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A Binary Search Tree that can add data, remove data, get a specific node,
 * check if it contains a node, return lists in preorder, inorder, post order,
 * and levelorder, check if it's empty, give its size, clear out the data, and
 * print a string representation of the BST.
 * 
 * @author Jackson Chan
 *
 * @param <T> The type of data the BST holds
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
	private Node<T> root;
	private int size;

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
			return new Node<>(data);
		}
		if (data.compareTo(current.getData()) < 0) {
			current.setLeft(add(current.getLeft(), data));
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRight(add(current.getRight(), data));
		}
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
		return current;
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
}
