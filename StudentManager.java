
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentManager implements StudentOperations {
    private final Map<String, Student> students =
            new LinkedHashMap<>();

    private final String fileName = "students.txt";

    public StudentManager() {
        loadData();
    }

    @Override
    public void enrolStudent(String id, String name, String course) {
        if (id.trim().isEmpty() || name.trim().isEmpty()
                || course.trim().isEmpty()) {
            System.out.println("Fields cannot be empty.");
            return;
        }

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.put(id, new Student(id, name, course, -1));
        saveData();
        System.out.println("Student enrolled successfully.");
    }

    @Override
    public boolean updateGrade(String id, double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be from 0 to 100.");
            return false;
        }

        Student student = searchStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        student.setGrade(grade);
        saveData();
        System.out.println("Grade updated successfully.");
        return true;
    }

    @Override
    public Student searchStudent(String id) {
        return students.get(id);
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Student Report ---");

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        for (Student student : students.values()) {
            System.out.println(student);
        }

        System.out.println("Total students: " + students.size());
    }

    @Override
    public void saveData() {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students.values()) {
                writer.write(student.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save data: "
                    + e.getMessage());
        }
    }

    private void loadData() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length != 4) {
                    continue;
                }

                try {
                    String id = parts[0];
                    String name = parts[1];
                    String course = parts[2];
                    double grade = Double.parseDouble(parts[3]);

                    if (id.isEmpty() || name.isEmpty()
                            || course.isEmpty()
                            || grade < -1 || grade > 100
                            || students.containsKey(id)) {
                        continue;
                    }

                    students.put(id,
                            new Student(id, name, course, grade));
                } catch (NumberFormatException e) {
                    System.out.println(
                        "Skipping invalid student record."
                    );
                }
            }
        } catch (IOException e) {
            // The file may not exist on the first run.
            System.out.println("Starting with an empty student list.");
        }
    }
}
