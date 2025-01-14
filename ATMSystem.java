import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited ₹%.2f. Current balance: ₹%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew ₹%.2f. Current balance: ₹%.2f%n", amount, balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        return false;
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM interface
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.printf("Your current balance is: ₹%.2f%n", account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

// Main class to run the program
public class ATMSystem {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount userAccount = new BankAccount(10000.0); // ₹10,000 initial balance

        // Create the ATM object and start the interface
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
