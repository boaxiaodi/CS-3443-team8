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

import javax.swing.*;
import java.io.FileNotFoundException;

public class workoutController {
	/* Here, all of the features used in workout.fxml
	 * are declared, as well as a public static int x
	 * that is used in the click() method, and 3
	 * Observable Lists used to populate the ListViews.
	 */

    @FXML
    private Button removeWorkoutBtn;

    @FXML
    private TextField workoutReps;

    @FXML
    private Button addWorkoutBtn;

    @FXML
    private ListView<String> reps;

    @FXML
    private Button viewWorkoutBtn;

    @FXML
    private ListView<String> sets;

    @FXML
    private ListView<String> workouts;

    @FXML
    private TextField workoutSets;

    @FXML
    private TextField workoutInput;

    public static int x;
    public static ObservableList<String> foundExercise = FXCollections.observableArrayList("");
    public static ObservableList<String> foundReps = FXCollections.observableArrayList("");
    public static ObservableList<String> foundSets = FXCollections.observableArrayList("");


    /* This method clears the ListViews and the TextFields.
     */
    private void clear() {
        workoutInput.setText("");
        workoutReps.setText("");
        workoutSets.setText("");
        workouts.setItems(FXCollections.observableArrayList(""));
        reps.setItems(FXCollections.observableArrayList(""));
        sets.setItems(FXCollections.observableArrayList(""));
    }

    /* This method adds a workout and its corresponding reps
     * and sets to the file "exercise.txt". It is triggered
     * when the button "Add" is pressed.
     */
    @FXML
    public void addWorkout(ActionEvent actionEvent) throws Exception{
        String addExercise = workoutInput.getText();
        String addRep = workoutReps.getText();
        String addSet = workoutSets.getText();
        Model.addRemoveWorkout(addExercise, addRep, addSet, true);
        clear();
    }

    /* This method removes a workout and its corresponding reps
     * and sets from the file "exercise.txt". It is triggered when
     * the button "Remove" is pressed, after selecting the desired
     * workout from the ListView.
     */
    public void removeWorkout(ActionEvent event){
        try {
            viewWorkout(event);
            Model.addRemoveWorkout( foundExercise.get(x), foundReps.get(x), foundSets.get(x),false);
            viewWorkout(event);
        } catch (Exception e) {
            System.out.println("Error: item cannot be removed.");
            e.printStackTrace();
        }
    }
    
    /* This method obtains the index value of the ListView object
     * that you clicked. It is used in the removeWorkout() method.
     */
    @FXML
    public int click() throws Exception {
        x = workouts.getSelectionModel().getSelectedIndex();
        return x;
    }
    
    /* This method lets you view all the workouts you entered.
     */
    public void viewWorkout(ActionEvent actionEvent) throws FileNotFoundException {
        clear();
        foundExercise = FXCollections.observableArrayList(Model.findWorkout("", 0));
        workouts.setItems(foundExercise);
        foundReps = FXCollections.observableArrayList(Model.findWorkout("", 1));
        reps.setItems(foundReps);
        foundSets = FXCollections.observableArrayList(Model.findWorkout("", 2));
        sets.setItems(foundSets);
    }
}