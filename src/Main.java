import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    sm.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    sm.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new Course: ");
                    course = sc.nextLine();
                    sm.updateStudent(id, name, age, course);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    sm.deleteStudent(id);
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
