package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DataController {
    @FXML
    private TextArea data1;
    @FXML
    private TextArea data2;
    @FXML
    private TextArea data3;
    @FXML
    private DatePicker datefield;
    @FXML
    private TextArea calinformation;
    @FXML
    private BorderPane trackPane1;
    @FXML
    private Button newWorkoutBtn;
    @FXML
    private Button backButton;

    @FXML
    private void newWorkoutBtn(ActionEvent event) throws IOException{
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("workout");
        trackPane1.setCenter(view);
    }

    @FXML
    private void handleButtonAction(ActionEvent event){
//        calinformation.appendText(datefield.getValue().toString() + "\n");
   }

}