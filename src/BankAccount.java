public class BankAccount {
    private final String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) throws InvalidAmountException  {
        if(amount <= 0){
            throw new InvalidAmountException("Invalid Deposit: Amount must be greater than ZERO");
        }
        balance += amount;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= 0 || amount > balance){
            throw new InsufficientFundsException("Insufficient Balance: Amount must be in between 1 and your Current  Balance");
        }
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
