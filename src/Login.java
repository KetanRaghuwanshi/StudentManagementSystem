import java.util.Scanner;

public class Login {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("👤 Enter username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("🔒 Enter password: ");
            String inputPassword = scanner.nextLine();

            if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
                System.out.println("✅ Login successful!\n");
                return true;
            } else {
                attempts--;
                System.out.println("❌ Invalid credentials. Attempts left: " + attempts + "\n");
            }
        }

        System.out.println("🚫 Too many failed attempts. Exiting...");
        return false;
    }
}
