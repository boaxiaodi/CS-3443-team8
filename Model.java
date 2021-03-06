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
 * ArrayLists containing recipe data and workout data, 
 * as well as the files in which the data is stored in
 * ("recipes.txt"). Then it defines the addRemoveRecipe
 * method, the findRecipe method, the addRemoveWorkout
 * method, and the findWorkout method.
 */
public class Model {
	/* These ArrayLists are used for storing data, and for
	 * storing the search results of the data.
	 */
	public static ArrayList<String> recipes = new ArrayList<String>();
	public static ArrayList<String> links = new ArrayList<String>();
	public static ArrayList<String> recipeList = new ArrayList<String>();
	public static ArrayList<String> linkList = new ArrayList<String>();
	public static ArrayList<String> workout = new ArrayList<String>();
	public static ArrayList<String> set = new ArrayList<String>();
	public static ArrayList<String> rep = new ArrayList<String>();
	public static ArrayList<String> workoutList = new ArrayList<String>();
	public static ArrayList<String> setList = new ArrayList<String>();
	public static ArrayList<String> repList = new ArrayList<String>();
	public static File file = new File("recipes.txt");
	public static File workoutFile = new File("exercise.txt");
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
	
	/* This method is similar to addRemoveRecipe method, except
	 * it adds/removes the workout data instead.
	 */
	public static void addRemoveWorkout(String exercise, String reps, String sets, boolean add) throws  IOException{
		FileWriter printer = null;
		try{
			printer = new FileWriter(workoutFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (add == true){
			workout.add(exercise);
			rep.add(reps);
			set.add(sets);
		}
		else{
			workout.remove(exercise);
			rep.remove(reps);
			set.remove(sets);
		}

		for(int i = 0; i < workout.size(); i++){
			try{
				printer.write(workout.get(i) + ", " + rep.get(i) + ", " + set.get(i) + "\n");
			}
			catch (IOException e){
				e.printStackTrace();
				break;
			}
		}
		printer.flush();
	}
	
	/* This method is similar to the findRecipe method, except
	 * it's for workout data. Parameter "n" is used for differentiating
	 * which ArrayList will be returned: it works the same way as
	 * the boolean parameter in findRecipe, but it is an integer
	 * since there are more than 2 possible ArrayLists.
	 */
	public static ArrayList<String> findWorkout(String name, int n) throws FileNotFoundException {
		int i = 0;
		workout.clear();
		rep.clear();
		set.clear();
		workoutList.clear();
		setList.clear();
		repList.clear();
		Scanner scan = new Scanner(workoutFile);
		while (scan.hasNextLine()) {
			String a = scan.nextLine();
			String[] b = a.split(", ");
			String searchWorkOut = b[0];
			String searchRep = b[1];
			String searchSet = b[2];
			workout.add(searchWorkOut);
			rep.add(searchRep);
			set.add(searchSet);
			i++;
		}
		scan.close();
		for (i = 0; i < workout.size(); i++) {
			if ((workout.get(i)).contains(name)) {
				workoutList.add(workout.get(i));
				repList.add(rep.get(i));
				setList.add(set.get(i));
			}
		}
		if (n == 0) {
			return workoutList;
		}
		else if (n==1) {
			return repList;
		}
		else {
			return setList;
		}
	}
	
}
