/**
 * Class: User
 * Represents a registered user in the system.
 * Each user has a unique id, a name, a balance, and a priority value.
 * The priority value determines how important the user is and is used
 * to order pending transactions in the queue.
 */
class User {
    int id;              // Unique user identifier
    String name;         // Display name of the user
    double balance;      // Current balance (in currency units)
    int priority;        // Importance value; higher = more important

    /**
     * Constructor: User
     * Parameters:
     *   id       - unique user identifier
     *   name     - display name
     *   balance  - initial balance
     *   priority - importance value (higher = more important)
     * What does it: init attributes
     */
    public User(int id, String name, double balance, int priority) {
    }

    /**
     * Method: toString
     * Parameters: none
     * Returns: String - a formatted description of this user
     *
     * What it does:
     *   Produces a single-line string with all user fields,
     *   used for printing user lists in the console.
     */
    @Override
    public String toString() {
    	return null;
    }
}
