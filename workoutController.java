package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Model;
import javafx.scene.layout.Pane;

public class workoutController {

    @FXML
    private AnchorPane workoutbg;
    @FXML
    private BorderPane trackpane2;
    @FXML
    private TextField workoutInput;
    @FXML
    private TextField workoutReps;
    @FXML
    private TextField workoutSets;
    @FXML
    private Button addWorkoutBtn;
    @FXML
    private Button removeWorkoutBtn;
    @FXML
    private Button backbtn;
    @FXML
    private ListView<String> linkList;
    @FXML
    private ListView<String> workoutList;


    /* This method clears the ListViews and the TextFields.
     */
    private void clear() {
        //ObservableList<String> cl = FXCollections.observableArrayList("");
        workoutInput.setText("");
        workoutReps.setText("");
        workoutSets.setText("");
        linkList.setItems(FXCollections.observableArrayList(""));
    }

    @FXML
    public void addWorkout(ActionEvent actionEvent) throws Exception{
        String exercise = workoutInput.getText();
        String reps = workoutReps.getText();
        String sets = workoutSets.getText();
        Model.addWorkout(exercise, reps, sets);
        clear();
    }

    public void removeWorkout(ActionEvent actionEvent) {
    }
}
