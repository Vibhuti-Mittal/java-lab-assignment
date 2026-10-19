import java.util.*;

class Course {
    String courseCode;
    String courseName;
    int capacity;

    HashSet<String> enrolledStudents;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;

    Course(String courseCode, String courseName, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.capacity = capacity;
        enrolledStudents = new HashSet<>();
        prerequisites = new ArrayList<>();
        waitlist = new LinkedList<>();
    }

    void addPrerequisite(String courseCode) {
        prerequisites.add(courseCode);
    }

    void registerStudent(String studentId) {
        if (enrolledStudents.contains(studentId)) {
            System.out.println(studentId + " is already enrolled.");
            return;
        }

        if (waitlist.contains(studentId)) {
            System.out.println(studentId + " is already on the waitlist.");
            return;
        }

        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(studentId);
            System.out.println(studentId + " successfully enrolled in " + courseCode);
        } else {
            waitlist.addLast(studentId);
            System.out.println(courseCode + " is full. " + studentId + " added to waitlist.");
        }
    }

    void dropStudent(String studentId) {
        if (!enrolledStudents.contains(studentId)) {
            System.out.println(studentId + " is not enrolled in " + courseCode);
            return;
        }

        enrolledStudents.remove(studentId);
        System.out.println(studentId + " dropped from " + courseCode);

        if (!waitlist.isEmpty()) {
            String nextStudent = waitlist.removeFirst();
            enrolledStudents.add(nextStudent);
            System.out.println(nextStudent + " promoted from waitlist to " + courseCode);
        }
    }

    void displayCourse() {
        System.out.println("\nCourse Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Prerequisites: " + prerequisites);
        System.out.println("Waitlist: " + waitlist);
    }
}

public class CourseRegistrationPortal {

    static HashMap<String, Course> courses = new HashMap<>();

    static void addCourse(Course course) {
        courses.put(course.courseCode, course);
    }

    static Course findCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public static void main(String[] args) {

        Course dsa = new Course("COE201", "Data Structures", 2);
        Course dbms = new Course("COE202", "Database Management Systems", 2);

        dbms.addPrerequisite("COE201");

        addCourse(dsa);
        addCourse(dbms);

        dsa.registerStudent("S101");
        dsa.registerStudent("S102");
        dsa.registerStudent("S103");
        dsa.registerStudent("S104");

        dsa.displayCourse();

        System.out.println("\n--- Dropping S101 ---");
        dsa.dropStudent("S101");

        dsa.displayCourse();

        System.out.println("\n--- Course Search ---");

        Course found = findCourse("COE202");

        if (found != null) {
            System.out.println("Found: " + found.courseCode + " - " + found.courseName);
        } else {
            System.out.println("Course not found.");
        }
    }
}