import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddStudentForm {
    private final StudentManagement sm;  // Store the reference to StudentManagement

    // Constructor that accepts StudentManagement instance
    public AddStudentForm(StudentManagement sm) {
        this.sm = sm;  // Store the instance for later use
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("➕ Add Student");

        // Form fields
        Label idLabel = new Label("Student ID:");
        TextField idField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label courseLabel = new Label("Course:");
        TextField courseField = new TextField();

        Button addButton = new Button("Add Student");
        Button backButton = new Button("Back");

        // Action: Add Student
        addButton.setOnAction(e -> {
            String idText = idField.getText().trim();
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String course = courseField.getText().trim();

            if (idText.isEmpty() || name.isEmpty() || ageText.isEmpty() || course.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "⚠️ Error", "All fields are required!");
                return;
            }

            try {
                int id = Integer.parseInt(idText);
                int age = Integer.parseInt(ageText);
                Student student = new Student(id, name, age, course);
                sm.addStudent(student);  // Use StudentManagement instance to add the student

                showAlert(Alert.AlertType.INFORMATION, "✅ Success", "Student added successfully!");
                clearFields(idField, nameField, ageField, courseField);
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "⚠️ Invalid Input", "ID and Age must be numbers.");
            }
        });

        // Action: Back to Dashboard
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(sm);  // Pass the StudentManagement instance
            dashboard.show(primaryStage);  // Call show() method instead of start()
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                idLabel, idField,
                nameLabel, nameField,
                ageLabel, ageField,
                courseLabel, courseField,
                addButton, backButton
        );

        Scene scene = new Scene(layout, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Utility method for showing alerts
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Clear the form fields
    private void clearFields(TextField idField, TextField nameField, TextField ageField, TextField courseField) {
        idField.clear();
        nameField.clear();
        ageField.clear();
        courseField.clear();
    }
}
