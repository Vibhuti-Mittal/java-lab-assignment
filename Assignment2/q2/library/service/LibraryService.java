package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public void displayResources(LibraryResource[] resources) {

        for (LibraryResource resource : resources) {

            if (resource != null) {

                Printable printable = (Printable) resource;
                printable.printDetails();

                System.out.println("--------------------------------");
            }
        }
    }

    public double calculateTotalFine(
            LibraryResource[] resources, int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            if (resources[i] != null &&
                InputValidator.validateFineDays(overdueDays[i])) {

                totalFine += resources[i]
                        .calculateFine(overdueDays[i]);
            }
        }

        return totalFine;
    }
}