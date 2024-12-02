import java.util.ArrayList;
import java.util.Scanner;

public class StudentArray {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    public void addStudent() {
        String name = inputValidName();
        double marks = inputValidMarks();
        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }
    public void editStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Editing student: " + student);
            String newName = inputValidName();
            double newMarks = inputValidMarks();
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
            displayStudents();

        } else {
            System.out.println("Student not found.");
        }
    }
    public void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            // In tiêu đề bảng
            System.out.printf("%-5s %-20s %-10s %-15s\n", "ID", "Name", "Marks", "Rank");
            System.out.println("-----------------------------------------------");

            // In danh sách sinh viên dưới dạng bảng
            for (Student student : students) {
                System.out.printf("%-5d %-20s %-10.2f %-15s\n", student.getId(), student.getName(), student.getMarks(), student.getRank());
            }
        }
    }
    public void bubbleSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted using Bubble Sort.");
        displayStudents();
    }
    public void selectionSort() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }
            Student temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
        System.out.println("Students sorted using Selection Sort.");
        displayStudents();
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private String inputValidName() {
        while (true) {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            if (name.matches("[a-zA-Z\\s]+")) {
                return name;
            } else {
                System.out.println("Invalid name. Only letters and spaces are allowed. Please try again.");
            }
        }
    }

    private double inputValidMarks() {
        while (true) {
            try {
                System.out.print("Enter Student Marks (0-10): ");
                double marks = Double.parseDouble(scanner.nextLine());
                if (marks >= 0 && marks <= 10) {
                    return marks;
                } else {
                    System.out.println("Marks must be between 0 and 10. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
