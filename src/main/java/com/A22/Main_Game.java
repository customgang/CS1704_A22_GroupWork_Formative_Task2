package com.A22;
import com.A22.VictoryDrive;
import swiftbot.*;
import com.A22.RandomColour;
import java.util.ArrayList;
import java.util.Scanner;
import com.A22.FlashingLights;


public class Main_Game {
	public static int round = 1;
	public static int score = 0;
	public static String buttonPressed = null;
	public static ArrayList<String> coloursGenerated = new ArrayList<String>();
	static SwiftBotAPI swiftbot;
	
  public static void main(String[] args) throws InterruptedException {
	swiftbot = new SwiftBotAPI();
	
	
	while (true) {
		System.out.println("Round: " + round + "\nScore: " + score);
		listSequence();
		FlashingLights.flashingLights(coloursGenerated);
		if (matchInput(coloursGenerated)) {
			score ++;
			if (scoreCheck()) {
				if (quitCheck()) {
					System.out.println("See you again, champ!");
					VictoryDrive.main();
				} else {
					round ++;
				}
			} else {
				round ++;
			}
		} else {
			break;
		}
	}
	
	lose();
	
  }
  
  public static void listSequence() {
	  String newColour = RandomColour.randomColour();
	  coloursGenerated.add(newColour);
  }

  public static boolean scoreCheck() {
	  if (score % 5 == 0 && score != 0) {
		  return true;
	  }
	  return false;
  }

  public static boolean quitCheck() {
	  Scanner uInput = new Scanner(System.in);
	  String answer = "";
	  System.out.println("Your score is " + score);
	 
	  while (!answer.equals("y") && !answer.equals("n")) {
		  System.out.println("Quit game? (y/n)");
		  try {
			  answer = uInput.next().toLowerCase();
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
  
  public static String getButtonInput() {
	  buttonPressed = null;
	  Button[] buttons = new Button[] {Button.A, Button.B, Button.X, Button.Y};
	  
	  swiftbot.enableButton(buttons[0], () -> {
		 buttonPressed = "Red";
		 System.out.println(buttonPressed);
		 swiftbot.disableAllButtons();
	  });
	  swiftbot.enableButton(buttons[1], () -> {
		  buttonPressed = "Blue";
		  System.out.println(buttonPressed);
		  swiftbot.disableAllButtons();
	  });
	  swiftbot.enableButton(buttons[2], () -> {
		  buttonPressed = "Green";
		  System.out.println(buttonPressed);
		  swiftbot.disableAllButtons();
	  });
	  swiftbot.enableButton(buttons[3], () -> {
		  buttonPressed = "Yellow";
		  System.out.println(buttonPressed);
		  swiftbot.disableAllButtons();
	  });
	  
	  System.out.println("Awaiting button input");
	  while (buttonPressed == null) {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
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
  
  public static void lose() {
	  System.out.println("Game Over");
	  if (score >= 5) {
		  VictoryDrive.main();
	  } else {
		  System.out.println("Round: " + round + "\nScore: " + score);
		  System.out.println(coloursGenerated);
		System.exit(0);  
	  }
  }
  
}
