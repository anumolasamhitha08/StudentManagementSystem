
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Enrol student");
            System.out.println("2. Add or update grade");
            System.out.println("3. Search student");
            System.out.println("4. Generate report");
            System.out.println("5. Save data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine().trim();

                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Enter course: ");
                        String course = scanner.nextLine().trim();

                        manager.enrolStudent(id, name, course);
                        break;

                    case "2":
                        System.out.print("Enter student ID: ");
                        String gradeId = scanner.nextLine().trim();

                        System.out.print("Enter grade (0-100): ");
                        double grade = Double.parseDouble(
                                scanner.nextLine().trim());

                        manager.updateGrade(gradeId, grade);
                        break;

                    case "3":
                        System.out.print("Enter student ID: ");
                        String searchId = scanner.nextLine().trim();

                        Student student =
                                manager.searchStudent(searchId);

                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case "4":
                        manager.generateReport();
                        break;

                    case "5":
                        manager.saveData();
                        System.out.println("Save operation completed.");
                        break;

                    case "6":
                        manager.saveData();
                        System.out.println("Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Select 1 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid number. Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
