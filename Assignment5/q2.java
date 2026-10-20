import java.util.Optional;

public class q2 {

    public static void main(String[] args) {

        Optional<String> email = Optional.of("student@gmail.com");

        Optional<String> emptyEmail = Optional.empty();

        email.ifPresent(e -> System.out.println("Email: " + e));

        String defaultEmail = emptyEmail.orElse("default@gmail.com");
        System.out.println("Email using orElse: " + defaultEmail);

        try {
            String missingEmail = emptyEmail.orElseThrow(
                () -> new Exception("Email address is missing")
            );
            System.out.println(missingEmail);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}