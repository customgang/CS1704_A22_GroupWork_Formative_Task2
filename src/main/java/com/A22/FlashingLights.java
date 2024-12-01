package com.A22;
import  swiftbot.*;

public class FlashingLights {
  static SwiftBotAPI swiftBot;
  
  public static void flashingLights(String[] colours) throws InterruptedException {
	  int[] red = new int[] { 255, 0, 0 };
	  int[] blue = new int[] { 0, 0, 255 };
	  int[] green = new int[] { 0, 255, 0 };
	  int[] yellow = new int[] { 255, 255, 0 };
	  int coloursLength = colours.length;
	  int flashDuration = 700;
	  
	  try {
		  
		  swiftBot = new SwiftBotAPI();
		} catch (Exception e) {
	
			System.out.println("\nI2C disabled!");
			System.out.println("Run the following command:");
			System.out.println("sudo raspi-config nonint do_i2c 0\n");
			System.exit(5);
		}
	  
	  try { 
		  
		  Underlight[] underlights  = new Underlight[coloursLength];
		  
		  /* randomly select an underlight and flashing a certain color
		   * in the order given in the 'colours' array
		   * */
		  for (int i = 0; i < coloursLength; i++) {
			  
			  int randomUnderlight = (int) (Math.random() * 3);
			  
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
			  }
			  
              if (colours[i].equalsIgnoreCase("red")) {
				  
				  swiftBot.setUnderlight(underlights[i], red);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  } else if(colours[i].equalsIgnoreCase("blue")) {
				  
				  swiftBot.setUnderlight(underlights[i], blue);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  } else if(colours[i].equalsIgnoreCase("green")) {
	
				  swiftBot.setUnderlight(underlights[i], green);
				  Thread.sleep(flashDuration);	
				  swiftBot.disableUnderlights();
			  } else if(colours[i].equalsIgnoreCase("yellow")) {
				  
				  swiftBot.setUnderlight(underlights[i], yellow);
				  Thread.sleep(flashDuration);
				  swiftBot.disableUnderlights();
			  }
		  }
	  
	  } catch (Exception e) {
		  
		  e.printStackTrace();
		  System.out.println("ERROR: Unable to set under light");
		  System.exit(5);
	  }
	  
	  System.out.println("Lights flashed successfully");
	  Thread.sleep(2000);
	  swiftBot.disableUnderlights();
	  
  }
}
