public class Student extends Person {

    private int studentId;
    private String course;
    private double marks;

    public Student(int studentId, String name, int age,
                   String course, double marks) {

        super(name, age);

        this.studentId = studentId;
        this.course = course;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }
}