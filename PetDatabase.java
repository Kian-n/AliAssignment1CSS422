import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList to hold pets (declare ONCE)
        ArrayList<Pet> pets = new ArrayList<>();

        while (true) {

            System.out.println("\n1. Add pets");
            System.out.println("2. View pets");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    // Add pets
                    while (true) {
                        System.out.print("Enter pet name (or 'done'): ");
                        String name = scanner.nextLine();

                        if (name.equals("done")) {
                            break;
                        }

                        System.out.print("Enter pet age: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        pets.add(new Pet(name, age));
                    }
                    break;

                case 2:
                    // View pets
                    System.out.println("\n+----------------------+");
                    System.out.printf("| %-3s | %-10s | %-4s |\n", "ID", "NAME", "AGE");
                    System.out.println("+----------------------+");

                    for (int i = 0; i < pets.size(); i++) {
                        Pet p = pets.get(i);
                        System.out.printf("| %-3d | %-10s | %-4d |\n",
                                i, p.getName(), p.getAge());
                    }

                    System.out.println("+----------------------+");
                    System.out.println(pets.size() + " rows in set.");
                    break;

                case 3:
                    // Exit
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
