/**
 * Represents a ballot object that one
 * would find at a voting stall. Stores
 * a name and a bribe amount.
 * 
 * @author Jackson Chan
 */
public class Ballot {
	private String name;
	private double bribe;
	
	/**
	 * Constructor for a ballot. Takes
	 * in a name only.
	 * 
	 * @param name The name of the candidate.
	 */
	public Ballot(String name) {
		this.name = name;
		bribe = 0.0;
	}
	
	/**
	 * Constructor for a ballot. Takes
	 * in both a name and a bribe.
	 * 
	 * @param name The name of the candidate.
	 * @param bribe The bribe amount.
	 */
	public Ballot(String name, double bribe) {
		this(name);
		this.bribe = bribe;
	}

	/**
	 * Compares two ballot objects by checking
	 * to see if the names are equal.
	 * 
	 * @param obj The ballot object to compare to.
	 * @return True if the ballots are equal, false if otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return name.equalsIgnoreCase(((Ballot)obj).name);
	}
	
	/**
	 * Prints out the name of the 
	 * candidate and the bribe amount.
	 * 
	 * @return The ballot candidate's name and bribe.
	 */
	@Override
	public String toString() {
		return "Candidate name: " + name + "\tBribe amount: $" + bribe;
	}
}
