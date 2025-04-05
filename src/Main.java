import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        String filename = "students.txt"; // 📁 File for saving/loading

        // 📂 Load existing student data
        sm.loadFromFile(filename);

        while (true) {
            System.out.println("\n🎓 Student Management System");
            System.out.println("1️⃣ Add Student");
            System.out.println("2️⃣ View Students");
            System.out.println("3️⃣ Update Student");
            System.out.println("4️⃣ Delete Student");
            System.out.println("5️⃣ Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    sm.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    sm.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new Course: ");
                    String newCourse = scanner.nextLine();

                    sm.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    sm.deleteStudent(deleteId);
                    break;

                case 5:
                    // 💾 Save data before exiting
                    sm.saveToFile(filename);
                    System.out.println("👋 Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
