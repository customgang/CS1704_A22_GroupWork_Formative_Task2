package com.A22;
import java.util.*;

public class RandomColour {
  
  public static String randomColour() {
	  
	  String color = "";
	  int max = 3;
	  int min = 1;
	  int range = max - min + 1;
	  
	  // creating random number from 0 - 3
	  int randomNum = (int) (Math.random() * 3);
	  
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
	  System.out.println(randomNum);
	  return color;
	
  }
  
  public static void main(String[] args) {
	
	for (int i = 0; i < 100; i++) {
		
		System.out.println(randomColour());
	}
  }
}
