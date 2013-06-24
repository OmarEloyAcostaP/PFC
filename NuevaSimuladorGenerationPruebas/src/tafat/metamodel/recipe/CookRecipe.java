package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.CookingStove;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Microwave;
import tafat.metamodel.entity.Oven;


public class CookRecipe extends Recipe {
	
	public CookRecipe(int recipeNumber){

		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Microwave.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {1,8};
			String[] specialHandling1 = {"ON900", "STANDBY"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = ElectricalTool.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {1,5};
			String specialHandling1 = "waterBoiler";
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}		
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Microwave.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {10,20};
			String[] specialHandling1 = {"ON900", "STANDBY"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = CookingStove.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {10,30};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 4){
			/* Line 1 */
			Class<?> class1 = CookingStove.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {25,30};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {25,30};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}

		if (recipeNumber == 5){
			/* Line 1 */
			Class<?> class1 = Oven.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {15,40};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 6){
			/* Line 1 */
			Class<?> class1 = Microwave.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {10,15};
			String[] specialHandling1 = {"ON900", "STANDBY"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {10,30};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 7){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {90,120};
			double[] specialHandling1 = {0,0, 0.3, 0.5};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 8){
			/* Line 1 */
			Class<?> class1 = Oven.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {15,40};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {10,30};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 9){
			/* Line 1 */
			Class<?> class1 = CookingStove.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {25,30};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {25,30};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = CookingStove.class;
			int[] startTime3 = {0,0};
			int[] durationTime3 = {25,30};
			String[] specialHandling3 = {"ON", "OFF"};
			RecipeLine line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 10){
			/* Line 1 */
			Class<?> class1 = CookingStove.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {10,30};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {10,30};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = CookingStove.class;
			int[] startTime3 = {0,0};
			int[] durationTime3 = {10,30};
			String[] specialHandling3 = {"ON", "OFF"};
			RecipeLine line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = CookingStove.class;
			int[] startTime4 = {0,0};
			int[] durationTime4 = {10,30};
			String[] specialHandling4 = {"ON", "OFF"};
			RecipeLine line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 11){
			/* Line 1 */
			Class<?> class1 = CookingStove.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {15,20};
			String[] specialHandling1 = {"ON", "OFF"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {15,20};
			String[] specialHandling2 = {"ON", "OFF"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = Oven.class;
			int[] startTime3= {0,0};
			int[] durationTime3 = {15,20};
			String[] specialHandling3 = {"ON", "OFF"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			
			synchronization = false;
			
			return;
		}
	}
}
