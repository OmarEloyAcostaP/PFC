package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.Dryer;
import tafat.metamodel.entity.WashingMachine;

public class CleanClothesRecipe extends Recipe {
	public CleanClothesRecipe(int recipeNumber){
		
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = WashingMachine.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {-1,-1};
			String specialHandling1 = "ON40";
			RecipeLine  line1  = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = Dryer.class;
			int[] startTime2 = {120,120};
			int[] durationTime2 = {-1,-1};
			String specialHandling2 = "ON";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = WashingMachine.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {-1,-1};
			String specialHandling1 = "ON60";
			RecipeLine  line1  = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = Dryer.class;
			int[] startTime2 = {150,150};
			int[] durationTime2 = {-1,-1};
			String specialHandling2 = "ON";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}
	}
}
