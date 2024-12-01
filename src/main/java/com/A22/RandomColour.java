package com.A22;

public class RandomColour {
  
  public static String randomColour() {
	  
	  String color = "";
	  
	  // creating random number from 0 - 3
	  int randomNum = (int) (Math.random() * 3);
	  
	  // translating random value to a color
	  switch (randomNum) {
	    case 0:
	      color = "Red";
	      break;
	    case 1:
	      color = "Blue";
		  break;
	    case 2:
	      color = "Green";
		  break;
	    case 3:
		  color = "Yellow";
          break;
	  }
	  
	  return color;

  }

}
