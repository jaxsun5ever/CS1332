import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Driver for the boyer-moore and rabin-karp algorithms
 * 
 * @author Jackson Chan
 *
 */
public class Driver {
	private static StringSearchInterface searcher = new StringSearch();
	private static Scanner scanner = new Scanner(System.in);
	private static double startTime;
	
	/**
	 * Shortcut to avoid typing system.out.print
	 * 
	 * @param arg String to print out
	 */
	private static void sop(String arg) {
		System.out.println(arg);
	}
	
	/**
	 * Performs the boyer-moore and rabin-karp algorithm on a string
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String haystack;
		String needle;
		double seconds;
		sop("Enter some text (empty string to quit): ");
		haystack = scanner.nextLine();
		while (!haystack.equals("")) {
			sop("");
			sop("Enter text to find: ");
			needle = scanner.nextLine();

			startTime = System.nanoTime();
			List<Integer> list = searcher.boyerMoore(needle, haystack);
			seconds = (System.nanoTime() - startTime) / 1000000000.0;
			sop("Booyer-Moore:");
			sop("Text found at indices: " + Arrays.toString(list.toArray()));
			sop("Took " + seconds + " seconds to find all occurences");
			sop("");
			
			startTime = System.nanoTime();
			list = searcher.rabinKarp(needle, haystack);
			seconds = (System.nanoTime() - startTime) / 1000000000.0;
			sop("Rabin-Karp:");
			sop("Text found at indices: " + Arrays.toString(list.toArray()));
			sop("Took " + seconds + " seconds to find all occurences");
			sop("");
			
			sop("Enter some text (empty string to quit): ");
			haystack = scanner.nextLine();
		}
		scanner.close();
		sop("Goodbye.");
	}
}
