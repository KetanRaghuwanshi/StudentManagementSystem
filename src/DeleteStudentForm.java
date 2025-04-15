import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteStudentForm {
    private final StudentManagement sm;

    // Constructor to pass StudentManagement instance
    public DeleteStudentForm(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("❌ Delete Student");

        // Form fields
        Label idLabel = new Label("Student ID:");
        TextField idField = new TextField();

        Button deleteButton = new Button("Delete Student");
        Button backButton = new Button("Back");

        // Action: Delete Student
        deleteButton.setOnAction(e -> {
            String idText = idField.getText().trim();

            if (idText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "⚠️ Error", "Student ID is required!");
                return;
            }

            try {
                int id = Integer.parseInt(idText);
                boolean success = sm.deleteStudent(id);

                if (success) {
                    showAlert(Alert.AlertType.INFORMATION, "✅ Success", "Student deleted successfully!");
                    idField.clear();
                } else {
                    showAlert(Alert.AlertType.ERROR, "⚠️ Error", "Student not found.");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "⚠️ Invalid Input", "ID must be a number.");
            }
        });

        // Action: Back to Dashboard
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(sm);
            dashboard.show(primaryStage);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(idLabel, idField, deleteButton, backButton);

        Scene scene = new Scene(layout, 300, 250);
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
}
