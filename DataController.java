package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

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
    private BorderPane trackpane1;

    @FXML
    private void okbtn(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("workout");
        trackpane1.setCenter(view);
    }

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
