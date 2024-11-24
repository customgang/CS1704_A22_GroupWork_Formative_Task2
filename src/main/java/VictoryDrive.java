import swiftbot.*;
import java.util.Random;
import java.util.ArrayList;

public class VictoryDrive {
	final double botSpeedValue = 0.27;
	int botSpeed;
	static SwiftBotAPI swiftbot;
	public static void main(String[]args) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			swiftbot.setUnderlight(bottomLights[x], green);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			swiftbot.setUnderlight(bottomLights[x], green);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}