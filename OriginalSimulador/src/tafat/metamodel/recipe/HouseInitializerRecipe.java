package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Freezer;
import tafat.metamodel.entity.Microwave;
import tafat.metamodel.entity.Radiator;
import tafat.metamodel.entity.Refrigerator;
import tafat.metamodel.entity.Tv;


public class HouseInitializerRecipe extends Recipe {
	public HouseInitializerRecipe(int recipeNumber){
		/* Line 1 */
		Class<?> class1 = Refrigerator.class;
		int[] startTime1 = {0,0};
		int[] durationTime1 = {-1,-1};
		String[] specialHandling1 = {"ON", ""};
		RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
		
		/* Line 2 */
		Class<?> class2 = Microwave.class;
		int[] startTime2 = {0,0};
		int[] durationTime2 = {-1,-1};
		String[] specialHandling2 = {"STANDBY", ""};
		RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
		
		
		/* Line 3 */
		Class<?> class3 = AudioHifi.class;
		int[] startTime3 = {0,0};
		int[] durationTime3 = {-1,-1};
		String[] specialHandling3 = {"STANDBY", ""};
		RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
		
		/* Line 4 */
		Class<?> class4 = Tv.class;
		int[] startTime4 = {0,0};
		int[] durationTime4 = {-1,-1};
		String[] specialHandling4 = {"STANDBY", ""};
		RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
		
		/* Line 5 */
		Class<?> class5 = ElectricalTool.class;
		int[] startTime5 = {0,0};
		int[] durationTime5 = {-1,-1};
		String specialHandling5 = "basisConsumption";
		RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
		
		/* Line 6 */
		Class<?> class6 = Radiator.class;
		int[] startTime6 = {0,0};
		int[] durationTime6 = {-1,-1};
		String[] specialHandling6 = {"ON", "OFF"};
		RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
		
		/* Line 7 */
		Class<?> class7 = Freezer.class;
		int[] startTime7 = {0,0};
		int[] durationTime7 = {-1,-1};
		String[] specialHandling7 = {"ON", ""};
		RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);

		
		recipe = new ArrayList <RecipeLine>();
		recipe.add(line1);
		recipe.add(line2);
		recipe.add(line3);
		recipe.add(line4);
		recipe.add(line5);
		recipe.add(line6);
		recipe.add(line7);
		
		synchronization = false;
	}
}
