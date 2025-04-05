import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteStudentForm {

    private StudentManagement sm;

    public DeleteStudentForm(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        Label titleLabel = new Label("❌ Delete Student");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID to delete");

        Label messageLabel = new Label();

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                boolean deleted = sm.deleteStudent(id);
                if (deleted) {
                    messageLabel.setText("✅ Student deleted successfully.");
                } else {
                    messageLabel.setText("❌ Student not found.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("❌ Invalid ID format.");
            }
        });

        Button backBtn = new Button("⬅️ Back");
        backBtn.setOnAction(e -> {
            Dashboard dash = new Dashboard(sm);
            dash.start(primaryStage);
        });

        VBox layout = new VBox(10, titleLabel, idField, deleteBtn, backBtn, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delete Student");
        primaryStage.show();
    }
}
