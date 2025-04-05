import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateStudentForm {

    private StudentManagement sm;

    public UpdateStudentForm(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        Label titleLabel = new Label("✏️ Update Student");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("New Name");

        TextField ageField = new TextField();
        ageField.setPromptText("New Age");

        TextField courseField = new TextField();
        courseField.setPromptText("New Course");

        Label messageLabel = new Label();

        Button updateBtn = new Button("Update");
        updateBtn.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String course = courseField.getText().trim();

                boolean updated = sm.updateStudent(id, name, age, course);
                if (updated) {
                    messageLabel.setText("✅ Student updated successfully.");
                } else {
                    messageLabel.setText("❌ Student not found.");
                }

            } catch (NumberFormatException ex) {
                messageLabel.setText("❌ Invalid input.");
            }
        });

        Button backBtn = new Button("⬅️ Back");
        backBtn.setOnAction(e -> {
            Dashboard dash = new Dashboard(sm);
            dash.start(primaryStage);
        });

        VBox layout = new VBox(10, titleLabel, idField, nameField, ageField, courseField, updateBtn, backBtn, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Update Student");
        primaryStage.show();
    }
}
