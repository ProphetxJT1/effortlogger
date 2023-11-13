package application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.*;



public class timeout extends VBox {
	private Timeline time;
	public timeout(Stage primaryStage) {
		//creates timer instance of x amount of seconds for timeout
		time = new Timeline(new KeyFrame(Duration.seconds(15), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert exit = new Alert(Alert.AlertType.INFORMATION);
                //alert user that their session is ending
                exit.setHeaderText("You were inactive for (15) seconds, returning to loginpage");
                exit.setTitle("Please relogin");
                exit.show();
                	//force close the session
                	primaryStage.close();
                    // reopen login page to re login
                	openLoginPage();
                    
                    
                    time.stop();
                
            }
        	}));
		
			time.setCycleCount(Timeline.INDEFINITE);
	        time.play();
	        //key stroke resets timer
	        primaryStage.addEventFilter(KeyEvent.ANY, new EventHandler<Event>() {
	            @Override
	            public void handle(Event event) {
	                time.playFromStart();
	            }
	        });
	        //mouse click or movement resets timer
	        primaryStage.addEventFilter(MouseEvent.ANY, new EventHandler<Event>() {
	            @Override
	            public void handle(Event event) {
	                time.playFromStart();
	            }
	        });
	}



	private void openLoginPage() {
	    Stage loginStage = new Stage();
	    LoginPage loginPage = new LoginPage(loginStage);
	
	    Scene loginScene = new Scene(loginPage, 400, 200);
	    loginStage.setScene(loginScene);
	
	    loginStage.show();
	}
}
