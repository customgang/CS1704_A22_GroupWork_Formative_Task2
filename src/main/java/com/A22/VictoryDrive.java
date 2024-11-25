package com.A22;
import com.A22.Main_Game;

import swiftbot.*;
import java.util.Random;
import java.util.ArrayList;

public class VictoryDrive {
	final static double botSpeedValue = 0.27;
	static SwiftBotAPI swiftbot;
	public static void main() {
		swiftbot = new SwiftBotAPI();
		randomLights();
	}
	
	public static void randomLights() {
		int[] red = new int[] {255, 0, 0};
		int[] green = new int[] {0, 255, 0};
		int[] blue = new int[] {0, 0, 255};
		int[] white = new int[] {255, 255, 255};
		Random rand = new Random();
		int flashNumToAdd;
		Underlight[] bottomLights = new Underlight[] {Underlight.FRONT_LEFT, Underlight.FRONT_RIGHT, Underlight.MIDDLE_LEFT, Underlight.MIDDLE_RIGHT, Underlight.BACK_LEFT, Underlight.BACK_RIGHT };
		ArrayList<Integer> flashOrder = new ArrayList<Integer>(6);
		for (int i = 0; i < 6; i ++) {
			do {
				flashNumToAdd = rand.nextInt(6);
			}
			while (flashOrder.contains(flashNumToAdd));
			flashOrder.add(flashNumToAdd);
		}
		System.out.println(flashOrder);
		for (int x : flashOrder) {
			swiftbot.setUnderlight(bottomLights[x], red);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			swiftbot.setUnderlight(bottomLights[x], green);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			swiftbot.setUnderlight(bottomLights[x], blue);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			swiftbot.setUnderlight(bottomLights[x], white);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				
			}
			swiftbot.disableUnderlights();
		}
	}
	
	public static void drive() {
		int botSpeed;
		double newSpeedValue;
		int timeToDrive;
		if (Main_Game.score < 5) {
			botSpeed = 40;
		} else if (Main_Game.score <= 9 && Main_Game.score >= 5) {
			botSpeed = Main_Game.score * 10;
		} else {
			botSpeed = 100;
		}
		
		newSpeedValue = botSpeedValue * (botSpeed / 100);
		timeToDrive = (int) (0.3 / newSpeedValue * 1000);
		
		swiftbot.move(botSpeed, botSpeed, timeToDrive);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		swiftbot.move(-botSpeed, -botSpeed, timeToDrive);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		swiftbot.move(50, 0, 1000);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		swiftbot.move(botSpeed, botSpeed, timeToDrive);
	}
}