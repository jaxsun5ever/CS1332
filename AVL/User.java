
/**
 * Simple user type that contains a username and a name.
 * 
 * @author Jackson Chan
 */
public class User implements Comparable<User> {
	private String username;
	private String name;

	/**
	 * Creates a new user
	 * 
	 * @param username The username
	 * @param name The name
	 */
	public User(String username, String name) {
		this.username = username;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return username + "-" + name;
	}
	
	@Override
	public int compareTo(User user) {
		return username.compareToIgnoreCase(user.username);
	}
	
}
