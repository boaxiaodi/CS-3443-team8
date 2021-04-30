package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import model.Model;

/* This class controls "recipe.fxml". It imports the "Model"
 * class from the created package "model".
 */
public class RecipeController {

    /* These variables are all features of recipe.fxml. These
     * include: 2 ListViews (displaying the search results),
     * 4 buttons, and 3 TextFields.
     * All items are currently used except for the numberList,
     * which was intended to number the recipes.
     */

    @FXML
    private ListView<Integer> numberList;

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

    public static int x;
    public static ObservableList<String> foundRecipes = FXCollections.observableArrayList("");
    public static ObservableList<String> foundLinks = FXCollections.observableArrayList("");

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
     * to the method in the Model class "addRemoveRecipe". Then
     * it calls the clear method to clear the TextFields and
     * ListViews. It is triggered when the "Add" button is
     * pressed on recipe.fxml.
     */
    @FXML
    private void addNewRecipe(ActionEvent event) throws Exception {
        String name = recipeName.getText();
        String link = recipeLink.getText();
        Model.addRemoveRecipe(name, link, true);
        clear();
    }

    /* This method returns the index of the item that is
     * currently selected. This index is used by the "remove()"
     * method.
     */
    @FXML
    public int click() throws Exception {
        x = recipelistv.getSelectionModel().getSelectedIndex();
        return x;
    }

    /* This method removes the item on the list that the user
     * last selected. It is triggered when the user presses the
     * "Remove" button. Then it immediately updates the ListViews
     * to show that the recipe and its corresponding link has
     * been removed.
     */
    @FXML
    private void remove(ActionEvent event) {
        try {
            showAllRecipes(event);
            Model.addRemoveRecipe(foundRecipes.get(x), foundLinks.get(x), false);
            showAllRecipes(event);
        } catch (Exception e) {
            System.out.println("Error: item cannot be removed.");
            e.printStackTrace();
        }

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
        foundRecipes = FXCollections.observableArrayList(Model.findRecipe(find, true));
        recipelistv.setItems(foundRecipes);
        foundLinks = FXCollections.observableArrayList(Model.findRecipe(find, false));
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
        foundRecipes = FXCollections.observableArrayList(Model.findRecipe("", true));
        recipelistv.setItems(foundRecipes);
        foundLinks = FXCollections.observableArrayList(Model.findRecipe("", false));
        linkList.setItems(foundLinks);
    }


}
