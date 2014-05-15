import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of Boyer-Moore and Rabin-Karp algorithm
 * 
 * @author Jackson Chan
 *
 */
public class StringSearch implements StringSearchInterface {
	private static int nthBase;

	@Override
	public List<Integer> boyerMoore(String needle, String haystack) {
		if (needle == null || haystack == null) {
			throw new IllegalArgumentException();
		}
		if (needle.length() > haystack.length()) {
			return new LinkedList<>();
		}
		if (haystack.length() == 0 || needle.length() == 0) {
			return new LinkedList<>();
		}
		int[] table = buildLastTable(needle);
		List<Integer> list = new LinkedList<>();
		boolean isMatched = false;
		for (int i = needle.length() - 1; i < haystack.length();) {
			for (int j = needle.length() - 1, k = i; j >= 0 && needle.charAt(j) == haystack.charAt(k); k--, j--) {
				if (j == 0) {
					list.add(k);
					isMatched = true;
				}
			}
			i += isMatched ? 1 : table[haystack.charAt(i)];
			isMatched = false;
		}
		return list;
	}

	@Override
	public int[] buildLastTable(String needle) {
		if (needle == null || needle.length() == 0) {
			throw new IllegalArgumentException();
		}
		int[] map = new int[Character.MAX_VALUE + 1];
		for (int i = 0; i < map.length; i++) {
			map[i] = needle.length();
		}
		for (int i = 0; i < needle.length(); i++) {
			map[needle.charAt(i)] = Math.max(needle.length() - needle.lastIndexOf(needle.charAt(i)) - 1, 1);
		}
		return map;
	}

	@Override
	public int generateHash(String current) {
		if (current == null) {
			throw new IllegalArgumentException();
		}
		nthBase = pow(BASE, current.length() - 1);
		int hash = 0;
		for (int i = 0; i < current.length(); i++) {
			char x = current.charAt(i);
			hash += x * pow(BASE, current.length() - 1 - i);
		}
		return hash;
	}
	
	/**
	 * Get the power of base raised to the exponent
	 * @param base base number
	 * @param exp exponent
	 * @return base raised to the exponent
	 */
	private static int pow(int base, int exp) {
		int val = 1;
		for (int i = exp; i > 0; i--) {
			val *= base;
		}
		return val;
	}

	@Override
	public int updateHash(int oldHash, int length, char oldChar, char newChar) {
		return (oldHash - (oldChar * nthBase)) * BASE + newChar;
	}

	@Override
	public List<Integer> rabinKarp(String needle, String haystack) {
		List<Integer> list = new LinkedList<>();
		if (needle == null || haystack == null) {
			throw new IllegalArgumentException();
		}
		if (needle.length() > haystack.length()) {
			return new LinkedList<>();
		}
		if (haystack.length() == 0 || needle.length() == 0) {
			return new LinkedList<>();
		}
		int needleHash = generateHash(needle);
		int haystackHash;

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			String substring = haystack.substring(i, i + needle.length());
			haystackHash = generateHash(substring);
			if (needleHash == haystackHash) {
				if (substring.equals(needle)) {
					list.add(i);
				}
			}
		}

		return list;
	}

}
