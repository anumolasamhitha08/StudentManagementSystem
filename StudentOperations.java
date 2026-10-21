
public interface StudentOperations {
    void enrolStudent(String id, String name, String course);

    boolean updateGrade(String id, double grade);

    Student searchStudent(String id);

    void generateReport();

    void saveData();
}
