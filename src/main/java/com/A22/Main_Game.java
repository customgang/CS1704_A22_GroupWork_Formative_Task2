package com.A22;
import com.A22.VictoryDrive;
import swiftbot.*;
import com.A22.RandomColour;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_Game {
	public static int round = 1;
	public static int score = 0;
	public static String buttonPressed = null;
	public static ArrayList<String> coloursGenerated = new ArrayList<String>();
	
	public static String[][] coloursToNums = {{"Red", "0"}, {"Blue", "1"}, {"Green", "2"}, {"White", "3"}};
	static SwiftBotAPI swiftbot;
	
  public static void main(String[] args) {
	swiftbot = new SwiftBotAPI();
	
	for (int x = 1; x <= round; x ++) {
		listSequence();
	}
	
	if (matchInput(coloursGenerated)) {
		if (roundCheck()) {
			if (quitCheck()) {
				score ++;
				VictoryDrive.main();
			} else {
				progressRound();
			}
		} else {
			progressRound();
		}
	}
	
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
	  
	  uInput.close();
	  
	  switch (answer) {
	  case "y":
		  return true;
	  default:
		  return false;
	  }
  }
  
  public static String getButtonInput() {
	  Button[] buttons = new Button[] {Button.A, Button.B, Button.X, Button.Y};
	  
	  swiftbot.enableButton(buttons[0], () -> {
		 buttonPressed = "Red";
	  });
	  swiftbot.enableButton(buttons[1], () -> {
		  buttonPressed = "Blue";
	  });
	  swiftbot.enableButton(buttons[2], () -> {
		  buttonPressed = "Green";
	  });
	  swiftbot.enableButton(buttons[3], () -> {
		  buttonPressed = "White";
	  });
	  
	  while (buttonPressed == null) {
		  
	  }
	  swiftbot.disableAllButtons();
	  return buttonPressed;
  }

  public static boolean matchInput(ArrayList<String> sequence) {
	  for (String x : sequence) {
		  if (getButtonInput() != x) {
			  return false;
		  }
	  }
	  return true;
  }
  
}
