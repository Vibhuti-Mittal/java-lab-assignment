import java.util.Objects;
import java.util.Optional;

class GenericUtility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class q5 {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println("Strings equal: " +
                GenericUtility.isEqual(s1, s2));

        System.out.println("Integers equal: " +
                GenericUtility.isEqual(10, 20));

        Optional<String> name = Optional.of("Vibhuti");
        Optional<String> emptyName = Optional.empty();

        System.out.println("Value: " +
                GenericUtility.getDefault(name, "Default"));

        System.out.println("Default value: " +
                GenericUtility.getDefault(emptyName, "Default"));

        System.out.println("Maximum integer: " +
                GenericUtility.max(10, 25));

        System.out.println("Maximum string: " +
                GenericUtility.max("Apple", "Banana"));

        String value = null;

        System.out.println("Is null: " +
                GenericUtility.isNull(value));

        System.out.println("Is null: " +
                GenericUtility.isNull("Hello"));
    }
}