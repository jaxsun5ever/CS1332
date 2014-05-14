/**
 * Represents a ballot box and allows you to
 * interact with it just like an actual
 * ballot box.
 * 
 * @author Jackson Chan
 */
public class BallotBox {
	private BagInterface<Ballot> ballotBox;
	
	/**
	 * Constructor that creates a
	 * ballot box. Uses the bag data
	 * structure.
	 */
	public BallotBox() {
		ballotBox = new ArrayListBag<Ballot>();
	}

	/**
	 * Creates a ballot with a name
	 * and no bribe and stores it.
	 * 
	 * @param name The name of the candidate.
	 */
	public void vote(String name) {
		vote(name, 0.0);
	}
	
	/**
	 * Creates a ballot with a name
	 * and a bribe amount and stores it.
	 * 
	 * @param name The name of the candidate.
	 * @param bribe The bribe amount.
	 */
	public void vote(String name, double bribe) {
		ballotBox.add(new Ballot(name, bribe));
	}
	
	/**
	 * Counts the frequency of a name
	 * appearing in the ballot box.
	 * 
	 * @param name The name of the candidate.
	 * @return The number of times that name appears.
	 */
	public int getFrequencyOf(String name) {
		return ballotBox.getFrequencyOf(new Ballot(name));
	}
	
	/**
	 * Removes a random ballot from the box.
	 * 
	 * @return The ballot removed.
	 */
	public Ballot removeVote() {
		return ballotBox.remove();
	}
	
	/**
	 * Removes a ballot with a given name from the box.
	 * 
	 * @param name The name of the candidate to remove.
	 * @return The ballot that was removed.
	 */
	public boolean removeVote(String name) {
		return ballotBox.remove(new Ballot(name));
	}
	
	/**
	 * Counts the total number of votes in the box
	 * 
	 * @return The total number of votes in the box.
	 */
	public int numberOfVotes() {
		return ballotBox.getCurrentSize();
	}
	
	/**
	 * Empties the entire box.
	 */
	public void empty() {
		ballotBox.clear();
	}
	
	/**
	 * Prints out all the ballots inside the box.
	 * @return A list of all the ballots in the box.
	 */
	public String toString() {
		Object[] temp = ballotBox.toArray();
		
		String output = "";
		for (Object vote : temp)
			output += ((Ballot)vote).toString() + "\n";
		
		return output;
	}
}
