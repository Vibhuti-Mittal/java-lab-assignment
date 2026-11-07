
import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

public class q3 {

    public static void writeEmployees() {

        Scanner sc = new Scanner(System.in);

        try (ObjectOutputStream oos =
                 new ObjectOutputStream(
                     new FileOutputStream("employees.dat"))) {

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter details of employee " + (i + 1));

                System.out.print("Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                Employee emp = new Employee(id, name, dept, salary);

                oos.writeObject(emp);
            }

            System.out.println("\nEmployee records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static void readEmployees() {

        try (ObjectInputStream ois =
                 new ObjectInputStream(
                     new FileInputStream("employees.dat"))) {

            System.out.println("\nRetrieved Employee Records:");

            while (true) {

                Employee emp = (Employee) ois.readObject();

                emp.display();
            }

        } catch (EOFException e) {
            System.out.println("All employee records retrieved successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Employee file not found!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found!");
        }
    }

    public static void main(String[] args) {

        writeEmployees();

        readEmployees();
    }
}
