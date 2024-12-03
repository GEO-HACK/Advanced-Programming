package Lecture2_adt_specification;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * Transaction4 ADT Specification:
 *
 * This ADT represents a financial transaction characterized by:
 * - An integer `amount` which holds the transaction amount.
 * - A `Calendar` object `date` that represents the date the transaction occurred.
 *
 * Design Considerations:
 * - The `amount` field is immutable, meaning once set, its value cannot change.
 * - The `date` field is also immutable due to the defensive copying mechanism, ensuring that external modifications to the `date` do not affect the object.
 */
public class Transaction4 {
    private final int amount; // The amount involved in the transaction
    private final Calendar date; // The date when the transaction occurred

    /**
     * Constructor Specification:
     *
     * Requires:
     * - `amount` must be a valid integer. It can be positive, negative, or zero.
     * - `date` must be a valid non-null `Calendar` object. If the date is null, an exception should be thrown.
     *
     * Produces:
     * - A new `Transaction4` instance is created, with the specified `amount` and `date`.
     * - The `date` field is stored as a defensive copy, which ensures immutability. The internal reference to `date` cannot be modified externally.
     *
     * @param amount The amount of the transaction, which can be any integer.
     * @param date   The date the transaction occurred, which must be a valid non-null `Calendar` object.
     * @throws IllegalArgumentException if the provided `date` is null.
     */
    public Transaction4(int amount, @NotNull Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copying
    }

    /**
     * Accessor Method: getAmount()
     *
     * Requires:
     * - No preconditions for calling this method.
     *
     * Produces:
     * - Returns the transaction amount as an immutable integer value.
     * - The returned value cannot be modified externally.
     *
     * @return The amount of the transaction.
     */
    public int getAmount() {
        return amount; // Immutable primitive type, safe to return directly
    }

    /**
     * Accessor Method: getDate()
     *
     * Requires:
     * - No preconditions for calling this method.
     *
     * Produces:
     * - Returns a defensive copy of the transaction date as a new `Calendar` object.
     * - The returned `Calendar` object represents the same date as the original but cannot modify the internal state of the `Transaction4` object.
     *
     * @return A defensive copy of the transaction date.
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copy to prevent external modification
    }
}
