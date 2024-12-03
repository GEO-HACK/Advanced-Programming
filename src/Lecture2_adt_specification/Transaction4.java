package Lecture2_adt_specification;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * Transaction4 ADT Specification:
 *
 * An Abstract Data Type (ADT) for representing financial transactions, characterized by:
 * - An integer `amount`, representing the transaction amount.
 * - A `Calendar` object `date`, representing the transaction date.
 *
 * Design Considerations:
 * - The `amount` field is immutable.
 * - The `date` field is defensively copied to prevent external modification.
 */
public class Transaction4 {
    private final int amount; // The amount involved in the transaction
    private final Calendar date; // The date when the transaction occurred

    /**
     * Constructor Specification:
     *
     * Requires:
     * - `amount` must be a valid integer (positive, negative, or zero).
     * - `date` must not be null and must be a valid Calendar object.
     *
     * Produces:
     * - A new Transaction4 instance initialized with the specified `amount` and `date`.
     * - The `date` field is stored as a defensive copy to ensure immutability.
     *
     * @param amount Transaction amount as an integer.
     * @param date   A Calendar object representing the transaction date (not null).
     */
    public Transaction4(int amount, @NotNull Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone();
    }

    /**
     * Accessor Method: getAmount()
     *
     * Requires:
     * - No preconditions.
     *
     * Produces:
     * - Returns the transaction amount as an integer.
     * - The returned value is immutable.
     *
     * @return The amount of the transaction.
     */
    public int getAmount() {
        return amount; // Immutable primitive value, safe to return directly
    }

    /**
     * Accessor Method: getDate()
     *
     * Requires:
     * - No preconditions.
     *
     * Produces:
     * - Returns a defensive copy of the transaction date.
     * - The returned object is a new Calendar instance to prevent external modification.
     *
     * @return A Calendar object representing the transaction date.
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copy ensures immutability
    }
}
