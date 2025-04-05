import java.io.*;
import java.util.*;

public class StudentManagement {
    private Map<Integer, Student> studentMap = new HashMap<>();

    // ✅ Add Student
    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("✅ Student added successfully!");
    }

    // 📖 View Students
    public void viewStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }

    // 🔁 Update Student
    // 🔁 Update Student
    public boolean updateStudent(int id, String name, int age, String course) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("✅ Student updated.");
            return true;
        } else {
            System.out.println("❌ Student not found.");
            return false;
        }
    }


    // ❌ Delete Student
    public boolean deleteStudent(int id) {
        if (studentMap.remove(id) != null) {
            System.out.println("✅ Student deleted.");
            return true;
        } else {
            System.out.println("❌ Student not found.");
            return false;
        }
    }


    // 💾 Save to File
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : studentMap.values()) {
                // Saving in format: id,name,age,course
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getCourse());
                writer.newLine();
            }
            System.out.println("📁 Student data saved to file.");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    // 📋 Get All Students
    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }


    // 📂 Load from File
    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    studentMap.put(id, new Student(id, name, age, course));
                }
            }
            System.out.println("📂 Student data loaded from file.");
        } catch (IOException e) {
            System.out.println("❌ Error loading file: " + e.getMessage());
        }
    }
}
