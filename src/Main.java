import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentArray studentArray = new StudentArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Students");
                System.out.println("5. Display Students");
                System.out.println("6. Sort Students (Bubble Sort)");
                System.out.println("7. Sort Students (Selection Sort)");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> studentArray.addStudent();
                    case 2 -> {
                        System.out.print("Enter Student ID to edit: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        studentArray.editStudent(id);
                    }
                    case 3 -> {
                        System.out.print("Enter Student ID to delete: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        studentArray.deleteStudent(id);
                    }
                    case 4-> {
                        System.out.print("Enter name to search: ");
                        String name = scanner.nextLine();
                        studentArray.searchStudentByName(name);
                    }
                    case 5 -> studentArray.displayStudents();
                    case 6 -> studentArray.bubbleSort();
                    case 7 -> studentArray.selectionSort();
                    case 8  -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

    }
}
