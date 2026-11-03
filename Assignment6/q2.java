
import java.io.*;

public class q2 {

    public static void main(String[] args) {

        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("application.log")
            );

            BufferedWriter bw = new BufferedWriter(
                new FileWriter("filtered.log")
            )
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                totalEntries++;

                if (line.contains("ERROR") ||
                    line.contains("WARNING")) {

                    bw.write(line);
                    bw.newLine();

                    if (line.contains("ERROR")) {
                        errorCount++;
                    }

                    if (line.contains("WARNING")) {
                        warningCount++;
                    }
                }
            }

            System.out.println("Log Analysis Completed!");
            System.out.println("Total Log Entries: " + totalEntries);
            System.out.println("Total ERROR Entries: " + errorCount);
            System.out.println("Total WARNING Entries: " + warningCount);
            System.out.println("Filtered entries saved in filtered.log");

        } catch (FileNotFoundException e) {

            System.out.println("Log file not found!");

        } catch (IOException e) {

            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
