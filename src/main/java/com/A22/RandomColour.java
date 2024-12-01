package com.A22;
import java.util.*;
import com.A22.Main_Game;
import java.util.Random;

public class RandomColour {
  public static String randomColour() {
	  
	  Random rand = new Random();
	  
	  String colour = "";
	  int max = 3;
	  int min = 1;
	  int range = max - min + 1;
	  
	  // creating random number from 0 - 3
	  int randomNum = rand.nextInt(4);
	  
	  switch (randomNum) {
	    case 0:
	      colour = "Red";
	      break;
	    case 1:
	      colour = "Blue";
		  break;
	    case 2:
	      colour = "Green";
		  break;
	    case 3:
		  colour = "Yellow";
          break;
	  }
	  return colour;
	
  }
  
  public static void main(String[] args) {
	
	for (int i = 0; i < 100; i++) {
		
		System.out.println(randomColour());
	}
  }
}
