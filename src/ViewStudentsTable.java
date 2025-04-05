import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewStudentsTable {

    private StudentManagement sm;

    public ViewStudentsTable(StudentManagement sm) {
        this.sm = sm;
    }

    public void show(Stage primaryStage) {
        TableView<Student> table = new TableView<>();

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Student, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        table.getColumns().addAll(idCol, nameCol, ageCol, courseCol);

        // Load student data
        ObservableList<Student> studentList = FXCollections.observableArrayList(sm.getAllStudents());
        table.setItems(studentList);

        Button backButton = new Button("⬅️ Back");
        backButton.setOnAction(e -> {
            Dashboard dashboard = new Dashboard(sm);
            dashboard.start(primaryStage);
        });

        HBox bottomBox = new HBox(backButton);
        bottomBox.setPadding(new Insets(10));
        bottomBox.setSpacing(10);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));
        layout.setCenter(table);
        layout.setBottom(bottomBox);

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setTitle("👁 View Students");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
