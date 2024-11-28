import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date, String transactionId){
        super (amount, date, transactionId);
    };

    @Override
    public void apply (BankAccount ba) {
        try{
            if (ba.getBalance() < amount) {
                throw new InsufficientFundsException("insufficient funds for withdrawal");
            }
            ba.withdraw(amount);
            System.out.println("withdrew" + amount + " from account");
        }
        catch(InsufficientFundsException e){
            System.err.println(e.getMessage());

        }

    }
    public void apply(BankAccount ba , boolean allowPartial){
        try{
            if(ba.getBalance() < amount){
                if( allowPartial){
                    double available = ba.getBalance();
                    ba.withdraw(available);
                    System.out.println("withdrew partial amount" + available);
                }
                else {
                    throw new InsufficientFundsException("Insufficient funds for withdrawal.");
                }
            }else{
                ba.withdraw(amount);
            }
        }catch(InsufficientFundsException e){
            System.err.println(e.getMessage());

        }
    }
    public boolean reverse(BankAccount ba){
        ba.deposit(amount);
        return true;
    }
};
