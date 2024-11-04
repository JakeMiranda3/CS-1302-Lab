package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports writing a recipe to a file.
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class RecipeToFile {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Writes a recipe to a file
	 * 
	 * @param recipe Recipe which includes name and list of ingredients
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeRecipeToFile(Recipe recipe) throws FileNotFoundException, IOException {
		if (recipe == null) {
			throw new IllegalArgumentException("Recipe can't be null.");
		}
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				if (recipe.getName().equalsIgnoreCase(reader.nextLine())) {
					throw new IllegalStateException("A recipe already exist in the file with that name");

				}
			}

		}
		try (FileWriter writer = new FileWriter(DATA_FILE, true)) {
			writer.write(Utility.recipeToString(recipe));

		}
	}

}
