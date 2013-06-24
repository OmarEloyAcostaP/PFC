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


public class SeniorCoupleRecipe extends Recipe {
	
	@SuppressWarnings("unused")
	public SeniorCoupleRecipe(int recipeNumber){

		/* First Person */
		
		if (recipeNumber == 0){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {150,180};
			int[] durationTime1 = {-1,-1};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {180,200};
			int[] durationTime2 = {3,5};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = AudioHifi.class;
			int[] startTime3 = {190,210};
			int[] durationTime3 = {25,30};
			String[] specialHandling3 = {"ON","STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 with dryer */
			Class<?> class4 = CleanClothesRecipe.class;
			int[] startTime4 = {180,480};
			int[] durationTime4 = {-1,-1};
			int specialHandling4 = 1;
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = ElectricalTool.class;
			int[] startTime5 = {210,300};
			int[] durationTime5 = {15,30};
			String specialHandling5 = "vacuum";
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
		
			/* Line 6 */
			Class<?> class6 = ElectricalTool.class;
			int[] startTime6 = {330,360};
			int[] durationTime6 = {3,5};
			String specialHandling6 = "waterBoiler";
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);

			/* Line 7 */
			Class<?> class7 = Microwave.class;
			int[] startTime7 = {330,360};
			int[] durationTime7 = {8,10};
			String[] specialHandling7 = {"ON900","STANDBY"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = CookingStove.class;
			int[] startTime8= {330,360};
			int[] durationTime8 = {25,30};
			String[] specialHandling8 = {"ON", "OFF"};
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
		
			/* Line 9 */
			Class<?> class9 = Oven.class;
			int[] startTime9= {330,360};
			int[] durationTime9 = {50,60};
			String[] specialHandling9 = {"ON", "OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
									
			/* Line 10 */
			Class<?> class10 = Dishwasher.class;
			int[] startTime10 = {180, 1020};
			int[] durationTime10 = {-1,-1};
			String specialHandling10 = "ON_ECO";
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = Computer.class;
			int[] startTime11 = {720,930};
			int[] durationTime11 = {100,120};
			String[] specialHandling11 = {"ON","OFF"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12 */
			Class<?> class12 = Tv.class;
			int[] startTime12 = {720,930};
			int[] durationTime12 = {50,60};
			String[] specialHandling12 = {"ON","STANDBY"};
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = Tv.class;
			int[] startTime13 = {720,930};
			int[] durationTime13 = {100,120};
			String[] specialHandling13 = {"ON", "STANDBY"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
			
			/* Line 14 */
			Class<?> class14 = ElectricalTool.class;
			int[] startTime14 = {720,930};
			int[] durationTime14 = {8,10};
			String specialHandling14 = "hairDryer";
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
		
			/* Line 15 */
			Class<?> class15 = LightingOffRecipe.class;
			int[] startTime15 = {1020, 1050};
			int[] durationTime15 = {-1,-1};
			int specialHandling15 = 0;
			RecipeLine line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
			recipe = new ArrayList <RecipeLine>();
			recipe.add(line1);
			recipe.add(line2);
			recipe.add(line3);
//			recipe.add(line4);
//			recipe.add(line5);
			recipe.add(line6);
			recipe.add(line7);
			recipe.add(line8);
//			recipe.add(line9);
//			recipe.add(line10);
			recipe.add(line11);
			recipe.add(line12);
			recipe.add(line13);
			recipe.add(line14);
			recipe.add(line15);
					
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 1){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {90,120};
			int[] durationTime1 = {600,600};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = Microwave.class;
			int[] startTime2 = {150,180};
			int[] durationTime2 = {10,15};
			String [] specialHandling2 = {"ON900","STANDBY"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {120,140};
			int[] durationTime3 = {15,20};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = CookingStove.class;
			int[] startTime4= {150,180};
			int[] durationTime4 = {10,15};
			String[] specialHandling4 = {"ON", "OFF"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
		
			/* Line 5 */
			Class<?> class5 = AudioHifi.class;
			int[] startTime5 = {180,210};
			int[] durationTime5 = {230,250};
			String[] specialHandling5 = {"ON","STANDBY"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Computer.class;
			int[] startTime6 = {180,300};
			int[] durationTime6 = {50,60};
			String[] specialHandling6 = {"ON","OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = Dishwasher.class;
			int[] startTime7 = {120, 1020};
			int[] durationTime7 = {-1,-1};
			String specialHandling7 = "ON_ECO";
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
						
			/* Line 8 with dryer */
			Class<?> class8 = CleanClothesRecipe.class;
			int[] startTime8 = {120,480};
			int[] durationTime8 = {-1,-1};
			int specialHandling8 = 1;
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
		
			/* Line 9 */
			Class<?> class9 = Microwave.class;
			int[] startTime9 = {360,390};
			int[] durationTime9 = {15,20};
			String [] specialHandling9 = {"ON900","STANDBY"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);

			/* Line 10 */
			Class<?> class10 = CookingStove.class;
			int[] startTime10= {360,390};
			int[] durationTime10 = {15,20};
			String[] specialHandling10 = {"ON", "OFF"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
		
			/* Line 11 */
			Class<?> class11 = CookingStove.class;
			int[] startTime11= {360,390};
			int[] durationTime11 = {15,20};
			String[] specialHandling11 = {"ON", "OFF"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
		
			/* Line 12 */
			Class<?> class12 = Oven.class;
			int[] startTime12= {360,390};
			int[] durationTime12 = {40,50};
			String[] specialHandling12 = {"ON", "OFF"};
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = Computer.class;
			int[] startTime13 = {360,390};
			int[] durationTime13 = {40,50};
			String[] specialHandling13 = {"ON","OFF"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
			
			/* Line 14 */
			Class<?> class14 = AudioHifi.class;
			int[] startTime14 = {390,400};
			int[] durationTime14 = {80,100};
			String[] specialHandling14 = {"ON","OFF"};
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
				
			/* Line 15 */
			Class<?> class15 = Computer.class;
			int[] startTime15 = {429,450};
			int[] durationTime15 = {40,60};
			String[] specialHandling15 = {"ON","OFF"};
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
			/* Line 16  */
			Class<?> class16 = Tv.class;
			int[] startTime16 = {440,480};
			int[] durationTime16 = {180,200};
			String[] specialHandling16 = {"ON","STANDBY"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
							
			/* Line 17 */
			Class<?> class17 = Lighting.class;
			int[] startTime17 = {860, 930};
			int[] durationTime17 = {-1,-1};
			double[] specialHandling17 = {0.2, 0.3, 0, 0};
			RecipeLine line17 = new RecipeLine(class17, startTime17, durationTime17 , specialHandling17);
			
			/* Line 18  */
			Class<?> class18 = Tv.class;
			int[] startTime18 = {885,930};
			int[] durationTime18 = {110,120};
			String[] specialHandling18 = {"ON","STANDBY"};
			RecipeLine  line18 = new RecipeLine(class18, startTime18, durationTime18 , specialHandling18);
			
			/* Line 19 */
			Class<?> class19 = LightingOffRecipe.class;
			int[] startTime19 = {990, 1020};
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
//			recipe.add(line8);
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
			recipe.add(line19);
						
			synchronization = false;
			
			return;
		}
		
		if (recipeNumber == 2){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {90,120};
			int[] durationTime1 = {120,140};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = Microwave.class;
			int[] startTime2 = {150,180};
			int[] durationTime2 = {2,3};
			String [] specialHandling2 = {"ON900","STANDBY"};
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = ElectricalTool.class;
			int[] startTime3 = {140,150};
			int[] durationTime3 = {3,5};
			String specialHandling3 = "hairDryer";
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = ElectricalTool.class;
			int[] startTime4 = {150,180};
			int[] durationTime4 = {2,3};
			String specialHandling4 = "waterBoiler";
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);

			/* Line 5 */
			Class<?> class5 = AudioHifi.class;
			int[] startTime5 = {150,180};
			int[] durationTime5 = {50,60};
			String[] specialHandling5 = {"ON","STANDBY"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = Lighting.class;
			int[] startTime6 = {420, 450};
			int[] durationTime6 = {-1,-1};
			double[] specialHandling6 = {0.2, 0.35, 0, 0};
			RecipeLine line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
			
			/* Line 7 */
			Class<?> class7 = AudioHifi.class;
			int[] startTime7 = {420,540};
			int[] durationTime7 = {50,60};
			String[] specialHandling7 = {"ON","STANDBY"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = ElectricalTool.class;
			int[] startTime8 = {480,720};
			int[] durationTime8 = {15,30};
			String specialHandling8 = "vacuum";
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
						
			/* Line 9 */
			Class<?> class9 = CookingStove.class;
			int[] startTime9 = {720,780};
			int[] durationTime9 = {25,30};
			String[] specialHandling9 = {"ON", "OFF"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
		
			/* Line 10 */
			Class<?> class10 = CookingStove.class;
			int[] startTime10 = {720,780};
			int[] durationTime10 = {25,30};
			String[] specialHandling10 = {"ON", "OFF"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
			
			/* Line 11 */
			Class<?> class11 = AudioHifi.class;
			int[] startTime11 = {765,780};
			int[] durationTime11 = {25,30};
			String[] specialHandling11 = {"ON","STANDBY"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12 */
			Class<?> class12 = Tv.class;
			int[] startTime12 = {810,900};
			int[] durationTime12 = {150,180};
			String[] specialHandling12 = {"ON","STANDBY"};
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = LightingOffRecipe.class;
			int[] startTime13 = {1020, 1050};
			int[] durationTime13 = {-1,-1};
			int specialHandling13 = 0;
			RecipeLine line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
			
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
			recipe.add(line11);
			recipe.add(line12);
			recipe.add(line13);
			
			synchronization = false;
			
			return;
		}
				
		if (recipeNumber == 3){
			/* Line 1 */
			Class<?> class1 = Lighting.class;
			int[] startTime1 = {90,120};
			int[] durationTime1 = {-1,-1};
			double[] specialHandling1 = {0.1, 0.1, 0, 0};
			RecipeLine  line1 = new RecipeLine(class1, startTime1, durationTime1 , specialHandling1);
			
			/* Line 2 */
			Class<?> class2 = ElectricalTool.class;
			int[] startTime2 = {130,150};
			int[] durationTime2 = {3,3};
			String specialHandling2 = "waterBoiler";
			RecipeLine  line2 = new RecipeLine(class2, startTime2, durationTime2 , specialHandling2);

			/* Line 3 */
			Class<?> class3 = Microwave.class;
			int[] startTime3 = {130,150};
			int[] durationTime3 = {3,5};
			String[] specialHandling3 = {"ON900","STANDBY"};
			RecipeLine  line3 = new RecipeLine(class3, startTime3, durationTime3 , specialHandling3);
			
			/* Line 4 */
			Class<?> class4 = AudioHifi.class;
			int[] startTime4 = {180,240};
			int[] durationTime4 = {20,25};
			String[] specialHandling4 = {"ON","STANDBY"};
			RecipeLine  line4 = new RecipeLine(class4, startTime4, durationTime4 , specialHandling4);
			
			/* Line 5 */
			Class<?> class5 = Computer.class;
			int[] startTime5 = {120,240};
			int[] durationTime5 = {10,15};
			String[] specialHandling5 = {"ON","OFF"};
			RecipeLine  line5 = new RecipeLine(class5, startTime5, durationTime5 , specialHandling5);
			
			/* Line 6 */
			Class<?> class6 = CookingStove.class;
			int[] startTime6 = {340,370};
			int[] durationTime6 = {15,15};
			String[] specialHandling6 = {"ON", "OFF"};
			RecipeLine  line6 = new RecipeLine(class6, startTime6, durationTime6 , specialHandling6);
						
			/* Line 7 */
			Class<?> class7 = Microwave.class;
			int[] startTime7 = {340,370};
			int[] durationTime7 = {5,5};
			String[] specialHandling7 = {"ON900","STANDBY"};
			RecipeLine  line7 = new RecipeLine(class7, startTime7, durationTime7 , specialHandling7);
			
			/* Line 8 */
			Class<?> class8 = WashingMachine.class;
			int[] startTime8 = {480,720};
			int[] durationTime8 = {-1,-1};
			String specialHandling8 = "ON60";
			RecipeLine  line8 = new RecipeLine(class8, startTime8, durationTime8 , specialHandling8);
		
			/* Line 9 */
			Class<?> class9 = AudioHifi.class;
			int[] startTime9 = {340,720};
			int[] durationTime9 = {200,200};
			String[] specialHandling9 = {"ON","STANDBY"};
			RecipeLine  line9 = new RecipeLine(class9, startTime9, durationTime9 , specialHandling9);
			
			/* Line 10 */
			Class<?> class10 = Computer.class;
			int[] startTime10 = {480,720};
			int[] durationTime10 = {30,30};
			String[] specialHandling10 = {"ON","OFF"};
			RecipeLine  line10 = new RecipeLine(class10, startTime10, durationTime10 , specialHandling10);
					
			/* Line 11 */
			Class<?> class11 = Computer.class;
			int[] startTime11 = {480,720};
			int[] durationTime11 = {10,15};
			String[] specialHandling11 = {"ON","OFF"};
			RecipeLine  line11 = new RecipeLine(class11, startTime11, durationTime11 , specialHandling11);
			
			/* Line 12  */
			Class<?> class12 = ElectricalTool.class;
			int[] startTime12 = {480,720};
			int[] durationTime12 = {14,21};
			String specialHandling12 = "iron";
			RecipeLine  line12 = new RecipeLine(class12, startTime12, durationTime12 , specialHandling12);
			
			/* Line 13 */
			Class<?> class13 = CookingStove.class;
			int[] startTime13 = {720,780};
			int[] durationTime13 = {30,35};
			String[] specialHandling13 = {"ON", "OFF"};
			RecipeLine  line13 = new RecipeLine(class13, startTime13, durationTime13 , specialHandling13);
			
			/* Line 14 */
			Class<?> class14 = CookingStove.class;
			int[] startTime14 = {720,780};
			int[] durationTime14 = {30,35};
			String[] specialHandling14 = {"ON", "OFF"};
			RecipeLine  line14 = new RecipeLine(class14, startTime14, durationTime14 , specialHandling14);
		
			/* Line 15 */
			Class<?> class15 = AudioHifi.class;
			int[] startTime15 = {750,780};
			int[] durationTime15 = {30,35};
			String[] specialHandling15 = {"ON","STANDBY"};
			RecipeLine  line15 = new RecipeLine(class15, startTime15, durationTime15 , specialHandling15);
			
			/* Line 16  */
			Class<?> class16 = Tv.class;
			int[] startTime16 = {810,960};
			int[] durationTime16 = {60,60};
			String[] specialHandling16 = {"ON","STANDBY"};
			RecipeLine  line16 = new RecipeLine(class16, startTime16, durationTime16 , specialHandling16);
						
						
		    /* Line 17 */
			Class<?> class17 = LightingOffRecipe.class;
			int[] startTime17 = {1020, 1080};
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
			recipe.add(line10);
			recipe.add(line11);
//			recipe.add(line12);
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
