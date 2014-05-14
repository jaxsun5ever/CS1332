import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Contains bubble sort, insertion sort, selection sort,
 * quick sort, merge sort, and radix sort
 * 
 * @author Jackson
 *
 */
public class Sorting implements SortingInterface {
	
	@Override
	public <T extends Comparable<T>> void bubblesort(T[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		boolean swapped;
		int length = arr.length;
		do {
			swapped = false;
			for (int i = 1; i < length; i++) {
				if (arr[i - 1].compareTo(arr[i]) > 0) {
					T temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
			length = length - 1;
		} while (swapped);
	}

	@Override
	public <T extends Comparable<T>> void insertionsort(T[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
				T temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void selectionsort(T[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minimum = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minimum]) < 0) {
					minimum = j;
				}
			}
			if (minimum != i) {
				T temp = arr[i];
				arr[i] = arr[minimum];
				arr[minimum] = temp;
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
		if (arr == null || r == null) {
			throw new IllegalArgumentException();
		}
		quicksort(arr, 0, arr.length - 1, r);
	}
	
	/**
	 * Sorts an array with quicksort
	 * 
	 * @param arr The array to sort
	 * @param left The left most position
	 * @param right The right most position
	 * @param r Random number generator
	 */
	private <T extends Comparable<T>> void quicksort(T[] arr, int left, int right, Random r) {
		if (left < right) {
			int randomPivot = getRandomPivot(r, left, right);
			int pivot = partition(arr, left, right, randomPivot);
			quicksort(arr, left, pivot - 1, r);
			quicksort(arr, pivot + 1, right, r);
		}
	}
	
	/**
	 * Partitions the elements in the array so the smaller
	 * values are left of the pivot and larger are to the right
	 * 
	 * @param arr The array
	 * @param left The left most position
	 * @param right The right most position
	 * @param pivot The index of the pivot
	 * @return The correct index of the pivot with the elements partitioned
	 */
	private <T extends Comparable<T>> int partition(T[] arr, int left, int right, int pivot) {
		T pivotValue = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = pivotValue;

		int index = left;
		for (int i = left; i < right; i++) {
			if (arr[i].compareTo(pivotValue) < 1) {
				T temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		T temp = arr[index];
		arr[index] = arr[right];
		arr[right] = temp;

		return index;
	}
	
	/**
	 * Gets a random pivot
	 * 
	 * @param r Random number generator
	 * @param left Left bound
	 * @param right Right bound
	 * @return A random pivot within the bounds
	 */
	private int getRandomPivot(Random r, int left, int right) {
		return r.nextInt(right - left) + left;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Comparable<T>> T[] mergesort(T[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		T[] temp = (T[]) new Comparable[arr.length];
		mergesortSplit(arr, 0, arr.length, temp);
		return arr;
	}
	
	/**
	 * Splits the array
	 * 
	 * @param arr The original array
	 * @param left The left most element
	 * @param right The right most element
	 * @param temp The array to put the sorted items into
	 */
	private static <T extends Comparable<T>> void mergesortSplit(T[] arr, int left, int right, T[] temp) {
		if (right - left < 2) {
			return;
		}
		int middle = (right + left) / 2;
		mergesortSplit(arr, left, middle, temp);
		mergesortSplit(arr, middle, right, temp);
		mergesortMerge(arr, left, middle, right, temp);
		copyArray(temp, left, right, arr);
	}
	
	/**
	 * Merges the two sorted arrays together
	 * 
	 * @param arr The original array
	 * @param left The first element in the first sorted array
	 * @param middle The first element in the second sorted array
	 * @param right The end of the array
	 * @param temp The array to put the merged elements into
	 */
	private static <T extends Comparable<T>> void mergesortMerge(T[] arr, int left, int middle, int right, T[] temp) {
		int leftElement = left;
		int rightElement = middle;
		for (int i = left; i < right; i++) {
			if (leftElement < middle && (rightElement >= right || arr[leftElement].compareTo(arr[rightElement]) < 1)) {
				temp[i] = arr[leftElement];
				leftElement++;
			} else {
				temp[i] = arr[rightElement];
				rightElement++;
			}
		}
	}
	
	/**
	 * Copies the sorted array into the original array
	 * 
	 * @param temp The sorted array
	 * @param left Left index to start at
	 * @param right Right index to end at
	 * @param arr The array with correctly sorted elements
	 */
	private static <T extends Comparable<T>> void copyArray(T[] temp, int left, int right, T[] arr) {
		for (int i = left; i < right; i++) {
			arr[i] = temp[i];
		}
	}

	@Override
	public int[] radixsort(int[] arr) {
		if (arr == null) {
			throw new IllegalArgumentException();
		}
		int max = getMax(arr);
		int numberLength = getNumberLength(max);
		radixsort(arr, numberLength);
		return arr;
	}
	
	/**
	 * Gets the max value inside an array of ints
	 * 
	 * @param arr The array
	 * @return The largest value
	 */
	private static int getMax(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	/**
	 * Gets the length of the number
	 * 
	 * @param num The number you want to know the length of
	 * @return The length of the number
	 */
	private static int getNumberLength(int num) {
		int length = 1;
		while (num > 9) {
			num /= 10;
			length++;
		}
		return length;
	}
	
	/**
	 * Sorts an array with radix sort
	 * 
	 * @param arr The array to sort
	 * @param iterations The number of iterations to do
	 */
	@SuppressWarnings("unchecked")
	private static void radixsort(int[] arr, int iterations) {
		Queue<Integer>[] bucket = (Queue<Integer>[]) new Queue[10];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < iterations; i++) {
			for (int j = 0; j < arr.length; j++) {
				int digit = getDigit(i, arr[j]);
				bucket[digit].add(arr[j]);
			}
			int num = 0;
			for (Queue<Integer> q : bucket) {
				while (q.size() > 0) {
					arr[num] = q.poll();
					num++;
				}
			}
		}
	}
	
	/**
	 * Gets the number corresponding to the digit
	 * that you want.
	 * 
	 * @param digit The position of the digit
	 * @param number The number
	 * @return The digit in the corresponding position
	 */
	private static int getDigit(int digit, int number) {
		return (number / (int) Math.pow(10, digit)) % 10;
	}

}
