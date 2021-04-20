package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String filename) {
        try {
            URL fileUrl = Main.class.getResource(filename + ".fxml");
            System.out.println(fileUrl);
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML cannot be found");
            }
            view = FXMLLoader.load(fileUrl);
        } catch (Exception e) {
            System.out.println("There is no " + filename + ", Please check FxmlLoader");
        }
        return view;
    }
}

