import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    public StudentManager() {

    students = new ArrayList<>();

}

public void addStudent(Student student) {

    students.add(student);
    

    System.out.println("Student added successfully!");

}public void displayAllStudents() {
    for (Student student : students) {
        student.displayStudent();
    }
}public Student searchStudentById(int id) {

    for (Student student : students) {
        if (student.getStudentId() == id) {
    return student;
}

        // yahan student ki ID check karni hai
    }

    return null;
}
public void updateStudent(int id, String newName, int newAge, String newCourse, double newMarks) {

    Student student = searchStudentById(id);

    if (student != null) {
        student.setName(newName);
        student.setAge(newAge);
        student.setCourse(newCourse);
        student.setMarks(newMarks);
        System.out.println("Student name updated successfully!");
    } else {
        System.out.println("Student not found!");
    }
}public void deleteStudent(int id) {

    Student student = searchStudentById(id);

    if (student != null) {
        students.remove(student);
        System.out.println("Student deleted successfully!");
    } else {
        System.out.println("Student not found!");
    }
}
}