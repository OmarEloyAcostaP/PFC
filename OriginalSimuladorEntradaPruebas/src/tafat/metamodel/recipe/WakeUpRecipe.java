package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Microwave;


public class WakeUpRecipe extends Recipe {
	public WakeUpRecipe(int recipeNumber){
		
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {40,60};
			double[] specialHandling1 = {0.3, 0.5, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {15,20};
			int[] durationTime2 = {2,10};
			String specialHandling2 = "hairDryer";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			
			/* Line 3 */
			Class<?> class3 = Microwave.class;
			int[] startTime3 = {30,35};
			int[] durationTime3 = {1,3};
			String[] specialHandling3 = {"ON900", "STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line3);
			recipe.add(line2);
			recipe.add(line1);
			
			synchronization = false;
		}
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {40,60};
			double[] specialHandling1 = {0.3, 0.5, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {15,20};
			int[] durationTime2 = {2,10};
			String specialHandling2 = "hairDryer";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			
			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {30,35};
			int[] durationTime3 = {1,3};
			String specialHandling3 = "waterBoiler";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line3);
			recipe.add(line2);
			recipe.add(line1);
			
			synchronization = false;
		}
		if(recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {40,60};
			double[] specialHandling1 = {0.3, 0.5, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			
			/* Line 2 */
			Class<?> class2 = Microwave.class;
			int[] startTime2 = {30,35};
			int[] durationTime2 = {1,3};
			String[] specialHandling2 = {"ON900", "STANDBY"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
		}
		if(recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {40,60};
			double[] specialHandling1 = {0.3, 0.5, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {30,35};
			int[] durationTime2 = {1,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
		}
	}
}
