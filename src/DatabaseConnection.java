import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_system"; // match schema name
    private static final String USER = "root"; // or your MySQL username
    private static final String PASSWORD = "Ketan@2002"; // your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            showFriendlyError("❌ Unable to connect to the database.\n\n" +
                    "Please check:\n- Database name\n- Username/Password\n- MySQL is running");
            return null;
        }
    }

    private static void showFriendlyError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Database Error");
        alert.setHeaderText("😢 Connection Failed");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
