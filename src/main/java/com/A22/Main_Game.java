package com.A22;
import com.A22.VictoryDrive;
import swiftbot.*;
import com.A22.RandomColour;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_Game {
	public static int round = 1;
	public static int score = 0;
	public static ArrayList<String> coloursGenerated = new ArrayList<String>();
  public static void main(String[] args) {
	VictoryDrive.main();
	
  }
  
  public static void listSequence() {
	  String newColour = RandomColour.randomColour();
	  coloursGenerated.add(newColour);
  }
  
  public static void progressRound() {
	  round ++;
	  score ++;
  }

  public static boolean roundCheck() {
	  if (round % 5 == 0) {
		  return true;
	  }
	  return false;
  }

  public static boolean quitCheck() {
	  Scanner uInput = new Scanner(System.in);
	  String answer = "";
	  System.out.println("Your score is " + score);
	 
	  while (answer != "y" && answer != "n") {
		  System.out.println("Quit game? (y/n)");
		  try {
			  answer = uInput.nextLine().toLowerCase();
		  }
		  catch (Exception e) {
			  answer = "";
		  }
	  }
	  
	  switch (answer) {
	  case "y":
		  return true;
	  default:
		  return false;
	  }
  }
  
  
  
}
