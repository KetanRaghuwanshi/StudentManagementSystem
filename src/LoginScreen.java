import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("🔐 Login to Student Manager");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label messageLabel = new Label();

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);

        loginButton.setOnAction(e -> {
            String inputUsername = usernameField.getText();
            String inputPassword = passwordField.getText();

            if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("✅ Login successful!");

                // Launch Dashboard
                Dashboard dashboard = new Dashboard();
                try {
                    dashboard.start(primaryStage); // Reuse the same stage
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("❌ Invalid username or password.");
            }
        });

        VBox vbox = new VBox(10, titleLabel, usernameField, passwordField, loginButton, messageLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f0f4ff");

        Scene scene = new Scene(vbox, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Student Management System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
