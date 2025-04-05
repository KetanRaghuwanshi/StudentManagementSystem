import java.util.*;

public class StudentManagement {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("✅ Student added successfully!");
    }

    public void viewStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("✅ Student updated.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void deleteStudent(int id) {
        if (studentMap.remove(id) != null) {
            System.out.println("✅ Student deleted.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }
}
