// Model Class (Encapsulation)
class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolder;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

// Controller Class (Business Logic)
class BankController {
    private BankAccount account;

    public BankController(BankAccount account) {
        this.account = account;
    }

    public void processTransaction(String transactionType, double amount) {
        switch (transactionType.toLowerCase()) {
            case "deposit":
                account.deposit(amount);
                break;
            case "withdraw":
                account.withdraw(amount);
                break;
            default:
                System.out.println("Invalid transaction type!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("\nAccount Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Current Balance: $" + account.getBalance());
    }
}

// Main Class (Application Entry)
public class Main {
    public static void main(String[] args) {
        // Create model object
        BankAccount account = new BankAccount("ACC12345", "John Doe", 1000.0);

        // Create controller instance
        BankController controller = new BankController(account);

        // Perform operations through controller
        controller.processTransaction("deposit", 500.0);
        controller.processTransaction("withdraw", 200.0);
        controller.displayAccountDetails();
    }
}
