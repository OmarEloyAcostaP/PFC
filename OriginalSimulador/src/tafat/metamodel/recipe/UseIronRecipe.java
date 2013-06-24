package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.ElectricalTool;


public class UseIronRecipe extends Recipe {
	
	public UseIronRecipe(int recipeNumber){ // HACER PULSO
		
		RecipeLine  line1 = null;
		
		switch (recipeNumber){
		case 0:
			/* Line 1 */
			Class<?> class1 = ElectricalTool.class;
			int[] startTime1 = {0,0};
			int[] durationTime1 = {8,15};
			String specialHandling1 = "iron";
			line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			break;
		case 1:
			/* Line 1 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {0,0};
			int[] durationTime2 = {14,21};
			String specialHandling2 = "iron";
			line1 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			break;
		case 2:
			/* Line 1 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {0,0};
			int[] durationTime3 = {26,40};
			String specialHandling3 = "iron";
			line1 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			break;
		}

		recipe = new ArrayList <RecipeLine>();
		recipe.add(line1);
		
		synchronization = false;
	}
}
