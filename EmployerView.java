package application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployerView extends VBox {
    public EmployerView(Stage primaryStage) {
        Label titleLabel = new Label("Employer View");

        TextArea employeeDataTextArea = new TextArea();

        // Load and display employee data from the text file
        loadEmployeeData(employeeDataTextArea);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> {
            primaryStage.close();

            openLoginPage();
        });

        this.getChildren().addAll(titleLabel, employeeDataTextArea, logoutButton);
        timeout times = new timeout(primaryStage);
    }

    private void openLoginPage() {
        Stage loginStage = new Stage();
        LoginPage loginPage = new LoginPage(loginStage);

        Scene loginScene = new Scene(loginPage, 400, 200);
        loginStage.setScene(loginScene);

        loginStage.show();
    }

    private void loadEmployeeData(TextArea textArea) {
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.appendText(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}