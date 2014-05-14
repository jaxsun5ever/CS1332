/**
 * Simulate an election process. Vote for your
 * favorite corrupt politician and rig the votes
 * to your hearts content.
 * 
 * @author Jackson Chan
 */
import java.util.Scanner;


public class Election {
	private static BallotBox box = new BallotBox();
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Displays a list of options to choose from.
	 */
	private static void mainMenu() {
		System.out.println("Welcome to the election! What would you like to do?");
		System.out.println("1: Vote for a candidate");
		System.out.println("2: Count the number of votes for a candidate");
		System.out.println("3: Remove a vote");
		System.out.println("4: Get number of votes in the ballot box");
		System.out.println("5: Empty the ballot box");
		System.out.println("6: Print all votes");
		System.out.println("7: Quit");
		System.out.print("Enter your choice (1-7) here: ");
	}
	
	/**
	 * Vote for a candidate.
	 */
	private static void vote() {
		scanner.nextLine();	//removes leftover \n due to main method's scanner
		System.out.print("Enter the name of the candidate you would like to vote for: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter bribe amount: ");
		double bribe = scanner.nextDouble();
		
		box.vote(name, bribe);
	}
	
	/**
	 * Count the amount of votes a candidate has.
	 */
	private static void count() {
		scanner.nextLine();	//removes leftover \n due to main method's scanner
		
		printAllVotes();
		
		System.out.print("Enter the name of the candidate you would like to count: ");
		String name = scanner.nextLine();
		
		System.out.println(name + " has " + box.getFrequencyOf(name) + " votes.");
	}
	
	/**
	 * Remove a ballot from the box. Can be random
	 * or specific.
	 */
	private static void remove() {
		scanner.nextLine();	//removes leftover \n due to main method's scanner
		
		printAllVotes();
		
		if (box.numberOfVotes() > 0) {
			System.out.println("Type 'random' to remove a random ballot or");
			System.out.print("Enter the name of the candidate you would like to remove: ");
			String input = scanner.nextLine();
			
			if (input.equalsIgnoreCase("random")) {
				System.out.print("The ballot removed was:");
				System.out.println(box.removeVote().toString());
			} 
			else
				box.removeVote(input);
		}
		else
			System.out.println("There are no ballots to remove.");
	}
	
	/**
	 * Print out the total number of votes inside the box.
	 */
	private static void numberOfVotes() {
		System.out.println("The number of votes in this box is: " + box.numberOfVotes());
	}
	
	/**
	 * Empties the entire box.
	 */
	private static void empty() {
		box.empty();
		System.out.println("The ballot box has been emptied.");
	}
	
	/**
	 * Print out a list of all the votes inside the box.
	 */
	private static void printAllVotes() {
		System.out.println("The ballots in this box are");
		System.out.println(box.toString());
	}
	
	/**
	 * Main driver for the election process. Allows you to
	 * vote, count, and remove votes as well as count the
	 * number of votes for a candidate, empty the ballot
	 * box, and get a list of all the votes.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {		
		while(running){
			System.out.println("-----------------------------------------------");
			System.out.println("");
			mainMenu();
			switch(scanner.nextInt()) {
			case 1:
				vote();
				break;
			case 2:
				count();
				break;
			case 3:
				remove();
				break;
			case 4:
				numberOfVotes();
				break;
			case 5:
				empty();
				break;
			case 6:
				printAllVotes();
				break;
			case 7: 
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
