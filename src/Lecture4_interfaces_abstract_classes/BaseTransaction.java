import java.util.Calendar;


public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionId;

    public BaseTransaction( double amount, Calendar date, String transactionId){
        this.amount = amount;
        this.date = date;
        this.transactionId = transactionId;

    }

    public double getAmount(){
        return amount;
    }
    public Calendar getDate(){
        return date;
    }
    public String getTransactionId(){
        return transactionId;
    }
    public void printTransactionDetails(){
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }
    public void apply(BankAccount ba) {
        System.out.println("Applying base transaction to account");
    }


}
