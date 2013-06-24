package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.Lighting;


public class LightingOnRecipe extends Recipe {
	
	public LightingOnRecipe(int recipeNumber){
		/* Line 1 */
		Class<?> class1 = Lighting.class;
		int[] startTime1 = {0,0};
		int[] durationTime1 = {-1,-1};
		double[] specialHandling1 = {0.3, 0.5, 0, 0};
		RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
		
		recipe = new ArrayList <RecipeLine>();
		recipe.add(line1);
		
		synchronization = false;
	}
}
