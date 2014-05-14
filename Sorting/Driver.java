import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * Driver that runs a sorting program. Automatically runs bubble, insertion,
 * selection, quick, merge, and radix sort.
 * 
 * @author Jackson
 *
 */
public class Driver {
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	private static SortingInterface sorter = new Sorting();
	private static Random randy = new Random();
	private static double startTime;	
	
	/**
	 * Copies the original array into a copy
	 * 
	 * @param orig The original array to copy
	 * @param copy The copied array
	 */
	private static void copyArray(int[] orig, int[] copy) {
		for (int i = 0; i < orig.length; i++) {
			copy[i] = orig[i];
		}
	}
	
	/**
	 * Copies the original array into a copy
	 * 
	 * @param orig The original array to copy
	 * @param copy The copied array
	 */
	private static void copyArray(int[] orig, Integer[] copy) {
		for (int i = 0; i < orig.length; i++) {
			copy[i] = new Integer(orig[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		while (running) {
			System.out.println("Please enter the size of the array you"
					+ " would like to sort or enter 0 to exit:");
			while (!scanner.hasNextInt()) {
				scanner.next();
			}

			int input = scanner.nextInt();
			if (input > 0) {
				int[] original = new int[input];
				for (int i = 0; i < original.length; i++) {
					original[i] = randy.nextInt(1000);
				}
				System.out.print("The unsorted array is: ");
				System.out.println(Arrays.toString(original));

				Integer[] tempArray = new Integer[input];
				int[] tempArray2 = new int[input];
				copyArray(original, tempArray);
				copyArray(original, tempArray2);

				startTime = System.nanoTime();
				sorter.bubblesort(tempArray);
				double seconds = (System.nanoTime() - startTime) / 1000000000.0;

				System.out.print("The sorted array is: ");
				System.out.println(Arrays.toString(tempArray));
				System.out.println("");
				System.out.println("It took bubble sort " + seconds	+ " seconds.");

				copyArray(original, tempArray);
				startTime = System.nanoTime();
				sorter.insertionsort(tempArray);
				seconds = (System.nanoTime() - startTime) / 1000000000.0;
				System.out.println("It took insertion sort " + seconds + " seconds.");

				copyArray(original, tempArray);
				startTime = System.nanoTime();
				sorter.selectionsort(tempArray);
				seconds = (System.nanoTime() - startTime) / 1000000000.0;
				System.out.println("It took selection sort " + seconds + " seconds.");

				copyArray(original, tempArray);
				startTime = System.nanoTime();
				sorter.quicksort(tempArray, randy);
				seconds = (System.nanoTime() - startTime) / 1000000000.0;
				System.out.println("It took quick sort " + seconds + " seconds.");

				copyArray(original, tempArray);
				startTime = System.nanoTime();
				sorter.mergesort(tempArray);
				seconds = (System.nanoTime() - startTime) / 1000000000.0;
				System.out.println("It took merge sort " + seconds + " seconds.");

				copyArray(original, tempArray2);
				startTime = System.nanoTime();
				sorter.radixsort(tempArray2);
				seconds = (System.nanoTime() - startTime) / 1000000000.0;
				System.out.println("It took radix sort " + seconds + " seconds.");
			} else {
				running = false;
			}
			System.out.println("");
		}
		scanner.close();
		System.out.println("Goodbye.");
	}
}
