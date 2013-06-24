package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.Computer;
import tafat.metamodel.entity.CookingStove;
import tafat.metamodel.entity.Dishwasher;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Microwave;
import tafat.metamodel.entity.Oven;
import tafat.metamodel.entity.Tv;
import tafat.metamodel.entity.WashingMachine;


public class FamilyWithChildrenRecipe extends Recipe {
	
	@SuppressWarnings("unused")
	public FamilyWithChildrenRecipe(int recipeNumber){

		/* First Person */
		
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0, 30};
			int[] durationTime1 = {-1,-1};
			double[] specialHandling1 = {0.25, 0.3, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {30,60};
			int[] durationTime2 = {5,5};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {30,60};
			int[] durationTime3 = {5,5};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = Oven.class;
			int[] startTime4= {30,90};
			int[] durationTime4 = {20,20};
			String[] specialHandling4 = {"ON", "OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
					
			/* Line 5 */
			Class<?> class5 = AudioHifi.class;
			int[] startTime5 = {30,120};
			int[] durationTime5 = {25,30};
			String[] specialHandling5 = {"ON","STANDBY"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Computer.class;
			int[] startTime6 = {60,120};
			int[] durationTime6 = {10,10};
			String[] specialHandling6 = {"ON","OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Computer.class;
			int[] startTime7 = {60,240};
			int[] durationTime7 = {10,10};
			String[] specialHandling7 = {"ON","OFF"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = Dishwasher.class;
			int[] startTime8 = {120, 960};
			int[] durationTime8 = {-1,-1};
			String specialHandling8 = "ON_ECO";
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = ElectricalTool.class;
			int[] startTime9 = {120,660};
			int[] durationTime9 = {10,20};
			String specialHandling9 = "vacuum";
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
		
			/* Line 10 */
			Class<?> class10 = AudioHifi.class;
			int[] startTime10= {420,660};
			int[] durationTime10 = {45,55};
			String[] specialHandling10 = {"ON", "STANDBY"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);

			/* Line 11 */
			Class<?> class11 = Computer.class;
			int[] startTime11 = {420,660};
			int[] durationTime11 = {20,20};
			String[] specialHandling11 = {"ON","OFF"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12 */
			Class<?> class12 = Computer.class;
			int[] startTime12 = {660,720};
			int[] durationTime12 = {20,20};
			String[] specialHandling12 = {"ON","OFF"};
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = CookRecipe.class;
			int[] startTime13 = {660,720};
			int[] durationTime13 = {-1,-1};
			int specialHandling13 = 11;
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
		
			/* Line 16 */
			Class<?> class16 = Computer.class;
			int[] startTime16 = {780,900};
			int[] durationTime16 = {60,60};
			String[] specialHandling16 = {"ON","OFF"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
			
			/* Line 17 */
			Class<?> class17 = Computer.class;
			int[] startTime17 = {780,900};
			int[] durationTime17 = {60,60};
			String[] specialHandling17 = {"ON","OFF"};
			RecipeLine  line17 = new RecipeLine(class17, startTime17, durationTime17 , specialHandling17);
						
			/* Line 18 */
			Class<?> class18 = Tv.class;
			int[] startTime18 = {780,960};
			int[] durationTime18 = {60,70};
			String[] specialHandling18 = {"ON","STANDBY"};
			RecipeLine  line18 = new RecipeLine(class18, startTime18, durationTime18 , specialHandling18);
			
			/* Line 19 */
			Class<?> class19 = LightingOffRecipe.class;
			int[] startTime19 = {960, 1080};
			int[] durationTime19 = {-1,-1};
			int specialHandling19 = 0;
			RecipeLine line19 = new RecipeLine(class19, startTime19, durationTime19 , specialHandling19);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
//			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
//			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);
			recipe.add(line12);
			recipe.add(line13);
//			recipe.add(line14);
//			recipe.add(line15);
			recipe.add(line16);
			recipe.add(line17);
			recipe.add(line18);
			recipe.add(line19);
			
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,5};
			int[] durationTime1 = {80,85};
			double[] specialHandling1 = {0.15, 0.25, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = Microwave.class;
			int[] startTime2 = {20,40};
			int[] durationTime2 = {5,6};
			String [] specialHandling2 = {"ON900","STANDBY"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {20,40};
			int[] durationTime3 = {5,5};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
					
			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = {20,60};
			int[] durationTime4 = {10,15};
			String[] specialHandling4 = {"ON","OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Lighting.class;
			int[] startTime5 = {690, 720};
			int[] durationTime5 = {-1,-1};
			double[] specialHandling5 = {0.3, 0.5, 0, 0};
			RecipeLine line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = WashingMachine.class;
			int[] startTime6 = {720,900};
			int[] durationTime6 = {-1,-1};
			String specialHandling6 = "ON40";
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Dishwasher.class;
			int[] startTime7 = {720, 900};
			int[] durationTime7 = {-1,-1};
			String specialHandling7 = "ON_ECO";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
					
			/* Line 8 */
			Class<?> class8 = Computer.class;
			int[] startTime8 = {900,960};
			int[] durationTime8 = {15,20};
			String[] specialHandling8 = {"ON","OFF"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = Computer.class;
			int[] startTime9 = {900,960};
			int[] durationTime9 = {15,20};
			String[] specialHandling9 = {"ON","OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
						
			/* Line 10 */
			Class<?> class10 = Tv.class;
			int[] startTime10 = {720, 840};
			int[] durationTime10 = {50,60};
			String[] specialHandling10 = {"ON","STANDBY"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = LightingOffRecipe.class;
			int[] startTime11 = {990, 1020};
			int[] durationTime11 = {-1,-1};
			int specialHandling11 = 0;
			RecipeLine line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12 */
			Class<?> class12 = CookRecipe.class;
			int[] startTime12 = {765,825};
			int[] durationTime12 = {-1,-1};
			int specialHandling12 = 4;
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
		
			/* Line 15 */
			Class<?> class15 = AudioHifi.class;
			int[] startTime15 = {660,720};
			int[] durationTime15 = {35,40};
			String[] specialHandling15 = {"ON","OFF"};
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
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
			recipe.add(line10);
			recipe.add(line11);
			recipe.add(line12);
//			recipe.add(line13);
//			recipe.add(line14);
			recipe.add(line15);
			
						
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {60,90};
			int[] durationTime1 = {60,80};
			double[] specialHandling1 = {0.15, 0.25, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
		    /* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {80,100};
			int[] durationTime2 = {3,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {80,120};
			int[] durationTime3 = {25,30};
			String[] specialHandling3 = {"ON","OFF"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
							
			/* Line 4 */
			Class<?> class4 = Oven.class;
			int[] startTime4= {80,100};
			int[] durationTime4 = {10,15};
			String[] specialHandling4 = {"ON", "OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
		
			/* Line 5 */
			Class<?> class5 = Lighting.class;
			int[] startTime5 = {240, 260};
			int[] durationTime5 = {-1,-1};
			double[] specialHandling5 = {0.3, 0.5, 0, 0};
			RecipeLine line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 with dryer */
			Class<?> class6 = CleanClothesRecipe.class;
			int[] startTime6 = {260,960};
			int[] durationTime6 = {-1,-1};
			int specialHandling6 = 0;
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
		
			/* Line 7 */
			Class<?> class7 = Dishwasher.class;
			int[] startTime7 = {260, 960};
			int[] durationTime7 = {-1,-1};
			String specialHandling7 = "ON_ECO";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
								
			/* Line 8 */
			Class<?> class8 = Oven.class;
			int[] startTime8= {420,450};
			int[] durationTime8 = {20,20};
			String[] specialHandling8 = {"ON", "OFF"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = CookingStove.class;
			int[] startTime9 = {420,450};
			int[] durationTime9 = {10,15};
			String[] specialHandling9 = {"ON", "OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
		
			/* Line 10 */
			Class<?> class10 = CookRecipe.class;
			int[] startTime10 = {720,780};
			int[] durationTime10 = {-1,-1};
			int specialHandling10 = 4;
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
		
			/* Line 13 */
			Class<?> class13 = Oven.class;
			int[] startTime13 = {720,780};
			int[] durationTime13 = {15,20};
			String[] specialHandling13 = {"ON", "OFF"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
			
			/* Line 14 */
			Class<?> class14 = AudioHifi.class;
			int[] startTime14 = {720,750};
			int[] durationTime14 = {25,30};
			String[] specialHandling14 = {"ON","OFF"};
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
				
			/* Line 15 */
			Class<?> class15 = Computer.class;
			int[] startTime15 = {780,990};
			int[] durationTime15 = {60,60};
			String[] specialHandling15 = {"ON","OFF"};
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
			/* Line 16  */
			Class<?> class16 = Computer.class;
			int[] startTime16 = {780,990};
			int[] durationTime16 = {60,60};
			String[] specialHandling16 = {"ON","OFF"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
						
			/* Line 17 */
			Class<?> class17 = Tv.class;
			int[] startTime17 = {780,900};
			int[] durationTime17 = {240,2500};
			String[] specialHandling17 = {"ON","STANDBY"};
			RecipeLine  line17 = new RecipeLine(class17, startTime17, durationTime17 , specialHandling17);
			
			/* Line 18 */
			Class<?> class18 = LightingOffRecipe.class;
			int[] startTime18 = {1020, 1080};
			int[] durationTime18 = {-1,-1};
			int specialHandling18 = 0;
			RecipeLine line18 = new RecipeLine(class18, startTime18, durationTime18 , specialHandling18);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
//			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
//			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
//			recipe.add(line11);
//			recipe.add(line12);
			recipe.add(line13);
			recipe.add(line14);
			recipe.add(line15);
			recipe.add(line16);
			recipe.add(line17);
			recipe.add(line18);	
						
			synchronization = false;
			
			return;
		}
				
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,20};
			int[] durationTime1 = {165,165};
			double[] specialHandling1 = {0.15, 0.25, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {20,120};
			int[] durationTime2 = {2,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = Microwave.class;
			int[] startTime3 = {20,120};
			int[] durationTime3 = {3,4};
			String[] specialHandling3 = {"ON900","STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = CookingStove.class;
			int[] startTime4= {20,120};
			int[] durationTime4 = {8,10};
			String[] specialHandling4 = {"ON", "OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
		
			/* Line 5 */
			Class<?> class5 = ElectricalTool.class;
			int[] startTime5 = {20,120};
			int[] durationTime5 = {5,5};
			String specialHandling5 = "hairDryer";
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Computer.class;
			int[] startTime6 = {20,120};
			int[] durationTime6 = {10,10};
			String[] specialHandling6 = {"ON","OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Computer.class;
			int[] startTime7 = {20,120};
			int[] durationTime7 = {50,60};
			String[] specialHandling7 = {"ON","OFF"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
								
			/* Line 8 */
			Class<?> class8 = Lighting.class;
			int[] startTime8 = {240, 270};
			int[] durationTime8 = {-1,-1};
			double[] specialHandling8 = {0.3, 0.5, 0, 0};
			RecipeLine line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = ElectricalTool.class;
			int[] startTime9 = {340,480};
			int[] durationTime9 = {10,20};
			String specialHandling9 = "vacuum";
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
					
			/* Line 10 */
			Class<?> class10 = Tv.class;
			int[] startTime10 = {510,660};
			int[] durationTime10 = {30,30};
			String[] specialHandling10 = {"ON","STANDBY"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
		
			/* Line 11 */
			Class<?> class11 = CookingStove.class;
			int[] startTime11 = {660,780};
			int[] durationTime11 = {25,30};
			String[] specialHandling11 = {"ON", "OFF"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12 */
			Class<?> class12 = Tv.class;
			int[] startTime12 = {780,900};
			int[] durationTime12 = {80,90};
			String[] specialHandling12 = {"ON","STANDBY"};
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = WashingMachine.class;
			int[] startTime13 = {720,1020};
			int[] durationTime13 = {-1,-1};
			String specialHandling13 = "ON60";
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
						
		    /* Line 14 */
			Class<?> class14 = LightingOffRecipe.class;
			int[] startTime14 = {1020, 1080};
			int[] durationTime14 = {-1,-1};
			int specialHandling14 = 0;
			RecipeLine line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
//			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);
			recipe.add(line12);
//			recipe.add(line13);
			recipe.add(line14);
					
			synchronization = false;
			
			return;
				
		}
						
	}
}
