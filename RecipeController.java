package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;
import model.Model;

/* This class controls "recipe.fxml". It imports the "Model"
 * class from the created package "model".
 */
public class RecipeController {

    @FXML
    private ListView<?> recipelistv;

    @FXML
    private TextField searchtxt;

    @FXML
    private Button searchbtn;

    @FXML
    private Button addbtn;
    
    /* This method adds a new Recipe when the "Add New Recipe"
     * button is pressed. Right now it adds the String contained
     * in the "searchtxt" text field to the file "recipes.txt",
     * but I am intending to create a new FXML document called
     * "insert new recipe" and have this button open that FXML
     * document instead.
     */
    @FXML
    private void addNewRecipe(ActionEvent event) throws IOException {
    	String recipe = searchtxt.getText();
    	Model.addRecipe(recipe);
    }
}
