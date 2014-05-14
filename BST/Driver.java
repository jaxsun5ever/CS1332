import java.util.List;
import java.util.Scanner;

/**
 * Driver class for Binary Search Trees that tests adding, removing, finding a
 * user, in order traversal and debugging.
 * 
 * @author Jackson Chan
 */
public class Driver {
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	private static BSTInterface<User> bst = new BST<>();

	/**
	 * Prints out the main menu
	 */
	private static void mainMenu() {
		/*
		 * System.out.println("Add - Add a user to the system.");
		 * System.out.println("Remove - Remove a specified user.");
		 * System.out.println("Find - Given a specific username returns the users name.");
		 * System.out.println("List - Displays a list of all users and their usernames sorted alphabetically by username.");
		 * System.out.println("Debug - Prints the BST in nested parenthesized form."
		 * ); System.out.println("Exit - Quits the program.");
		 */
		System.out.print("Please enter a command: ");
	}

	/**
	 * Adds a user to the system
	 */
	private static void add() {
		System.out.print("Please enter a username: ");
		String username = scanner.nextLine();
		System.out.print("Please enter a name: ");
		bst.add(new User(username, scanner.nextLine()));
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Removes the specified user
	 */
	private static void remove() {
		System.out.print("Please enter username you would like to remove: ");
		User temp = bst.remove(new User(scanner.nextLine(), null));
		if (temp == null) {
			System.out.println("User does not exist!");
		} else {
			System.out.println("Remove was successful!");
			System.out.println("User removed was: " + temp.toString());
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Given a specific username, it will find the users name
	 */
	private static void find() {
		System.out.print("Please enter username you would like to find: ");
		User user = bst.get(new User(scanner.nextLine(), null));
		if (user == null) {
			System.out.println("Username not found!");
		} else {
			System.out.println(user.toString());
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");

	}

	/**
	 * Prints out the list
	 */
	private static void list() {
		if (bst.size() > 0) {
			List<User> list = bst.inOrder();
			System.out.println("List of current users:");
			String output = "";
			for (User user : list) {
				output += user.toString() + ", ";
			}
			System.out.println(output.substring(0, output.length() - 2));
		} else {
			System.out.println("The list is empty");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Debugs the BST
	 */
	private static void debug() {
		System.out.println("String representation of the tree:");
		System.out.println(bst.toString());
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Tests for valid input for the main menu
	 * 
	 * @return One of the five possible menu options
	 */
	private static String command() {
		String input = "";
		boolean isValid = false;
		while (!isValid) {
			input = scanner.nextLine();
			if (input.equals("add") || input.equals("remove")
					|| input.equals("find") || input.equals("list")
					|| input.equals("debug") || input.equals("exit")) {
				isValid = true;
			} else {
				System.out.println("Input is invalid. Please try again.");
				System.out.println("");
				System.out
						.println("-----------------------------------------------");
				mainMenu();
			}
		}
		return input;
	}

	/**
	 * Main driver for the Binary Search Tree class. Allows you to
	 * add, remove, find, list users, and to debug the tree
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		while (running) {
			mainMenu();
			String input = command();
			switch (input) {
			case "add":
				add();
				break;
			case "remove":
				remove();
				break;
			case "find":
				find();
				break;
			case "list":
				list();
				break;
			case "debug":
				debug();
				break;
			case "exit":
				running = false;
				break;
			default:
				break;
			}
		}
		scanner.close();
		System.out.println("Goodbye.");
	}
}