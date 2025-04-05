import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Dashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title label
        Label title = new Label("🎓 Student Management System");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        title.setTextFill(Color.DARKSLATEBLUE);

        // Buttons with emojis for action
        Button addBtn = new Button("➕ Add Student");
        Button viewBtn = new Button("👁 View Students");
        Button updateBtn = new Button("✏️ Update Student");
        Button deleteBtn = new Button("❌ Delete Student");
        Button logoutBtn = new Button("🚪 Logout");

        // Style the buttons
        for (Button btn : new Button[]{addBtn, viewBtn, updateBtn, deleteBtn, logoutBtn}) {
            btn.setPrefWidth(200);
            btn.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        }

        // Layout
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(title, addBtn, viewBtn, updateBtn, deleteBtn, logoutBtn);

        // Scene and stage
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("Dashboard - Student Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
