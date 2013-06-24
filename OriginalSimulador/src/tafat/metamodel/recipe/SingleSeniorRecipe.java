package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.CookingStove;
import tafat.metamodel.entity.Dishwasher;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Microwave;
import tafat.metamodel.entity.Oven;
import tafat.metamodel.entity.Tv;
import tafat.metamodel.entity.WashingMachine;

public class SingleSeniorRecipe extends Recipe {

	@SuppressWarnings("unused")
	public SingleSeniorRecipe(int recipeNumber) {

		/* First Person */
		if (recipeNumber == 0) {
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = { 0, 20 };
			int[] durationTime1 = { 130, 160 };
			double[] specialHandling1 = { 0.1, 0.1, 0, 0 };
			RecipeLine line1 = new RecipeLine(class1, startTime1,
					durationTime1, specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = { 25, 40 };
			int[] durationTime2 = { 3, 5 };
			String specialHandling2 = "waterBoiler";
			RecipeLine line2 = new RecipeLine(class2, startTime2,
					durationTime2, specialHandling2);

			/* Line 3 */
			Class<?> class3 = CookingStove.class;
			int[] startTime3 = { 60, 90 };
			int[] durationTime3 = { 8, 10 };
			String[] specialHandling3 = { "ON", "OFF" };
			RecipeLine line3 = new RecipeLine(class3, startTime3,
					durationTime3, specialHandling3);

			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = { 200, 230 };
			int[] durationTime4 = { -1, -1 };
			double[] specialHandling4 = { 0.2, 0.25, 0, 0 };
			RecipeLine line4 = new RecipeLine(class4, startTime4,
					durationTime4, specialHandling4);

			/* Line 5 */
			Class<?> class5 = ElectricalTool.class;
			int[] startTime5 = { 285, 340 };
			int[] durationTime5 = { 10, 20 };
			String specialHandling5 = "vacuum";
			RecipeLine line5 = new RecipeLine(class5, startTime5,
					durationTime5, specialHandling5);

			/* Line 6 */
			Class<?> class6 = CookingStove.class;
			int[] startTime6 = { 360, 390 };
			int[] durationTime6 = { 25, 30 };
			String[] specialHandling6 = { "ON", "OFF" };
			RecipeLine line6 = new RecipeLine(class6, startTime6,
					durationTime6, specialHandling6);

			/* Line 7 */
			Class<?> class7 = CookingStove.class;
			int[] startTime7 = { 360, 390 };
			int[] durationTime7 = { 25, 30 };
			String[] specialHandling7 = { "ON", "OFF" };
			RecipeLine line7 = new RecipeLine(class7, startTime7,
					durationTime7, specialHandling7);

			/* Line 8 */
			Class<?> class8 = Oven.class;
			int[] startTime8 = { 360, 390 };
			int[] durationTime8 = { 25, 30 };
			String[] specialHandling8 = { "ON", "OFF" };
			RecipeLine line8 = new RecipeLine(class8, startTime8,
					durationTime8, specialHandling8);

			/* Line 9 */
			Class<?> class9 = Tv.class;
			int[] startTime9 = { 780, 810 };
			int[] durationTime9 = { 60, 60 };
			String[] specialHandling9 = { "ON", "STANDBY" };
			RecipeLine line9 = new RecipeLine(class9, startTime9,
					durationTime9, specialHandling9);

			/* Line 10 */
			Class<?> class10 = LightingOffRecipe.class;
			int[] startTime10 = { 870, 930 };
			int[] durationTime10 = { -1, -1 };
			int specialHandling10 = 0;
			RecipeLine line10 = new RecipeLine(class10, startTime10,
					durationTime10, specialHandling10);

			/* Line 11 */
			Class<?> class11 = CookingStove.class;
			int[] startTime11 = { 360, 390 };
			int[] durationTime11 = { 25, 30 };
			String[] specialHandling11 = { "ON", "OFF" };
			RecipeLine line11 = new RecipeLine(class11, startTime11,
					durationTime11, specialHandling11);

			recipe = new ArrayList<RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			// recipe.add(line7);
			// recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);

			synchronization = false;

			return;
		}

		if (recipeNumber == 1) {
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = { 90, 110 };
			int[] durationTime1 = { 270, 300 };
			double[] specialHandling1 = { 0.1, 0.1, 0, 0 };
			RecipeLine line1 = new RecipeLine(class1, startTime1,
					durationTime1, specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = { 150, 160 };
			int[] durationTime2 = { 2, 2 };
			String specialHandling2 = "waterBoiler";
			RecipeLine line2 = new RecipeLine(class2, startTime2,
					durationTime2, specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = { 115, 140 };
			int[] durationTime3 = { 5, 5 };
			String specialHandling3 = "hairDryer";
			RecipeLine line3 = new RecipeLine(class3, startTime3,
					durationTime3, specialHandling3);

			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = { 170, 180 };
			int[] durationTime4 = { 5, 10 };
			String[] specialHandling4 = { "ON", "STANDBY" };
			RecipeLine line4 = new RecipeLine(class4, startTime4,
					durationTime4, specialHandling4);

			/* Line 5 */
			Class<?> class5 = WashingMachine.class;
			int[] startTime5 = { 120, 350 };
			int[] durationTime5 = { -1, -1 };
			String specialHandling5 = "ON40";
			RecipeLine line5 = new RecipeLine(class5, startTime5,
					durationTime5, specialHandling5);

			/* Line 6 */
			Class<?> class6 = Lighting.class;
			int[] startTime6 = { 810, 840 };
			int[] durationTime6 = { -1, -1 };
			double[] specialHandling6 = { 0.2, 0.25, 0, 0 };
			RecipeLine line6 = new RecipeLine(class6, startTime6,
					durationTime6, specialHandling6);

			/* Line 7 */
			Class<?> class7 = Tv.class;
			int[] startTime7 = { 900, 930 };
			int[] durationTime7 = { 100, 120 };
			String[] specialHandling7 = { "ON", "STANDBY" };
			RecipeLine line7 = new RecipeLine(class7, startTime7,
					durationTime7, specialHandling7);

			/* Line 8 */
			Class<?> class8 = LightingOffRecipe.class;
			int[] startTime8 = { 1020, 1080 };
			int[] durationTime8 = { -1, -1 };
			int specialHandling8 = 0;
			RecipeLine line8 = new RecipeLine(class8, startTime8,
					durationTime8, specialHandling8);

			recipe = new ArrayList<RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);

			synchronization = false;

			return;
		}

		if (recipeNumber == 2) {
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = { 60, 80 };
			int[] durationTime1 = { -1, -1 };
			double[] specialHandling1 = { 0.1, 0.2, 0, 0 };
			RecipeLine line1 = new RecipeLine(class1, startTime1,
					durationTime1, specialHandling1);

			/* Line 2 */
			Class<?> class2 = CookingStove.class;
			int[] startTime2 = { 120, 240 };
			int[] durationTime2 = { 8, 10 };
			String[] specialHandling2 = { "ON", "OFF" };
			RecipeLine line2 = new RecipeLine(class2, startTime2,
					durationTime2, specialHandling2);

			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = { 60, 90 };
			int[] durationTime3 = { 540, 600 };
			String[] specialHandling3 = { "ON", "STANDBY" };
			RecipeLine line3 = new RecipeLine(class3, startTime3,
					durationTime3, specialHandling3);

			/* Line 4 */
			Class<?> class4 = ElectricalTool.class;
			int[] startTime4 = { 330, 360 };
			int[] durationTime4 = { 8, 15 };
			String specialHandling4 = "iron";
			RecipeLine line4 = new RecipeLine(class4, startTime4,
					durationTime4, specialHandling4);

			/* Line 5 */
			Class<?> class5 = Dishwasher.class;
			int[] startTime5 = { 90, 1010 };
			int[] durationTime5 = { -1, -1 };
			String specialHandling5 = "ON_ECO";
			RecipeLine line5 = new RecipeLine(class5, startTime5,
					durationTime5, specialHandling5);

			/* Line 6 */
			Class<?> class6 = CookingStove.class;
			int[] startTime6 = { 390, 420 };
			int[] durationTime6 = { 15, 20 };
			String[] specialHandling6 = { "ON", "OFF" };
			RecipeLine line6 = new RecipeLine(class6, startTime6,
					durationTime6, specialHandling6);

			/* Line 7 */
			Class<?> class7 = ElectricalTool.class;
			int[] startTime7 = { 390, 420 };
			int[] durationTime7 = { 5, 5 };
			String specialHandling7 = "waterBoiler";
			RecipeLine line7 = new RecipeLine(class7, startTime7,
					durationTime7, specialHandling7);

			/* Line 8 */
			Class<?> class8 = CookRecipe.class;
			int[] startTime8 = { 720, 780 };
			int[] durationTime8 = { -1, -1 };
			int specialHandling8 = 6;
			RecipeLine line8 = new RecipeLine(class8, startTime8,
					durationTime8, specialHandling8);

			/* Line 10 */
			Class<?> class10 = Tv.class;
			int[] startTime10 = { 780, 810 };
			int[] durationTime10 = { 180, 200 };
			String[] specialHandling10 = { "ON", "STANDBY" };
			RecipeLine line10 = new RecipeLine(class10, startTime10,
					durationTime10, specialHandling10);

			/* Line 11 */
			Class<?> class11 = LightingOffRecipe.class;
			int[] startTime11 = { 960, 1020 };
			int[] durationTime11 = { -1, -1 };
			int specialHandling11 = 0;
			RecipeLine line11 = new RecipeLine(class11, startTime11,
					durationTime11, specialHandling11);

			recipe = new ArrayList<RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
//			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			// recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);

			synchronization = false;

			return;
		}

		if (recipeNumber == 3) {
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = { 90, 110 };
			int[] durationTime1 = { 170, 190 };
			double[] specialHandling1 = { 0.1, 0.1, 0, 0 };
			RecipeLine line1 = new RecipeLine(class1, startTime1,
					durationTime1, specialHandling1);

			/* Line 2 */
			Class<?> class2 = Microwave.class;
			int[] startTime2 = { 110, 120 };
			int[] durationTime2 = { 2, 5 };
			String[] specialHandling2 = { "ON900", "STANDBY" };
			RecipeLine line2 = new RecipeLine(class2, startTime2,
					durationTime2, specialHandling2);

			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = { 110, 225 };
			int[] durationTime3 = { 25, 30 };
			String[] specialHandling3 = { "ON", "STANDBY" };
			RecipeLine line3 = new RecipeLine(class3, startTime3,
					durationTime3, specialHandling3);

			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = { 340, 360 };
			int[] durationTime4 = { -1, -1 };
			double[] specialHandling4 = { 0.2, 0.25, 0, 0 };
			RecipeLine line4 = new RecipeLine(class4, startTime4,
					durationTime4, specialHandling4);

			/* Line 5 */
			Class<?> class5 = CookingStove.class;
			int[] startTime5 = { 390, 420 };
			int[] durationTime5 = { 10, 15 };
			String[] specialHandling5 = { "ON", "OFF" };
			RecipeLine line5 = new RecipeLine(class5, startTime5,
					durationTime5, specialHandling5);

			/* Line 6 */
			Class<?> class6 = CookingStove.class;
			int[] startTime6 = { 390, 420 };
			int[] durationTime6 = { 25, 30 };
			String[] specialHandling6 = { "ON", "OFF" };
			RecipeLine line6 = new RecipeLine(class6, startTime6,
					durationTime6, specialHandling6);

			/* Line 7 */
			Class<?> class7 = Oven.class;
			int[] startTime7 = { 390, 420 };
			int[] durationTime7 = { 15, 20 };
			String[] specialHandling7 = { "ON", "OFF" };
			RecipeLine line7 = new RecipeLine(class7, startTime7,
					durationTime7, specialHandling7);

			/* Line 8 */
			Class<?> class8 = AudioHifi.class;
			int[] startTime8 = { 110, 225 };
			int[] durationTime8 = { 25, 30 };
			String[] specialHandling8 = { "ON", "STANDBY" };
			RecipeLine line8 = new RecipeLine(class8, startTime8,
					durationTime8, specialHandling8);

			/* Line 9 */
			Class<?> class9 = Tv.class;
			int[] startTime9 = { 900, 930 };
			int[] durationTime9 = { 100, 120 };
			String[] specialHandling9 = { "ON", "STANDBY" };
			RecipeLine line9 = new RecipeLine(class9, startTime9,
					durationTime9, specialHandling9);

			/* Line 10 */
			Class<?> class10 = LightingOffRecipe.class;
			int[] startTime10 = { 1070, 1080 };
			int[] durationTime10 = { -1, -1 };
			int specialHandling10 = 0;
			RecipeLine line10 = new RecipeLine(class10, startTime10,
					durationTime10, specialHandling10);

			recipe = new ArrayList<RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
//			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);

			synchronization = false;

			return;

		}
	}
}
