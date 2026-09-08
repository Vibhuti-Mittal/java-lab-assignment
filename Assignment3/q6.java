import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

public class q6 {

    static final String CORRECT_USERNAME = "admin";
    static final String CORRECT_PASSWORD = "1234";
    static final int MAX_ATTEMPTS = 3;

    static void login(String username, String password)
            throws InvalidUsernameException, InvalidPasswordException {

        if (!username.equals(CORRECT_USERNAME)) {
            throw new InvalidUsernameException("Invalid username.");
        }

        if (!password.equals(CORRECT_PASSWORD)) {
            throw new InvalidPasswordException("Invalid password.");
        }

        System.out.println("Login successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        try {
            while (attempts < MAX_ATTEMPTS) {

                try {
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    login(username, password);

                    // Login successful
                    break;

                } catch (InvalidUsernameException e) {
                    attempts++;
                    System.out.println("Error: " + e.getMessage());

                } catch (InvalidPasswordException e) {
                    attempts++;
                    System.out.println("Error: " + e.getMessage());
                }

                if (attempts < MAX_ATTEMPTS) {
                    System.out.println(
                        "Attempts remaining: " + (MAX_ATTEMPTS - attempts)
                    );
                    System.out.println();
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                try {
                    throw new AccountLockedException(
                        "Maximum login attempts exceeded. Account is locked."
                    );
                } catch (AccountLockedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } finally {
            System.out.println("Login process completed.");
            sc.close();
        }
    }
}