package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.Computer;
import tafat.metamodel.entity.CookingStove;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Tv;
import tafat.metamodel.entity.WashingMachine;


public class SingleJuniorRecipe extends Recipe {
	
	public SingleJuniorRecipe(int recipeNumber){

		/* First Person */
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {60,60};
			int[] durationTime1 = {90,90};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {70,80};
			int[] durationTime2 = {2,2};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = Computer.class;
			int[] startTime3 = {100,110};
			int[] durationTime3 = {30,30};
			String[] specialHandling3 = {"ON","OFF"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = {780, 810};
			int[] durationTime4 = {-1,-1};
			double[] specialHandling4 = {0.2, 0.3, 0, 0};
			RecipeLine line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Computer.class;
			int[] startTime5 = {810,820};
			int[] durationTime5 = {30,30};
			String[] specialHandling5 = {"ON","OFF"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Tv.class;
			int[] startTime6 = {850,860};
			int[] durationTime6 = {60,60};
			String[] specialHandling6 = {"ON", "STANDBY"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = ElectricalTool.class;
			int[] startTime7 = {920,930};
			int[] durationTime7 = {15,15};
			String specialHandling7 = "hairDryer";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = Tv.class;
			int[] startTime8= {945,955};
			int[] durationTime8 = {60,90};
			String[] specialHandling8 = {"ON", "STANDBY"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = Computer.class;
			int[] startTime9 = {1015,1025};
			int[] durationTime9 = {60,120};
			String[] specialHandling9 = {"ON","OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);

			/* Line 10 */
			Class<?> class10 = LightingOffRecipe.class;
			int[] startTime10 = {1020, 1140};
			int[] durationTime10 = {-1,-1};
			int specialHandling10 = 0;
			RecipeLine line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = CookRecipe.class;
			int[] startTime11 = {780,900};
			int[] durationTime11 = {-1,-1};
			int specialHandling11 = 4;
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 13 */
			Class<?> class13 = ElectricalTool.class;
			int[] startTime13 = {780,900};
			int[] durationTime13 = {3,5};
			String specialHandling13 = "waterBoiler";
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);

			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);
			recipe.add(line13);
			
			
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {120,130};
			int[] durationTime1 = {45,60};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {130,135};
			int[] durationTime2 = {3,5};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {130,135};
			int[] durationTime3 = {20,30};
			String[] specialHandling3 = {"ON","STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = {720, 740};
			int[] durationTime4 = {-1,-1};
			double[] specialHandling4 = {0.2, 0.3, 0, 0};
			RecipeLine line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = AudioHifi.class;
			int[] startTime5 = {750,780};
			int[] durationTime5 = {30,30};
			String[] specialHandling5 = {"ON","STANDBY"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = CookingStove.class;
			int[] startTime6 = {780,840};
			int[] durationTime6 = {25,30};
			String[] specialHandling6 = {"ON", "OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = ElectricalTool.class;
			int[] startTime7 = {780,840};
			int[] durationTime7 = {5,5};
			String specialHandling7 = "waterBoiler";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = AudioHifi.class;
			int[] startTime8= {780,800};
			int[] durationTime8 = {25,30};
			String[] specialHandling8 = {"ON", "STANDBY"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = Computer.class;
			int[] startTime9 = {840,960};
			int[] durationTime9 = {90,120};
			String[] specialHandling9 = {"ON","OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
			
			/* Line 10 */
			Class<?> class10 = AudioHifi.class;
			int[] startTime10= {840,960};
			int[] durationTime10 = {90,120};
			String[] specialHandling10 = {"ON", "STANDBY"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);

			/* Line 11 */
			Class<?> class11 = LightingOffRecipe.class;
			int[] startTime11 = {960, 1020};
			int[] durationTime11 = {-1,-1};
			int specialHandling11 = 0;
			RecipeLine line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);
			
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {90,120};
			int[] durationTime1 = {60,75};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			/* Line 2 */
			Class<?> class2 = AudioHifi.class;
			int[] startTime2 = {95,125};
			int[] durationTime2 = {20,30};
			String[] specialHandling2 = {"ON","STANDBY"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
			
			/* Line 3 */
			Class<?> class3 = Lighting.class;
			int[] startTime3 = {780, 800};
			int[] durationTime3 = {-1,-1};
			double[] specialHandling3 = {0.2, 0.3, 0, 0};
			RecipeLine line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = WashingMachine.class;
			int[] startTime4 = {790,810};
			int[] durationTime4 = {-1,-1};
			String specialHandling4 = "ON40";
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = CookRecipe.class;
			int[] startTime5 = {780,900};
			int[] durationTime5 = {-1,-1};
			int specialHandling5 = 4;
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 7 */
			Class<?> class7 = ElectricalTool.class;
			int[] startTime7 = {870,900};
			int[] durationTime7 = {8,10};
			String specialHandling7 = "waterBoiler";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = EntertainmentRecipe.class;
			int[] startTime8= {910,930};
			int[] durationTime8 = {-1,-1};
			int specialHandling8 = 6;
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);

			/* Line 9 */
			Class<?> class9 = LightingOffRecipe.class;
			int[] startTime9 = {990, 1080};
			int[] durationTime9 = {-1,-1};
			int specialHandling9 = 0;
			RecipeLine line9 = new RecipeLine(class9, startTime9, durationTime9, specialHandling9);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
//			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
		
			
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {105, 105};
			int[] durationTime1 = {45,60};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {120,125};
			int[] durationTime2 = {2,5};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {115,120};
			int[] durationTime3 = {3,5};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = {720, 740};
			int[] durationTime4 = {-1,-1};
			double[] specialHandling4 = {0.2, 0.3, 0, 0};
			RecipeLine line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = AudioHifi.class;
			int[] startTime5 = {745,750};
			int[] durationTime5 = {30,30};
			String[] specialHandling5 = {"ON","STANDBY"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = ElectricalTool.class;
			int[] startTime6 = {780,790};
			int[] durationTime6 = {8,15};
			String specialHandling6 = "iron";
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Computer.class;
			int[] startTime7 = {840,870};
			int[] durationTime7 = {20,30};
			String[] specialHandling7 = {"ON","OFF"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = EntertainmentRecipe.class;
			int[] startTime8= {910,930};
			int[] durationTime8 = {-1,-1};
			int specialHandling8 = 6;
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = LightingOffRecipe.class;
			int[] startTime9 = {1020, 1050};
			int[] durationTime9 = {-1,-1};
			int specialHandling9 = 0;
			RecipeLine line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
						
			synchronization = false;
			
			return;
		}
	}
}
