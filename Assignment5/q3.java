import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {

    private T[] marks;
    private double threshold;

    Result(T[] marks, double threshold) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
        this.threshold = threshold;
    }

    double calculateAverage() {
        double total = 0;

        for (T mark : marks) {
            total += mark.doubleValue();
        }

        return total / marks.length;
    }

    boolean hasPassed() {
        return calculateAverage() >= threshold;
    }

    void displayResult() {
        Optional<T[]> availableMarks = Optional.ofNullable(marks);

        availableMarks.ifPresent(m -> {
            System.out.println("Average: " + calculateAverage());
            System.out.println("Result: " + (hasPassed() ? "Passed" : "Failed"));
        });
    }
}

public class q3 {

    public static void main(String[] args) {

        Integer[] marks = {85, 90, 78, 92, 88};

        Result<Integer> result = new Result<>(marks, 40);

        result.displayResult();
    }
}