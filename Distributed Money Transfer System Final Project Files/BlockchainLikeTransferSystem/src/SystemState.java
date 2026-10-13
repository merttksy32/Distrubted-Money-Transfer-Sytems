
// ============================================================
// SYSTEM STATE (shared data structures)
// ============================================================

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class: SystemState
 * Holds all the shared, mutable data structures of the application:
 * the user map, the confirmed transaction list, the hash index,
 * and the pending transaction queue.
 *
 * The confirmed list uses the custom MyLinkedList (singly linked),
 * and the pending queue uses the custom MyQueue (FIFO).
 *
 * All mutating methods here are synchronized on the SystemState instance,
 * so the scheduler thread, the worker threads, and the menu thread
 * cannot corrupt the shared structures.
 */
class SystemState {
    Map<Integer, User> users = new HashMap<>();                    // All registered users by id
    MyLinkedList<Transaction> confirmedTransactions = new MyLinkedList<>(); // Approved transactions in order
    HashIndex hashIndex = new HashIndex();                         // Index on user id
    MyQueue<Transaction> pendingQueue = new MyQueue<>();           // Pending transactions (priority ordered)

    /**
     * Method: enqueueAndSort
     * Parameters:
     *   txn - the new transaction to add to the pending queue
     * Returns: void
     *
     * What it does (step by step):
     *   1. Drains the current MyQueue into a temporary ArrayList
     *      (used only as a working buffer for HeapSort).
     *   2. Appends the new transaction.
     *   3. Runs heap sort on the list using the sender's priority.
     *   4. Clears the MyQueue and refills it from the sorted list.
     * This keeps the queue always ordered by priority.
     */
    public synchronized void enqueueAndSort(Transaction txn) {

    }

    /**
     * Method: dequeue
     * Parameters: none
     * Returns: Transaction - the highest-priority pending transaction,
     *          or null if the queue is empty.
     *
     * What it does:
     *   Removes and returns the front of the pending queue
     */
    public synchronized Transaction dequeue() {
        return null;
    }

    /**
     * Method: commitTransaction
     * Parameters:
     *   txn - the transaction to finalize
     * Returns: void
     *
     * What it does (step by step):
     *   1. Stamps approvedAt with the current time.
     *   2. Adds the transaction to the confirmed linked list.
     *   3. Adds the transaction to the hash index.
     *   4. Subtracts the amount from the sender's balance.
     *   5. Adds the amount to the receiver's balance.

     */
    public synchronized void commitTransaction(Transaction txn) {

    }

    /**
     * Method: printPending
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Prints all pending transactions in their current queue order
     *   (which is priority order). 
     */
    public synchronized void printPending() {
        System.out.println("\n--- PENDING TRANSACTIONS (priority order) ---");
        if (pendingQueue.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
    }

    /**
     * Method: printConfirmed
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Prints every confirmed transaction in insertion order
     *   (oldest to newest). Since MyLinkedList is not Iterable, this
     *   uses index-based access via get(i).
     */
    public synchronized void printConfirmed() {
        System.out.println("\n--- CONFIRMED TRANSACTIONS ---");
        if (confirmedTransactions.isEmpty()) {
            System.out.println("(empty)");
            return;
        }

    }

    /**
     * Method: printUsers
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Prints all registered users and their current balance/priority.

     */
    public synchronized void printUsers() {

    }
}
