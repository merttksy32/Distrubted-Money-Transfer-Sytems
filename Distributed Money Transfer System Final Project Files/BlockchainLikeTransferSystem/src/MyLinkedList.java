/**
 * Class: MyLinkedList
 * A custom singly linked list implementation. It does NOT use any
 * built-in Java collection class internally; it only uses its own
 * Node objects. This list stores elements in insertion order.
 *
 * It is used for the confirmed transactions list in SystemState.
 *
 * @param <T> the type of elements stored in the list
 */
class MyLinkedList<T> {

    /**
     * Class: Node
     * Internal node of the singly linked list. Holds one data element
     * and a reference to the next node.
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

    private Node<T> head;   // First node of the list (null if empty)
    private Node<T> tail;   // Last node of the list (null if empty)
    private int size;       // Number of elements currently in the list

    /**
     * Constructor: MyLinkedList
     * Parameters: none
     * What does it: an empty list.
     */
    public MyLinkedList() {

    }

    /**
     * Method: add
     * Parameters:
     *   data - the element to append at the end of the list
     * Returns: void
     *
     * What it does:
     *   Appends a new node with the given data at the tail of the list.
     *   Runs in O(1) because we keep a tail reference.
     */
    public void add(T data) {

    }

    /**
     * Method: get
     * Parameters:
     *   index - position of the element
     * Returns: T - the element at the given index
     *
     * What it does:
     *   Walks the list from the head until the requested index is reached.
     *   Runs in O(n).
     */
    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return null;
    }

    /**
     * Method: size
     * Parameters: none
     * Returns: int - the number of elements in the list
     */
    public int size() {
    	return 0;
    }

    /**
     * Method: isEmpty
     * Parameters: none
     * Returns: boolean - true if the list has no elements
     */
    public boolean isEmpty() {
    	return false;
    }

    /**
     * Method: clear
     * Parameters: none
     * Returns: void
     *
     * What it does:
     *   Removes all elements by dropping the head/tail references and
     *   resetting the size to 0. The old nodes become eligible for GC.
     */
    public void clear() {
    }
}
