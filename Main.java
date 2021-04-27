package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* This file sets up the stage and launches the FXML file "MainFXML.fxml"*/
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // try launch screen
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
            primaryStage.setTitle("Workout App");
            primaryStage.setScene(new Scene(root, 600, 600));
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    } // end of main
} // end of class
