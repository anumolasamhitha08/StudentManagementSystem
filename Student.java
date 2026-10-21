
public class Student {
    private String id;
    private String name;
    private String course;
    private double grade;

    public Student(String id, String name, String course,
                   double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException(
                "Grade must be between 0 and 100."
            );
        }
        this.grade = grade;
    }

    public String toFileString() {
        return id + "," + name + "," + course + "," + grade;
    }

    @Override
    public String toString() {
        String gradeText = grade < 0
                ? "Not graded" : String.valueOf(grade);

        return "ID: " + id
                + " | Name: " + name
                + " | Course: " + course
                + " | Grade: " + gradeText;
    }
}
