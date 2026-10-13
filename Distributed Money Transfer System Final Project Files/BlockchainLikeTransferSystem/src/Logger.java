

// ============================================================
// LOGGER
// ============================================================

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Class: Logger
 * Handles all file logging for the application. Writes to a single
 * log file (transaction_log.log). On startup, the file is deleted
 * and recreated so each run starts with a clean log.
 */
class Logger {
    private static final String LOG_FILE = "transaction_log.log"; // Path of the log file
    private static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Method: initialize
     * Parameters: none
     * Returns: void
     *
     * What it does (step by step):
     *   1. If the log file exists, deletes it.
     *   2. Creates a new empty log file.
     *   3. Prints a short status message to the console.
     *
     * Local variables:
     *   file - File object representing the log file path
     */
    public static void initialize() {
        File file = new File(LOG_FILE);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Old log file deleted: " + LOG_FILE);
            } else {
                System.err.println("Could not delete old log file: " + LOG_FILE);
            }
        }
        try {
            if (file.createNewFile()) {
                System.out.println("New log file created: " + LOG_FILE);
            }
        } catch (IOException e) {
            System.err.println("Could not create log file: " + e.getMessage());
        }
    }

    /**
     * Method: log
     * Parameters:
     *   message - the text to append to the log file
     * Returns: void
     *
     * What it does:
     *   Prepends the current timestamp to the message and appends it
     *   to the log file (append mode). Any IO error is reported to stderr.
     *
     * Local variables:
     *   line - the fully formatted log line (timestamp + message)
     */
    public static void log(String message) {
        String line = String.format("[%s] %s%n", fmt.format(new Date()), message);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bw.write(line);
        } catch (IOException e) {
            System.err.println("Could not write to log: " + e.getMessage());
        }
    }

    /**
     * Method: logTransactionStarted
     * Parameters:
     *   txn - the transaction that is starting to be processed
     * Returns: void
     *
     * What it does: logs a "[TRANSACTION STARTED]" line for the given transaction.
     */
    public static void logTransactionStarted(Transaction txn) {
        log("[TRANSACTION STARTED] " + txn);
    }

    /**
     * Method: logApprovers
     * Parameters:
     *   approverIds - list of user ids chosen as approvers
     * Returns: void
     *
     * What it does: logs a "[APPROVERS]" line listing the approver ids.
     */
    public static void logApprovers(List<Integer> approverIds) {
        log("[APPROVERS] " + approverIds);
    }

    /**
     * Method: logApproval
     * Parameters:
     *   approverId - id of the approver
     *   approved   - true if the approver approved, false otherwise
     * Returns: void
     *
     * What it does: logs a single line showing one approver's decision.
     */
    public static void logApproval(int approverId, boolean approved) {
        log(String.format("  Approver %d: %s", approverId, approved ? "APPROVED" : "REJECTED"));
    }

    /**
     * Method: logConfirmed
     * Parameters:
     *   txn - the transaction that was approved and committed
     * Returns: void
     *
     * What it does: logs a "[CONFIRMED]" line stating the transaction is committed.
     */
    public static void logConfirmed(Transaction txn) {
        log("[CONFIRMED] Transaction written to history: " + txn);
    }

    /**
     * Method: logCancelled
     * Parameters:
     *   txn    - the transaction that was cancelled
     *   reason - short human-readable reason (e.g. "no path", "insufficient balance")
     * Returns: void
     *
     * What it does:
     *   Logs a "[CANCELLED]" line with the sender, receiver, amount,
     *   createdAt timestamp, and the cancellation reason.
     */
    public static void logCancelled(Transaction txn, String reason) {
        log(String.format("[CANCELLED] sender=%d receiver=%d amount=%.2f createdAt=%s reason=%s",
                txn.senderId, txn.receiverId, txn.amount,
                fmt.format(txn.createdAt), reason));
    }
}