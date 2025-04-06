import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddStudentForm {

    private final StudentManagement sm;

    public AddStudentForm(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        Label titleLabel = new Label("➕ Add New Student");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        TextField courseField = new TextField();
        courseField.setPromptText("Course");

        Label messageLabel = new Label();

        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String course = courseField.getText().trim();

                if (name.isEmpty() || course.isEmpty()) {
                    messageLabel.setText("⚠️ Please fill all fields.");
                    return;
                }

                sm.addStudent(new Student(id, name, age, course));
                messageLabel.setText("✅ Student added!");

                // Clear fields
                idField.clear();
                nameField.clear();
                ageField.clear();
                courseField.clear();

            } catch (NumberFormatException ex) {
                messageLabel.setText("❌ Invalid input! Make sure ID and Age are numbers.");
            }
        });

        Button backButton = new Button("⬅️ Back");
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(sm);
            dashboard.start(primaryStage);
        });

        VBox vbox = new VBox(10, titleLabel, idField, nameField, ageField, courseField, addButton, backButton, messageLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #f5faff;");

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Student");
        primaryStage.show();
    }
}
