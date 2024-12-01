package com.A22;
import  swiftbot.*;
import java.util.ArrayList;

public class FlashingLights {
  static SwiftBotAPI swiftBot;
  
  public static void flashingLights(ArrayList<String> colours) throws InterruptedException {
	  int[] red = new int[] { 255, 0, 0 };
	  int[] blue = new int[] { 0, 0, 255 };
	  int[] green = new int[] { 0, 255, 0 };
	  int[] yellow = new int[] { 255, 255, 0 };
	  int coloursLength = colours.size();
	  int flashDuration = 700;
	  
	  try {
		  
		  swiftBot = Main_Game.swiftbot;
		} catch (Exception e) {
	
			System.out.println("\nI2C disabled!");
			System.out.println("Run the following command:");
			System.out.println("sudo raspi-config nonint do_i2c 0\n");
			System.exit(5);
		}
	  
	  try { 
		  
		  Underlight[] underlights  = new Underlight[] {Underlight.MIDDLE_LEFT, Underlight.BACK_LEFT, Underlight.MIDDLE_RIGHT, Underlight.BACK_RIGHT};
		  
		  /* randomly select an underlight and flashing a certain color
		   * in the order given in the 'colours' array
		   * */
		   for (int i = 0; i < coloursLength; i++) {
			  
			  /* int randomUnderlight = (int) (Math.random() * 3);
			  
			  switch (randomUnderlight) {
				  
			  case 0:
				  underlights[i] = Underlight.BACK_LEFT; 
				  break;
			  case 1:
				  underlights[i] = Underlight.BACK_RIGHT; 
				  break;
			  case 2:
				  underlights[i] = Underlight.MIDDLE_RIGHT; 
				  break;
			  case 3:
				  underlights[i] = Underlight.MIDDLE_RIGHT; 
				  break;
			  } */
			  
              if (colours.get(i).equalsIgnoreCase("red")) {
				  
				  swiftBot.setUnderlight(underlights[0], red);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  } else if(colours.get(i).equalsIgnoreCase("blue")) {
				  
				  swiftBot.setUnderlight(underlights[1], blue);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  } else if(colours.get(i).equalsIgnoreCase("green")) {
	
				  swiftBot.setUnderlight(underlights[2], green);
				  Thread.sleep(flashDuration);	
				  swiftBot.disableUnderlights();
			  } else if(colours.get(i).equalsIgnoreCase("yellow")) {
				  
				  swiftBot.setUnderlight(underlights[3], yellow);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  }
		  }
	  
	  } catch (Exception e) {
		  
		  e.printStackTrace();
		  System.out.println("ERROR: Unable to set under light");
		  System.exit(5);
	  }
	  
	  System.out.println("Sequence finished");
	  Thread.sleep(500);
	  swiftBot.disableUnderlights();
	  
  }
}
