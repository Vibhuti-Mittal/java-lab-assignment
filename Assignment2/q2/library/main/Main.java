package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;
import library.util.InputValidator;

public class Main {

cd     public static void main(String[] args) {

        LibraryResource resource1 =
                new Book(101, "Java Programming", "James Gosling");

        LibraryResource resource2 =
                new DigitalResource(102, "Machine Learning Basics",
                        "Andrew Ng");

        LibraryResource resource3 =
                new Book(103, "Data Structures", "Mark Allen");

        LibraryResource resource4 =
                new DigitalResource(104, "Artificial Intelligence",
                        "Stuart Russell");

        LibraryResource resource5 =
                new Book(105, "Operating Systems", "Abraham Silberschatz");

        LibraryResource[] resources = {
            resource1,
            resource2,
            resource3,
            resource4,
            resource5
        };

        int[] overdueDays = {
            4,
            10,
            2,
            5,
            7
        };

        for (LibraryResource resource : resources) {

            if (!InputValidator.validateResourceId(
                    resource.getResourceId())) {

                System.out.println(
                    "Invalid Resource ID: "
                    + resource.getResourceId()
                );
            }
        }

        LibraryService service = new LibraryService();

        System.out.println(
            "Library Name: " +
            LibraryResource.getLibraryName()
        );

        System.out.println();

        System.out.println("===== LIBRARY RESOURCES =====");

        service.displayResources(resources);

        double totalFine =
                service.calculateTotalFine(resources, overdueDays);

        System.out.println("===== FINE DETAILS =====");

        for (int i = 0; i < resources.length; i++) {

            double fine =
                    resources[i].calculateFine(overdueDays[i]);

            System.out.println(
                "Resource ID: " +
                resources[i].getResourceId() +
                " | Overdue Days: " +
                overdueDays[i] +
                " | Fine: Rs. " +
                fine
            );
        }

        System.out.println();
        System.out.println("Total Fine: Rs. " + totalFine);

        System.out.println();

        LibraryResource.displayTotalResources();
    }
}