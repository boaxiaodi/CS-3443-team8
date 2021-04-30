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
	/* This method takes the recipe name and link as a
	 * parameter, adds it to their respective ArrayLists,
	 * then writes it to the file "recipes.txt".
	 */
	public static void addRecipe(String name, String link) throws IOException {
		FileWriter printer = null;
		try {
			printer = new FileWriter(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		recipes.add(name);
		links.add(link);
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
	public static void addWorkout(String exercise) throws  IOException{
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
				printer.write(workout.get(i) + "\n");
			}
			catch (IOException e){
				e.printStackTrace();
				break;
			}
		}
		printer.flush();
	}
	
}
