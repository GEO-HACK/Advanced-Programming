public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance= initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+= amount;
    }
    public void withdraw(double amount) throws  InsufficientFundsException{
        if(balance < amount) throw new InsufficientFundsException("insufficient funds in the account");
        balance -= amount;
    }
}
