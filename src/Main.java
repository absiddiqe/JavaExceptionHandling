//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 19238.0);
        try {
            // Attempt to deposit $50
            account.deposit(50.0);

            // Attempt to withdraw $200
            account.withdraw(200.0);

            // Attempt to withdraw $50
            account.withdraw(50.0);

            // Attempt to deposit -$10 (invalid amount)
            account.deposit(-10.0);

        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            // Print the final balance and indicate the end of the transaction
            System.out.println("Final balance: $" + account.getBalance());
            System.out.println("End of transaction.");
        }
    }
}