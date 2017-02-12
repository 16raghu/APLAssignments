package com.csulb.apl.assignment1;

import java.util.Scanner;

public class MicrowaveApp {
	public static boolean isdebugenabled = false;

	public static void main(String[] args) {

		Microwave micro = new Microwave();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Inputs : ");
		System.out.println("d : to open the microwave door");
		System.out.println("c : to cancel the microwave job");
		System.out.println("p : to cook or add 1 minute to cook-time");

		while (true) {

			if (isdebugenabled)
				System.out.print("Enter Inputs : ");
			String input = scanner.nextLine();
			if (isdebugenabled)
				System.out.println(input);

			// switch to coresponding input parameter to operation
			switch (input) {
			case "p":
				// check if the door is open else beep
				if (!micro.isdooropen) {
					micro.start();
				} else {
					System.out.println("Beep!");
				}
				break;
			case "d":
				micro.toggledoor();
				break;
			case "c":
				micro.stop();
				micro.isdooropen = true;
				break;

			default:
				break;
			}

		}

	}

}
