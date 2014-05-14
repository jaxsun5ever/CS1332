import java.util.Scanner;

/**
 * Driver class for a doubly linked list Tests adding to front and back,
 * removing from front and back, reversing the list, and listing out the list.
 * 
 * @author Jackson Chan
 */
public class Driver {
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	private static LinkedListInterface<Integer> llist = new DoublyLinkedList<>();

	/**
	 * Print out the main menu
	 */
	private static void mainMenu() {
		/*
		 * System.out.println("Add - Add a node to the list.");
		 * System.out.println("Remove - Remove a node to the list.");
		 * System.out.println("Reverse - Reverse the list");
		 * System.out.println("List - Print out the contents of the list.");
		 * System.out.println("Exit - Quits the program.");
		 */
		System.out.println("The list currently has " + llist.size() + " elements.");
		System.out.print("Enter your command here: ");
	}

	/**
	 * Add an entry to the front or back of the list
	 */
	private static void add() {
		System.out.print("What number would you like to add? ");
		int number = getValidNumber();
		scanner.nextLine(); // removes leftover \n
		System.out.print("Where would you like to add? ");
		String input = addOrRemoveOptions(1);
		boolean error = false;
		switch (input) {
		case "front":
			error = llist.add(0, number);
			break;
		case "back":
			error = llist.add(llist.size(), number);
			break;
		case "index":
			System.out.print("What index would you like to add to? ");
			error = llist.add(getValidNumber(), number);
			scanner.nextLine(); // remove leftover \n
			break;
		default:
			break;
		}
		if (!error) {
			System.out.println("Adding has failed.");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * remove an entry from the front or back or an index
	 */
	private static void remove() {
		System.out.print("Where would you like to remove? ");
		String input = addOrRemoveOptions(0);
		Integer data = null;
		switch (input) {
		case "front":
			data = llist.remove(0);
			break;
		case "back":
			data = llist.remove(llist.size() - 1);
			break;
		case "index":
			System.out.print("What index would you like to remove? ");
			data = llist.remove(getValidNumber());
			scanner.nextLine(); // remove leftover \n
			break;
		case "data":
			System.out.print("What data would you like to remove? ");
			data = llist.remove((Integer) getValidNumber());
			scanner.nextLine(); // removes leftover \n
		default:
			break;
		}
		if (data == null) {
			System.out.println("Removing has failed.");
		} else {
			System.out.println(data + " was removed.");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Reverses the order of the list
	 */
	private static void reverse() {
		if (llist.size() > 0) { 
			llist.reverseList();
			System.out.println("List has been reversed.");
		} else {
			System.out.println("The list is empty");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Prints out the list
	 */
	private static void list() {
		if (llist.size() > 0) {
			System.out.print("List: ");
			for (int i : llist) {
				System.out.print(i + " ");
			}
			System.out.println("");
		} else {
			System.out.println("The list is empty");
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
	}

	/**
	 * Queries the user until an integer is entered.
	 * 
	 * @return The integer the user entered.
	 */
	private static int getValidNumber() {
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Not a number. Please try again.");
		}
		return scanner.nextInt();
	}

	/**
	 * Tests for valid input when adding or removing.
	 * 
	 * @param i 0 means the method was called from remove, anything else will be from add.
	 * @return The valid input choice for adding or removing.
	 */
	private static String addOrRemoveOptions(int i) {
		String input = "";
		boolean isValid = false;
		while (!isValid) {
			input = scanner.nextLine();
			// When this method is called from remove '0' is passed in
			// and adds an extra check and then falls down to the regular case
			switch (i) {
			case 0:
				if (input.equals("data")) {
					isValid = true;
				}
			case 1:
				if (input.equals("front") || input.equals("back") || input.equals("index")) {
					isValid = true;
				}
				break;
			default:
				break;
			}
			if (!isValid) {
				/*
				 * System.out.print("Input is invalid, please enter "); if (i ==
				 * 0) { System.out.print("'data' or "); }
				 * System.out.println("'front' or 'back' or 'index'.");
				 */
				System.out.println("Input is invalid. Please try again.");
			}
		}
		return input;
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
					|| input.equals("reverse") || input.equals("list")
					|| input.equals("exit")) {
				isValid = true;
			} else {
				System.out.println("Input is invalid. Please try again.");
				System.out.println("");
				System.out.println("-----------------------------------------------");
				mainMenu();
			}
		}
		return input;
	}

	/**
	 * Main driver for the linked list. Allows you to add, remove, reverse, or
	 * list for the linked list.
	 * 
	 * @param args
	 *            Unused
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
			case "reverse":
				reverse();
				break;
			case "list":
				list();
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
