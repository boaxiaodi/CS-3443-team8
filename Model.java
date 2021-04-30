package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.FxmlLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/* This is the Model class, which currently initializes
 * an ArrayList containing the recipes as well as the
 * file in which the recipes are stored in ("recipes.txt").
 * Then it defines the addRecipe method and the findRecipe
 * method.
 */
public class Model {
	/* The first 2 ArrayLists are used for storing all of
	 * the recipes and their respective links. The next 2
	 * ArrayLists are used for storing search results.
	 */
	public static ArrayList<String> recipes = new ArrayList<String>();
	public static ArrayList<String> links = new ArrayList<String>();
	public static ArrayList<String> recipeList = new ArrayList<String>();
	public static ArrayList<String> linkList = new ArrayList<String>();
	public static File file = new File("recipes.txt");
	/* This method takes 2 Strings and a boolean as
	 * parameters: representing the recipe name, the recipe
	 * link, and whether the recipe is to be added or
	 * removed, respectively. If it is to be added, then
	 * the name and link of the recipe are added to their
	 * respective ArrayLists. If it is to be removed, then
	 * the name and link of the recipe are removed from
	 * their respective ArrayLists. Then the items are
	 * written into the file "recipes.txt".
	 */
	public static void addRemoveRecipe(String name, String link, boolean add) throws IOException {
		FileWriter printer = null;
		try {
			printer = new FileWriter(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (add == true) {
			recipes.add(name);
			links.add(link);
		}
		else {
			recipes.remove(name);
			links.remove(link);
		}
		
		int s = recipes.size();
		int i;
		for (i = 0; i < s; i++) {
			try {
				printer.write(recipes.get(i)+", "+links.get(i)+"\n");
			}
			catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		printer.flush();
	}
	/* This method returns an ArrayList, and has 2 parameters: String
	 * name and boolean recipe. It searches the file "recipes.txt"
	 * for any Strings that contain the search name. If the boolean
	 * recipe is true, it returns the ArrayList of all recipes that
	 * contain the search name. If the boolean recipe is false, it
	 * returns the ArrayList of all links corresponding to the recipes
	 * containing the search name. These ArrayLists are used to
	 * populate the ListViews in recipe.fxml, and this method is called
	 * in the "searchRecipe" method of RecipeController.java. It is also
	 * called by the "showAllRecipes" method of RecipeController.java,
	 * where the String parameter name is an empty String.
	 */
	public static ArrayList<String> findRecipe(String name, boolean recipe) throws FileNotFoundException {
		int i = 0;
		recipes.clear();
		links.clear();
		recipeList.clear();
		linkList.clear();
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String a = scan.nextLine();
			String[] b = a.split(", ");
			String searchRecipe = b[0];
			String searchLink = b[1];
			recipes.add(searchRecipe);
			links.add(searchLink);
			i++;
		}
		scan.close();
		for (i = 0; i < recipes.size(); i++) {
			if ((recipes.get(i)).contains(name)) {
				recipeList.add(recipes.get(i));
				linkList.add(links.get(i));
			}
		}
		if (recipe == true) {
			return recipeList;
		}
		else {
			return linkList;
		}
		
	}
	/* This method is used to an exercise to a workout linked list and stores it in workouts.txt
	 */
	public static void addWorkout(String exercise, String reps, String sets) throws  IOException{
		FileWriter printer = null;
		try{
			printer = new FileWriter(file);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		workout.add(exercise);
		for(int i = 0; i < workout.size(); i++){
			try{
				printer.write(workout.get(i) + " Reps: " + repi.get(i) + "   X   Sets: " + setss.get(i));
			}
			catch (IOException e){
				e.printStackTrace();
				break;
			}
		}
		printer.flush();
	}
	
}
