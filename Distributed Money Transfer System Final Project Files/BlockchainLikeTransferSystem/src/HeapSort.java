// ============================================================
// HEAP SORT (based on the sender's priority value)
// ============================================================

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class: HeapSort
 * Implements an iterative heap sort to order transactions by the
 * priority of their sender. Higher priority = earlier in the queue.
 */
class HeapSort {

    /**
     * Method: sortBySenderPriority
     * Parameters:
     *   list  - the list of transactions to sort in place
     *   users - map of user id -> User, used to look up the sender's priority
     * Returns: void (sorts 'list' in place)
     *
     * What it does (step by step):
     *   1. Builds a max-heap on 'list' using the sender's priority as the key.
     *      (Max-heap = highest priority at the root.)
     *   2. Repeatedly swaps the root (max) to the end and re-heapifies the
     *      remaining prefix. This yields ascending order.
     *   3. Reverses the list so that the HIGHEST priority is at the front,
     *      which is what the pending queue expects.
     */
    public static void sortBySenderPriority(List<Transaction> list, Map<Integer, User> users) {

    }

    /**
     * Method: priority
     * Parameters:
     *   t     - the transaction whose sender's priority we want
     *   users - map of user id -> User
     * Returns: int - the sender's priority, or 0 if the sender is not found
     *
     * What it does:
     *   Looks up the sender in the users map and returns the priority value.
     *   Returns 0 as a safe fallback when the sender does not exist.
     *
     * Local variables:
     *   u - the sender User object (or null)
     */
    private static int priority(Transaction t, Map<Integer, User> users) {
        User u = users.get(t.senderId);
        return u != null ? u.priority : 0;
    }
}
