import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is where you will put your main method. For
 * instructions on how to create it, refer to the PDF for
 * this homework assignment.
 * 
 * @author Steven Wojcio
 *
 */
public class AmusementPark {

	// Leave this variable alone. It is necessary for compilation.
	public static int ticketNumber = 1000;
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	private static QueueInterface<Patron> queue = new Queue<>();
	private static StackInterface<Ticket> stack = new Stack<>();
	private static ArrayList<Patron> list = new ArrayList<>();

	/**
	 * Print out the main menu
	 */
	private static void mainMenu() {
		System.out.println("Add patron to the back of the line.");
		System.out.println("1: Add patron to the back of the line.");
		System.out.println("2: Put a ticket in the pile");
		System.out.println("3: Get the number of patrons in line.");
		System.out.println("4: Get the number of available tickets");
		System.out.println("5: Administer a ticket");
		System.out.println("6: Show patrons with tickets");
		System.out.println("7: Quit");
		System.out.print("Enter your choice (1-7) here: ");
	}

	/**
	 * Add a patron to the back of the line
	 */
	private static void addPatronToLine() {
		scanner.nextLine(); // removes leftover \n due to main method's scanner
		System.out.println("What would you like to name your patron?");
		queue.enqueue(new Patron(scanner.nextLine()));
	}

	/**
	 * Put a ticket in the pile
	 */
	private static void putTicketInPile() {
		stack.push(new Ticket());
	}

	/**
	 * Get the number of patrons in line
	 */
	private static void getNumberOfPatrons() {
		System.out.println("The number of patrons in line is: " + queue.size());
	}

	/**
	 * Get the number of available tickets
	 */
	private static void getNumberOfTickets() {
		System.out.println("The number of tickets in the pile is: " + stack.size());
	}

	/**
	 * Administer a ticket
	 */
	private static void administerTicket() {
		Patron patron = null;
		if (queue.size() > 0 && stack.size() > 0) {
			patron = queue.dequeue();
			patron.giveTicket(stack.pop());
			list.add(patron);
		} else {
			if (queue.size() == 0) {
				System.out.println("There are no more patrons in line.");
			} else {
				System.out.println("There are no more tickets.");
			}
		}
	}

	/**
	 * Show patrons with tickets
	 */
	private static void showPatronsWithTickets() {
		for (Patron patty : list) {
			System.out.println(patty.toString());
		}
	}

	/**
	 * Main driver for the amusement park, allows you to
	 * add a patron to the line, put a ticket in the pile,
	 * get the number of patrons, get the number of tickets,
	 * administer a ticket, and show all the patrons with tickets
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		while (running) {
			System.out.println("-----------------------------------------------");
			System.out.println("");
			mainMenu();
			while (!scanner.hasNextInt()) {
				scanner.next();
			}
			switch (scanner.nextInt()) {
			case 1:
				addPatronToLine();
				break;
			case 2:
				putTicketInPile();
				break;
			case 3:
				getNumberOfPatrons();
				break;
			case 4:
				getNumberOfTickets();
				break;
			case 5:
				administerTicket();
				break;
			case 6:
				showPatronsWithTickets();
				break;
			case 7:
				running = false;
				break;
			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
		scanner.close();
		System.out.println("Goodbye.");
	}
}
