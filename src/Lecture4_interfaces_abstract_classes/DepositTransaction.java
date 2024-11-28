import java.util.Calendar;
public class DepositTransaction  extends BaseTransaction {
    public DepositTransaction(double amount ,Calendar date, String transactionId){
        super( amount, date, transactionId);
    }


    public void apply( BankAccount ba){
        ba.deposit(amount);
        System.out.println("Deposited"+ amount + "to account");

    }
}
