import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("=================================");

            // Menu choice
            while (true) {

                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 6) {
                        break;
                    }

                    System.out.println("Please enter choice between 1 and 6.");

                } catch (Exception e) {

                    System.out.println("Invalid choice! Please enter a number.");
                    scanner.nextLine();
                }
            }

            switch (choice) {

                // ================= ADD =================
                case 1:

                    int studentId;

                    while (true) {

                        try {

                            System.out.print("Enter Student ID: ");
                            studentId = scanner.nextInt();

                            if (studentId <= 0) {
                                System.out.println(
                                        "Student ID must be greater than 0!");
                            } else if (manager.searchStudentById(studentId) != null) {
                                System.out.println(
                                        "Student ID already exists!");
                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid ID! Please enter a number.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.next();

                    // Age
                    int age;

                    while (true) {

                        try {

                            System.out.print("Enter Age: ");
                            age = scanner.nextInt();

                            if (age > 0 && age <= 100) {
                                break;
                            }

                            System.out.println(
                                    "Please enter a valid age between 1 and 100!");

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid age! Please enter a number.");
                            scanner.next();
                        }
                    }

                    System.out.print("Enter Course: ");
                    String course = scanner.next();

                    // Marks
                    double marks;

                    while (true) {

                        try {

                            System.out.print("Enter Marks: ");
                            marks = scanner.nextDouble();

                            if (marks >= 0 && marks <= 100) {
                                break;
                            }

                            System.out.println(
                                    "Marks must be between 0 and 100!");

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid marks! Please enter a number.");
                            scanner.nextLine();
                        }
                    }

                    Student student =
                            new Student(studentId, name, age, course, marks);

                    manager.addStudent(student);

                    break;

                // ================= DISPLAY =================
                case 2:

                    manager.displayAllStudents();

                    break;

                // ================= SEARCH =================
                
// ================= SEARCH =================
case 3:

    while (true) {

        try {

            System.out.print("Enter Student ID to search: ");
            int searchId = scanner.nextInt();

            Student foundStudent =
                    manager.searchStudentById(searchId);

            if (foundStudent != null) {
                foundStudent.displayStudent();
            } else {
                System.out.println("Student not found!");
            }

            break;

        } catch (Exception e) {

            System.out.println(
                    "Invalid ID! Please enter a number.");

            scanner.next();
        }
    }

    break;

                // ================= UPDATE =================
                // ================= UPDATE =================
case 4:

    while (true) {

        try {

            System.out.print("Enter Student ID to update: ");
            int updateId = scanner.nextInt();

            Student studentToUpdate =
                    manager.searchStudentById(updateId);

            if (studentToUpdate == null) {

                System.out.println("Student not found!");

            } else {

                System.out.print("Enter new name: ");
                String newName = scanner.next();

                int newAge;

                while (true) {

                    try {

                        System.out.print("Enter new age: ");
                        newAge = scanner.nextInt();

                        if (newAge > 0 && newAge <= 100) {
                            break;
                        }

                        System.out.println(
                                "Please enter a valid age!");

                    } catch (Exception e) {

                        System.out.println(
                                "Invalid age! Please enter a number.");

                        scanner.next();
                    }
                }

                System.out.print("Enter new course: ");
                String newCourse = scanner.next();

                double newMarks;

                while (true) {

                    try {

                        System.out.print("Enter new marks: ");
                        newMarks = scanner.nextDouble();

                        if (newMarks >= 0 && newMarks <= 100) {
                            break;
                        }

                        System.out.println(
                                "Marks must be between 0 and 100!");

                    } catch (Exception e) {

                        System.out.println(
                                "Invalid marks! Please enter a number.");

                        scanner.next();
                    }
                }

                manager.updateStudent(
                        updateId,
                        newName,
                        newAge,
                        newCourse,
                        newMarks
                );
            }

            break;

        } catch (Exception e) {

            System.out.println(
                    "Invalid ID! Please enter a number.");

            scanner.next();
        }

    }

    break;
                // ================= DELETE =================
                // ================= DELETE =================
case 5:

    while (true) {

        try {

            System.out.print("Enter Student ID to delete: ");
            int deleteId = scanner.nextInt();

            manager.deleteStudent(deleteId);

            break;

        } catch (Exception e) {

            System.out.println(
                    "Invalid ID! Please enter a number.");

            scanner.next();
        }
    }

    break;

                // ================= EXIT =================
                case 6:

                    System.out.println(
                            "Thank you for using Student Management System!");

                    break;
            }
        }

        scanner.close();
    }
}