import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchStudentForm {
    private StudentManagement sm;

    public SearchStudentForm(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        Label titleLabel = new Label("🔍 Search Student by ID");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");

        Label resultLabel = new Label();

        Button searchButton = new Button("Search");
        Button backButton = new Button("⬅️ Back");

        searchButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                Student student = sm.getStudentById(id);
                if (student != null) {
                    resultLabel.setText("✅ Found: " + student.toString());
                } else {
                    resultLabel.setText("❌ Student not found.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("⚠️ Invalid ID. Please enter a number.");
            }
        });

        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(sm);
            dashboard.start(primaryStage);
        });

        VBox vbox = new VBox(10, titleLabel, idField, searchButton, resultLabel, backButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Search Student");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
