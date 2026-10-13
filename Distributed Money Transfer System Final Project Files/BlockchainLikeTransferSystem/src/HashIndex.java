import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//============================================================
//HASH INDEX (built on user id, hash = id % 4)
//============================================================

/**
* Class: Node
* A single node in the hash index chain (linked-list style bucket entry).
* Each node corresponds to one user id and holds all transactions
* that this user participated in (as sender or receiver).
*/
class Node {
 int userId;                       // The user this node belongs to
 List<Transaction> transactions;   // All transactions involving this user
 Node next;                        // Next node in the same bucket (collision chain)

 /**
  * Constructor: Node
  * Parameters:
  *   userId - the user id this node represents
  * What does it: a new Node with an empty transaction list.
  */
 Node(int userId) {
     this.userId = userId;
     this.transactions = new ArrayList<>();
     this.next = null;
 }
}


/**
 * Class: HashIndex
 * A custom hash table built on user id, using hash = id % 4.
 * It stores references to transactions so that all transactions of a given
 * user can be retrieved quickly. This is used by BFS to find a user's
 * neighbors (users they have transacted with in the past).
 */
class HashIndex {
    private Node[] buckets;          // Array of bucket heads (size = 4)
    private final int size = 4;      // Number of buckets (hash = id % size)

    /**
     * Constructor: HashIndex
     * Parameters: none
     * What does it: a new HashIndex with empty buckets.
     */
    public HashIndex() {
    	buckets = new Node[size];
    }

    /**
     * Method: hash
     * Parameters:
     *   userId - the user id to hash
     * Returns: int - the bucket index 
     *
     * What it does:
     *   Simple modulo hash function as required by the project spec.
     */
    private int hash(int userId) {
        return -1;
    }

    /**
     * Method: addTransaction
     * Parameters:
     *   txn - the transaction to index
     * Returns: void
     *
     * What it does:
     *   Indexes the given transaction under BOTH the sender id and the
     *   receiver id, so that either user can later retrieve it quickly.
     */
    public void addTransaction(Transaction txn) {
        addForUser(txn.senderId, txn);
        addForUser(txn.receiverId, txn);
    }

    /**
     * Method: addForUser
     * Parameters:
     *   userId - the user id to index the transaction under
     *   txn    - the transaction to add
     * Returns: void
     *
     * What it does (step by step):
     *   1. Computes the bucket index for userId.
     *   2. Walks the bucket chain looking for an existing node for userId.
     *   3. If found, appends txn to that node's transaction list.
     *   4. If not found, creates a new node at the head of the bucket.
     */
    private void addForUser(int userId, Transaction txn) {

    }

    /**
     * Method: getTransactions
     * Parameters:
     *   userId - the user whose transactions we want
     * Returns: List<Transaction> - a copy of the user's transaction list
     *          (empty list if the user has no transactions)
     *
     * What it does:
     *   Looks up the user in the hash table and returns a defensive copy
     *   of their transaction references.
     */
    public List<Transaction> getTransactions(int userId) {
        return new ArrayList<>();
    }

    /**
     * Method: getNeighbors
     * Parameters:
     *   userId - the user whose neighbors we want
     * Returns: Set<Integer> - ids of all users this user has transacted with
     *
     * What it does (step by step):
     *   1. Retrieves all transactions of the user.
     *   2. For each transaction, adds the OTHER party to the neighbor set.
     *   3. Returns the set (undirected graph: sender and receiver are connected both ways).
     *
     * Local variables:
     *   neighbors - set of neighbor user ids
     */
    public Set<Integer> getNeighbors(int userId) {
        Set<Integer> neighbors = new HashSet<>();
        return neighbors;
    }

    /**
     * Method: printIndex
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Prints the entire hash table to the console for debugging:
     *   for each bucket, lists the user ids and how many transactions
     *   each user has.
     *
     * Local variables:
     *   i       - bucket index
     *   current - cursor used to walk the bucket chain
     *   sb      - StringBuilder used to build the per-bucket output line
     */
    public void printIndex() {
        System.out.println("--- HASH INDEX ---");
            for (int i = 0; i < size; i++) {
                System.out.print("Bucket " + i + ": ");
                Node current = buckets[i];
                if (current == null) {
                    System.out.println("(empty)");
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                while (current != null) {
                    sb.append("user").append(current.userId)
                      .append("(").append(current.transactions.size()).append(" txn) -> ");
                    current = current.next;
                }
                System.out.println(sb);
            }
    }
}


