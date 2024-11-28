import java.util.Calendar;

public interface TransactionInterface  {
    double getAmount();
    Calendar getDate();
    String getTransactionId();
    void printTransactionDetails();
    void apply( BankAccount ba);
}
