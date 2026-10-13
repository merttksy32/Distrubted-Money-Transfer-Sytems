/**
 * Class: MyQueue
 * A custom FIFO queue implementation. It does NOT use any built-in
 * Java collection class internally; it only uses its own Node objects.
 *
 * Used for:
 *   - the pending transactions queue in SystemState
 *   - the BFS frontier queue in the BFS class
 *
 * @param <T> the type of elements stored in the queue
 */
class MyQueue<T> {

    /**
     * Class: Node
     * Internal node of the queue. Holds one element and a reference
     * to the next node.
     */
     class Node<T> {
        T data;          // The element stored in this node
        Node<T> next;    // Reference to the next node (null if this is the last)

        /**
         * Constructor: Node
         * Parameters:
         *   data - the element to store
         * Returns: a new Node with next = null.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;  // First node of the queue (dequeue from here)
    private Node<T> rear;   // Last node of the queue (enqueue here)
    private int size;       // Number of elements currently in the queue

    /**
     * Constructor: MyQueue
     * Parameters: none
     * What does it: an empty queue.
     */
    public MyQueue() {
    }

    /**
     * Method: enqueue
     * Parameters:
     *   data - the element to add at the rear of the queue
     * Returns: void
     *
     * What it does:
     *   Adds a new node with 'data' at the rear. Runs in O(1).

     */
    public void enqueue(T data) {

    }

    /**
     * Method: dequeue
     * Parameters: none
     * Returns: T - the element at the front, or null if the queue is empty.
     *
     * What it does:
     *   Removes the front node and returns its data. Runs in O(1).
     */
    public T dequeue() {
        return null;
    }

    /**
     * Method: isEmpty
     * Parameters: none
     * Returns: boolean - true if the queue has no elements
     */
    public boolean isEmpty() {
    	return false;
    }

    /**
     * Method: size
     * Parameters: none
     * Returns: int - the number of elements in the queue
     */
    public int size() {
    	return 0;
    }

    /**
     * Method: clear
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Removes all elements by dropping front/rear references and
     *   resetting the size to 0.
     */
    public void clear() {
    }
}