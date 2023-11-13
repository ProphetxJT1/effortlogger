package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Effort Logger");

        // Create a login page
        LoginPage loginPage = new LoginPage(primaryStage);

        // Create a scene with the login page
        Scene loginScene = new Scene(loginPage, 400, 200);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}