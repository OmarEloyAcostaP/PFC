package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.Computer;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Tv;


public class EntertainmentRecipe extends Recipe {
	
	public EntertainmentRecipe(int recipeNumber){

		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {20,240};
			double[] specialHandling1 = {0,0, 0.3, 0.5};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 1){
			
			/* Line 1 */
			Class<?> class1 = ElectricalTool.class;
			int[] startTime1 = {10,20};
			int[] durationTime1 = {2,10};
			String specialHandling1 = "hairDryer";
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			
			/* Line 2 */
			Class<?> class2 = Lighting.class;
			int[] startTime2 = {30,40};
			int[] durationTime2 = {60,240};
			double[] specialHandling2 = {0 , 0, 0.3, 0.5};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = AudioHifi.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {20,30};
			String[] specialHandling1 = {"ON", "STANDBY"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}		
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Computer.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {20,30};
			String[] specialHandling1 = {"ON","OFF"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 4){
			/* Line 1 */
			Class<?> class1 = Tv.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {20,30};
			String[] specialHandling1 = {"ON", "STANDBY"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {20,30};
			String specialHandling2 = "dvdPlayer";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {0,0};
			int[] durationTime3 = {20,30};
			String[] specialHandling3 = {"ON", "STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			
			synchronization = true;
			
			return;
		}
		if (recipeNumber == 5){
			/* Line 1 */
			Class<?> class1 = Tv.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {1,30};
			String[] specialHandling1 = {"ON", "STANDBY"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			
			synchronization = false;
			
			return;
		}
		if (recipeNumber == 6){
			/* Line 1 */
			Class<?> class1 = Tv.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {60,90};
			String[] specialHandling1 = {"ON", "STANDBY"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {60,90};
			String specialHandling2 = "dvdPlayer";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {0,0};
			int[] durationTime3 = {60,90};
			String[] specialHandling3 = {"ON", "STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			
			synchronization = true;
			
			return;
		}
		if (recipeNumber == 7){
			/* Line 1 */
			Class<?> class1 = Tv.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {30,30};
			String[] specialHandling1 = {"ON", "STANDBY"};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {30,30};
			String specialHandling2 = "console";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			
			synchronization = true;
			
			return;
		}
	}
}
