package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import model.Model;

/* This class controls "recipe.fxml". It imports the "Model"
 * class from the created package "model".
 */
public class RecipeController{
	
	/* These variables are all features of recipe.fxml. These
	 * include: 2 ListViews (displaying the search results),
	 * 4 buttons, 3 textfields, and 1 scroll bar.
	 */

    @FXML
    private ListView<String> recipelistv;
    
    @FXML
    private ListView<String> linkList;

    @FXML
    private Button removeRecipe;

    @FXML
    private Button showAllButton;

    @FXML
    private TextField searchtxt;

    @FXML
    private Button searchbtn;

    @FXML
    private Button addbtn;

    @FXML
    private TextField recipeName;

    @FXML
    private TextField recipeLink;
    
    
    @FXML
    private ScrollBar scroll;
    
    
    /* This method clears the ListViews and the TextFields.
     */
    private void clear() {
    	ObservableList<String> cl = FXCollections.observableArrayList("");
    	searchtxt.setText("");
    	recipeName.setText("");
    	recipeLink.setText("");
    	recipelistv.setItems(cl);
    	linkList.setItems(cl);
    }
    /* This method passes the name of the recipe and the link
     * to the method in the Model class "addRecipe". Then it
     * calls the clear method to clear the textfields and list
     * views. It is triggered when the "Add" button is pressed
     * on recipe.fxml.
     */
    @FXML
    private void addNewRecipe(ActionEvent event) throws Exception {
    	String name = recipeName.getText();
    	String link = recipeLink.getText();
    	Model.addRecipe(name, link);
    	clear();
    }
    /* This method searches for recipes that contain the search
     * text inputted by the user, then displays the resulting
     * recipes and links. It does this by calling the method
     * "findRecipe" in the model class twice: once to fill
     * the ListView recipelistv with the names of the found
     * recipes, and a second time to fill the ListView
     * linkList with the links of the found recipes. It is
     * triggered when the "Search" button is pressed in
     * recipe.fxml.
     */
    @FXML
    private void searchRecipe(ActionEvent event) throws Exception {
    	String find = searchtxt.getText();
    	System.out.println("<"+find+">");
    	clear();
    	ObservableList<String> foundRecipes = FXCollections.observableArrayList(Model.findRecipe(find, true));
    	recipelistv.setItems(foundRecipes);
    	ObservableList<String> foundLinks = FXCollections.observableArrayList(Model.findRecipe(find, false));
    	linkList.setItems(foundLinks);
    }
    
    /* This method shows all the recipes that are currently
     * contained in the file. It does this by calling the
     * method "findRecipe" in the Model class twice: once
     * to fill the ListView recipelistv with the names of
     * the found recipes, and a second time to fill the
     * ListView linkList with the links of the found recipes.
     * It is triggered when the "Show All Recipes" button
     * is pressed in recipe.fxml.
     */
    @FXML
    private void showAllRecipes(ActionEvent event) throws FileNotFoundException {
    	clear();
    	ObservableList<String> foundRecipes = FXCollections.observableArrayList(Model.findRecipe("", true));
    	recipelistv.setItems(foundRecipes);
    	ObservableList<String> foundLinks = FXCollections.observableArrayList(Model.findRecipe("", false));
    	linkList.setItems(foundLinks);
    }
}
