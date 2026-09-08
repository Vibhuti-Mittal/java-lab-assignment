import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance for withdrawal."
            );
        }

        balance -= amount;
    }
}

public class q5 {

    static BankAccount findAccount(BankAccount[] accounts, int accountNumber)
            throws AccountNotFoundException {

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        throw new AccountNotFoundException(
            "Account number " + accountNumber + " not found."
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = {
            new BankAccount(101, 5000),
            new BankAccount(102, 10000),
            new BankAccount(103, 7500)
        };

        try {
            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            BankAccount account = findAccount(accounts, accountNumber);

            System.out.print("Enter transaction (D for Deposit / W for Withdrawal): ");
            char choice = sc.next().charAt(0);

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            if (choice == 'D' || choice == 'd') {
                account.deposit(amount);
                System.out.println("Deposit successful.");

            } else if (choice == 'W' || choice == 'w') {
                account.withdraw(amount);
                System.out.println("Withdrawal successful.");

            } else {
                System.out.println("Invalid transaction type.");
                return;
            }

            System.out.println("Account Balance: Rs." + account.getBalance());

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}