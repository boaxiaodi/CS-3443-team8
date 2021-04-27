package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* This is the Model class, which currently initializes
 * an ArrayList containing the recipes as well as the
 * file in which the recipes are stored in ("recipes.txt").
 * Then it defines the addRecipe method. I am intending
 * to insert more methods here, including removeRecipe()
 * and searchRecipe().
 */
public class Model {
	public static ArrayList<String> recipes = new ArrayList<String>();
	public static File file = new File("recipes.txt");
	/* This method takes the recipe name as a parameter,
	 * and stores it into the recipes.txt file.
	 */
	public static void addRecipe(String name) throws IOException {
		FileWriter printer = null;
		try {
			printer = new FileWriter(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		recipes.add(name);
		int s = recipes.size();
		int i;
		for (i = 0; i < s; i++) {
			try {
				printer.write(name);
			}
			catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		printer.flush();
	}
}
