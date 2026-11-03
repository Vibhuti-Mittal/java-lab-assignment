
import java.io.*;
import java.util.Scanner;

public class q1 {

    public static void writeStudentDetails() {

        try (Scanner sc = new Scanner(System.in);
             FileWriter fw = new FileWriter("students.txt")) {

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter details of student " + (i + 1));

                System.out.print("Enter Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();
                sc.nextLine();

                fw.write("Roll Number: " + roll + "\n");
                fw.write("Name: " + name + "\n");
                fw.write("Marks: " + marks + "\n");
                fw.write("--------------------\n");
            }

            System.out.println("\nStudent details saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readStudentDetails() {

        try (FileReader fr = new FileReader("students.txt")) {

            int ch;

            System.out.println("\nStudent Records:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Student file not found!");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void copyBinaryFile() {

        try (FileInputStream fis =
                 new FileInputStream("input.png");

             FileOutputStream fos =
                 new FileOutputStream("copy.png")) {

            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("\nBinary file copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source binary file not found!");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        writeStudentDetails();

        readStudentDetails();

        copyBinaryFile();
    }
}
