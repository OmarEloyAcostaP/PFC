package tafat.metamodel.recipe;

import java.util.ArrayList;

import tafat.engine.social.Recipe;
import tafat.engine.social.RecipeLine;
import tafat.metamodel.entity.AudioHifi;
import tafat.metamodel.entity.Computer;
import tafat.metamodel.entity.Dishwasher;
import tafat.metamodel.entity.ElectricalTool;
import tafat.metamodel.entity.Lighting;
import tafat.metamodel.entity.Microwave;
import tafat.metamodel.entity.Tv;
import tafat.metamodel.entity.WashingMachine;


public class CoupleWithoutChildrenRecipe extends Recipe {
	
	public CoupleWithoutChildrenRecipe(int recipeNumber){

		/* First Person */
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {70,85};
			int[] durationTime1 = {60,70};
			double[] specialHandling1 = {0.2, 0.3, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {95,110};
			int[] durationTime2 = {2,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {90,95};
			int[] durationTime3 = {3,5};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
					
			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = {90,110};
			int[] durationTime4 = {8,10};
			String[] specialHandling4 = {"ON","OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Lighting.class;
			int[] startTime5 = {720, 750};
			int[] durationTime5 = {-1,-1};
			double[] specialHandling5 = {0.4, 0.5, 0, 0};
			RecipeLine line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = ElectricalTool.class;
			int[] startTime6 = {750,810};
			int[] durationTime6 = {8,15};
			String specialHandling6 = "iron";
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = AudioHifi.class;
			int[] startTime7 = {750,760};
			int[] durationTime7 = {0,15};
			String[] specialHandling7 = {"ON","OFF"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
						
			/* Line 8 */
			Class<?> class8 = Computer.class;
			int[] startTime8 = {750,810};
			int[] durationTime8 = {20,30};
			String[] specialHandling8 = {"ON","OFF"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = Computer.class;
			int[] startTime9 = {750,810};
			int[] durationTime9 = {20,30};
			String[] specialHandling9 = {"ON","OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
						
			/* Line 10 */
			Class<?> class10 = Tv.class;
			int[] startTime10 = {750,760};
			int[] durationTime10 = {50,60};
			String[] specialHandling10 = {"ON","STANDBY"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = WashingMachine.class;
			int[] startTime11 = {720,1050};
			int[] durationTime11 = {-1,-1};
			String specialHandling11 = "ON40";
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
		
			/* Line 12 */
			Class<?> class12 = CookRecipe.class;
			int[] startTime12 = {780,900};
			int[] durationTime12 = {-1,-1};
			int specialHandling12 = 11;
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 15 */
			Class<?> class15 = Dishwasher.class;
			int[] startTime15 = {870, 1050};
			int[] durationTime15 = {-1,-1};
			String specialHandling15 = "ON_ECO";
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
			/* Line 16 */
			Class<?> class16 = Computer.class;
			int[] startTime16 = {870,900};
			int[] durationTime16 = {40,45};
			String[] specialHandling16 = {"ON","OFF"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
			
			/* Line 17 */
			Class<?> class17 = Computer.class;
			int[] startTime17 = {870,900};
			int[] durationTime17 = {25,30};
			String[] specialHandling17 = {"ON","OFF"};
			RecipeLine  line17 = new RecipeLine(class17, startTime17, durationTime17 , specialHandling17);
						
			/* Line 18 */
			Class<?> class18 = Tv.class;
			int[] startTime18 = {870,900};
			int[] durationTime18 = {80,90};
			String[] specialHandling18 = {"ON","STANDBY"};
			RecipeLine  line18 = new RecipeLine(class18, startTime18, durationTime18 , specialHandling18);
			
			/* Line 19 */
			Class<?> class19 = LightingOffRecipe.class;
			int[] startTime19 = {990, 1050};
			int[] durationTime19 = {-1,-1};
			int specialHandling19 = 0;
			RecipeLine line19 = new RecipeLine(class19, startTime19, durationTime19 , specialHandling19);
			
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
			recipe.add(line12);
//			recipe.add(line13);
//			recipe.add(line14);
			recipe.add(line15);
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
			int[] startTime1 = {45,75};
			int[] durationTime1 = {105,120};
			double[] specialHandling1 = {0.2, 0.3, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
	        /* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {60,90};
			int[] durationTime2 = {3,5};
			String specialHandling2 = "hairDryer";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);
					
			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {60,120};
			int[] durationTime3 = {25,30};
			String[] specialHandling3 = {"ON","OFF"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = Lighting.class;
			int[] startTime4 = {630, 660};
			int[] durationTime4 = {-1,-1};
			double[] specialHandling4 = {0.4, 0.5, 0, 0};
			RecipeLine line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Computer.class;
			int[] startTime5 = {690,720};
			int[] durationTime5 = {25,30};
			String[] specialHandling5 = {"ON","OFF"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Computer.class;
			int[] startTime6 = {690,720};
			int[] durationTime6 = {25,30};
			String[] specialHandling6 = {"ON","OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
						
			/* Line 7 */
			Class<?> class7 = Tv.class;
			int[] startTime7 = {690,720};
			int[] durationTime7 = {30,30};
			String[] specialHandling7 = {"ON","STANDBY"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = WashingMachine.class;
			int[] startTime8 = {720,1050};
			int[] durationTime8 = {-1,-1};
			String specialHandling8 = "ON40";
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
		
			/* Line 9    with console */
			Class<?> class9 = EntertainmentRecipe.class;
			int[] startTime9 = {750,760};
			int[] durationTime9 = {30,30};
			int specialHandling9 = 7;
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
						
			/* Line 10 */
			Class<?> class10 = CookRecipe.class;
			int[] startTime10 = {810,900};
			int[] durationTime10 = {-1,-1};
			int specialHandling10 = 11;
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = ElectricalTool.class;
			int[] startTime11 = {840,870};
			int[] durationTime11 = {5,5};
			String specialHandling11 = "waterBoiler";
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 13 */
			Class<?> class13 = AudioHifi.class;
			int[] startTime13 = {840,870};
			int[] durationTime13 = {25,30};
			String[] specialHandling13 = {"ON","OFF"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
					
			/* Line 14 */
			Class<?> class14 = Computer.class;
			int[] startTime14 = {870,900};
			int[] durationTime14 = {50,60};
			String[] specialHandling14 = {"ON","OFF"};
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
			
			/* Line 15 */
			Class<?> class15 = Computer.class;
			int[] startTime15 = {870,900};
			int[] durationTime15 = {80,90};
			String[] specialHandling15 = {"ON","OFF"};
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
						
			/* Line 16 with console */
			Class<?> class16 = EntertainmentRecipe.class;
			int[] startTime16 = {900,930};
			int[] durationTime16 = {30,30};
			int specialHandling16 = 7;
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);

			/* Line 17 */
			Class<?> class17 = Tv.class;
			int[] startTime17 = {960,990};
			int[] durationTime17 = {60,90};
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
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
			recipe.add(line9);
			recipe.add(line10);
			recipe.add(line11);
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
				
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {0,20};
			int[] durationTime1 = {50,60};
			double[] specialHandling1 = {0.2, 0.3, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {20,40};
			int[] durationTime2 = {3,5};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = Microwave.class;
			int[] startTime3 = {20,40};
			int[] durationTime3 = {3,5};
			String[] specialHandling3 = {"ON900","STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = {20,40};
			int[] durationTime4 = {10,14};
			String[] specialHandling4 = {"ON","STANDBY"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Lighting.class;
			int[] startTime5 = {690, 750};
			int[] durationTime5 = {-1,-1};
			double[] specialHandling5 = {0.4, 0.5, 0, 0};
			RecipeLine line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Tv.class;
			int[] startTime6 = {870,900};
			int[] durationTime6 = {60,60};
			String[] specialHandling6 = {"ON","STANDBY"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
		
			/* Line 7 */
			Class<?> class7 = LightingOffRecipe.class;
			int[] startTime7 = {930, 990};
			int[] durationTime7 = {-1,-1};
			int specialHandling7 = 0;
			RecipeLine line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
			recipe.add(line4);
			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
					
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {30,60};
			int[] durationTime1 = {120,150};
			double[] specialHandling1 = {0.2, 0.3, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);

			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {50,110};
			int[] durationTime2 = {2,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {50,110};
			int[] durationTime3 = {6,6};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
					
			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = {50,110};
			int[] durationTime4 = {8,10};
			String[] specialHandling4 = {"ON","OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Lighting.class;
			int[] startTime5 = {770, 775};
			int[] durationTime5 = {-1,-1};
			double[] specialHandling5 = {0.4, 0.5, 0, 0};
			RecipeLine line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
									
			/* Line 6 */
			Class<?> class6 = Computer.class;
			int[] startTime6 = {780,790};
			int[] durationTime6 = {20,30};
			String[] specialHandling6 = {"ON","OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Computer.class;
			int[] startTime7 = {780,790};
			int[] durationTime7 = {20,30};
			String[] specialHandling7 = {"ON","OFF"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
						
			/* Line 8 */
			Class<?> class8 = Microwave.class;
			int[] startTime8 = {790,800};
			int[] durationTime8 = {3,5};
			String[] specialHandling8 = {"ON900","STANDBY"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
			
			/* Line 9 */
			Class<?> class9 = CookRecipe.class;
			int[] startTime9 = {780,810};
			int[] durationTime9 = {25,30};
			int specialHandling9 = 11;
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
			
			/* Line 12 */
			Class<?> class12 = Dishwasher.class;
			int[] startTime12 = {840, 1080};
			int[] durationTime12 = {-1,-1};
			String specialHandling12 = "ON_ECO";
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = Computer.class;
			int[] startTime13 = {840,900};
			int[] durationTime13 = {50,60};
			String[] specialHandling13 = {"ON","OFF"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
						
			/* Line 14 */
			Class<?> class14 = Computer.class;
			int[] startTime14 = {840,900};
			int[] durationTime14 = {150,160};
			String[] specialHandling14 = {"ON","OFF"};
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
			
			/* Line 15 with console */
			Class<?> class15 = EntertainmentRecipe.class;
			int[] startTime15 = {900,920};
			int[] durationTime15 = {50,60};
			int specialHandling15 = 7;
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
						
			/* Line 16  */
			Class<?> class16 = Tv.class;
			int[] startTime16 = {980,990};
			int[] durationTime16 = {50,600};
			String[] specialHandling16 = {"ON","STANDBY"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
			
			/* Line 17 */
			Class<?> class17 = LightingOffRecipe.class;
			int[] startTime17 = {1050, 1080};
			int[] durationTime17 = {-1,-1};
			int specialHandling17 = 0;
			RecipeLine line17 = new RecipeLine(class17, startTime17, durationTime17 , specialHandling17);
			
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
//			recipe.add(line10);
//			recipe.add(line11);
			recipe.add(line12);
			recipe.add(line13);
			recipe.add(line14);
			recipe.add(line15);
			recipe.add(line16);
			recipe.add(line17);
							
			synchronization = false;
			
			return;
		}
						
	}
}
