package application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeView extends VBox {
    public EmployeeView(Stage primaryStage, String username) {
        Label titleLabel = new Label("Employee View");
        Label usernameLabel = new Label("Username: " + username);
        Label teamLabel = new Label("Team: " );
        Label effortLabel = new Label("Effort: " );

        //TextField nameField = new TextField();
        TextField teamField = new TextField();
        TextArea effortArea = new TextArea();

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(event -> {
            //String name = nameField.getText();
            String team = teamField.getText();
            String effort = effortArea.getText();

            // Remove the name for anonymization
            //nameField.clear();

            // Save the data to a text file
            saveData(team, effort);
            teamField.clear();
            effortArea.clear();
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> {
            primaryStage.close();
            openLoginPage();
        });

        this.getChildren().addAll(titleLabel, usernameLabel, teamLabel, teamField, effortLabel, effortArea, submitButton, logoutButton);
        timeout times = new timeout(primaryStage);
    }

    private void saveData(String team, String effort) {
        try (FileWriter fileWriter = new FileWriter("employee_data.txt", true)) {
            // Append the data to the text file
            fileWriter.write("\n"+team + "\n" + effort + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openLoginPage() {
        Stage loginStage = new Stage();
        LoginPage loginPage = new LoginPage(loginStage);

        Scene loginScene = new Scene(loginPage, 400, 200);
        loginStage.setScene(loginScene);

        loginStage.show();
    }
}