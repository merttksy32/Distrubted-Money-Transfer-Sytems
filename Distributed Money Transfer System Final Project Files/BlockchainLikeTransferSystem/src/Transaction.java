import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class: Transaction
 * Represents a money transfer request or a completed transfer.
 * A transaction stores the sender id, receiver id, amount, timestamps,
 * the list of approvers (intermediate users), and each approver's decision.
 */
class Transaction {
    int senderId;                     // Id of the user sending money
    int receiverId;                   // Id of the user receiving money
    double amount;                    // Amount to transfer
    Date createdAt;                   // Timestamp when the transaction was created
    Date approvedAt;                  // Timestamp when the transaction was approved (null if not yet)
    List<User> approvers;             // Intermediate users who approved this transaction
    Map<Integer, Boolean> approvals;  // Approver id -> decision (true = approved, false = rejected)

    /**
     * Constructor: Transaction
     * Parameters:
     *   senderId   - id of the sender
     *   receiverId - id of the receiver
     *   amount     - amount to transfer
     * What does it: init attirubtes.
     */
    public Transaction(int senderId, int receiverId, double amount) {
        this.approvals = new HashMap<>();
    }

    /**
     * Method: toString
     * Parameters: none
     * Returns: String - a formatted description of this transaction
     *
     * What it does:
     *   Formats all transaction fields (including timestamps and approval map)
     *   into a single line for console and log output.
     */
    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format(
                "Txn[sender=%d, receiver=%d, amount=%.2f, createdAt=%s, approvedAt=%s, approvers=%s, approvals=%s]",
                senderId, receiverId, amount,
                fmt.format(createdAt),
                approvedAt != null ? fmt.format(approvedAt) : "null",
                approvers.stream().map(u -> String.valueOf(u.id)).toList(),
                approvals);
    }
}