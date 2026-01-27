import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList to hold pets
        ArrayList<Pet> pets = new ArrayList<>();

        while (true) {

            System.out.println("\n1. Add pets");
            System.out.println("2. View pets");
            System.out.println("3. Searrch by name");
            System.out.println("4. Search by age");
            System.out.println("5. Exit");
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
                    //allows to search for pet through the name
                    System.out.print("\nEnter pet name to search: ");
                    String search = scanner.nextLine();
                    boolean found = false;

                    //loop throuh all pets and check if any of the names match
                    for (Pet p : pets) {
                        if (p.getName().equals(search)) {
                            System.out.println("Found: " + p.getName() + " " + p.getAge());
                            found = true;
                        }
                    }

                    //if name is not found returns and lets the user know
                    if (!found) {
                        System.out.println("No pet found with that name.");
                    }
                    break;    

                case 4:
                    System.out.print("\nEnter pet age to search: ");
                    int ageSearch = Integer.parseInt(scanner.nextLine());
                    boolean foundAge = false;

                    for (Pet p : pets) {
                        if (p.getAge() == ageSearch) {
                            System.out.println("Found: " + p.getName() + " " + p.getAge());
                            foundAge = true;
                        }
                    }

                    if (!foundAge) {
                        System.out.println("No pet found with that age.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        } 
    }
}
