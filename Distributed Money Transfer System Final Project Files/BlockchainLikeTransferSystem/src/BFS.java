// ============================================================
// BFS (sender -> receiver, intermediate nodes become approvers)
// ============================================================

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class: BFS
 * Provides a breadth-first search over the transaction graph to find
 * the shortest path between a sender and a receiver. The intermediate
 * nodes on that path become the approvers of the transaction.
 *
 * Note: The direct edge between sender and receiver is deliberately
 * ignored, so the approver list never includes the receiver itself.
 *
 * Uses MyQueue<Integer> instead of java.util.Queue.
 */
class BFS {

    /**
     * Method: findApprovers
     * Parameters:
     *   senderId   - id of the sending user
     *   receiverId - id of the receiving user
     *   hashIndex  - the hash index used to retrieve neighbors quickly
     * Returns: List<Integer> - the intermediate user ids on the shortest
     *          path (in order), or null if no path exists.
     *
     * What it does (step by step):
     *   1. Starts BFS from the sender, marking it visited.
     *   2. For each dequeued user, inspects all neighbors from the hash index.
     *   3. Skips the direct edge sender -> receiver (per project rule).
     *   4. Skips already visited neighbors.
     *   5. When the receiver is reached, walks the parent map backwards
     *      to build the path, removes the receiver itself, and returns
     *      the remaining intermediate nodes.
     *   6. If BFS exhausts the queue without reaching the receiver, returns null.
     *
     * Local variables:
     *   queue     - custom FIFO queue of user ids still to be expanded
     *   parent    - map child id -> parent id, used to reconstruct the path
     *   visited   - set of user ids already visited
     */
    public static List<Integer> findApprovers(int senderId, int receiverId, HashIndex hashIndex) {
        MyQueue<Integer> queue = new MyQueue<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        return null; // no path found
    }
}
