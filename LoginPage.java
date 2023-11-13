package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPage extends VBox {
    public LoginPage(Stage primaryStage) {
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label usernameLabel = new Label("Username: " );
        Label passwordLabel = new Label("Password: " );

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Check username and password here (implement your logic)

            if (false) {
                // If valid user, show employee/employer view
                if (isEmployee(username)) {
                    // Show employee view
                    EmployeeView employeeView = new EmployeeView(primaryStage, username);
                    Scene employeeScene = new Scene(employeeView, 400, 400);
                    primaryStage.setScene(employeeScene);
                } else if (isEmployer(username)) {
                    // Show employer view
                    EmployerView employerView = new EmployerView(primaryStage);
                    Scene employerScene = new Scene(employerView, 400, 400);
                    primaryStage.setScene(employerScene);
                }
            } else {
            	Alert exit = new Alert(Alert.AlertType.INFORMATION);
                //alert user that their session is ending
                exit.setHeaderText("Please try again");
                exit.setTitle("Incorrect username or password");
                exit.show();
            }
        });

         Button quitButton = new Button("Quit");
        quitButton.setOnAction(event -> {
            // Close the JavaFX application
            Platform.exit();
        });

        this.getChildren().addAll(usernameLabel, usernameField,passwordLabel, passwordField, loginButton, quitButton);
    }

    private boolean isValidUser(String username, String password) {
        // Implement your logic for user validation
        // You can check against a predefined username and password
        return true;
    }

    private boolean isEmployee(String username) {
        if(username.equals("employee")) {
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmployer(String username) {
       if(username.equals("employer")){
              return true;  
       }else{
        return false;
        }
    }
    private boolean checkusernamepassword(String username, String password) {
    	boolean num = false;
        try (BufferedReader readers = new BufferedReader(new FileReader("username.txt"))) {
            String line;
            String userpass = username + " " + password;
            while ((line = readers.readLine()) != null) {
                if(line.equals(userpass)) {
                	num = true;
                	break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
    
}
