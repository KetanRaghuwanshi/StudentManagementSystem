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
    private StudentManagement sm;

    // Constructor that accepts StudentManagement object
    public Dashboard(StudentManagement sm) {
        this.sm = sm;
    }

    public Dashboard() {
        // Default constructor for IDE compatibility (not used in GUI flow)
        this.sm = new StudentManagement();
    }

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("🎓 Student Management System");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        title.setTextFill(Color.DARKSLATEBLUE);

        // Buttons
        Button addBtn = new Button("➕ Add Student");
        Button viewBtn = new Button("👁 View Students");
        Button updateBtn = new Button("✏️ Update Student");
        Button searchButton = new Button("🔍 Search Student");
        Button deleteBtn = new Button("❌ Delete Student");
        Button logoutBtn = new Button("🚪 Logout");

        // Button styling
        for (Button btn : new Button[]{addBtn, viewBtn, updateBtn, searchButton, deleteBtn, logoutBtn}) {
            btn.setPrefWidth(200);
            btn.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        }

        // 👉 Button actions (✅ now calling .show instead of .start)
        addBtn.setOnAction(e -> {
            AddStudentForm form = new AddStudentForm(sm);
            form.show(primaryStage);
        });

        viewBtn.setOnAction(e -> {
            ViewStudentsTable view = new ViewStudentsTable(sm);
            view.show(primaryStage);
        });

        updateBtn.setOnAction(e -> {
            UpdateStudentForm updateForm = new UpdateStudentForm(sm);
            updateForm.show(primaryStage);
        });

        deleteBtn.setOnAction(e -> {
            DeleteStudentForm deleteForm = new DeleteStudentForm(sm);
            deleteForm.show(primaryStage);
        });

        logoutBtn.setOnAction(e -> {
            LoginScreen login = new LoginScreen();
            login.start(primaryStage);
        });

        searchButton.setOnAction(e -> {
            SearchStudentForm searchForm = new SearchStudentForm(sm);
            searchForm.show(primaryStage);
        });


        // Layout
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));
        vbox.getChildren().addAll(title, addBtn, viewBtn, updateBtn,searchButton, deleteBtn, logoutBtn);

        // Scene
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("Dashboard - Student Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
