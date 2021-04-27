package application;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private VBox calendar;
    private Stage stage;

    public void start(Stage stage){
        this.stage = stage;
        initUI();
        stage.show();
    }

    @FXML
    private void initUI() {
        calendar.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(calendar, 550, 350);
        stage.setScene(scene);

        datefield = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label checkInlabel = new Label("Check-In Date:");
        gridPane.add(checkInlabel, 0, 0);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(datefield, 0, 1);
        calendar.getChildren().add(gridPane);
    }

}
