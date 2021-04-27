package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private Button homebtn;
    @FXML
    private Button trackerbtn;
    @FXML
    private Button recipebtn;
    @FXML
    private BorderPane mainPane;

    @FXML
    private void homebtn(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("home");
        mainPane.setCenter(view);
    }
    @FXML
    private void trackerbtn(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("tracker");
        mainPane.setCenter(view);
    }
    @FXML
    private void recipebtn(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("recipe");
        mainPane.setCenter(view);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
