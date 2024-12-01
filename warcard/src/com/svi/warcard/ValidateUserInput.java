package com.svi.warcard;
import java.util.Scanner;

public class ValidateUserInput {
	private boolean flgProcess;
	private int numPlyrs;
	private int numShfls;
	
	public void validateUserInput() {
		Scanner scanner = new Scanner(System.in);
		boolean vldcntplyr = false;
		boolean vldcntshfl = false;
		boolean flgprocess = false;

		// try catch for input num of players
		try {
			while(true) {
				System.out.print("Enter the number of players: ");
				numPlyrs = scanner.nextInt();
				if (numPlyrs >= 2 && numPlyrs <= 52) {
					vldcntplyr = true;
					break;
				}					
				else
					System.out.println("Input is outside the valid range. Min number of players is 2, and max is 52");
			}
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a valid integer.");
		}
		
		// try catch for input num of shuffles
		try {
			while (true) {
				System.out.print("Enter the number of shuffles: ");
				numShfls = scanner.nextInt();
				if (numShfls >= 1 && numShfls <= 2147483647) {
					vldcntshfl = true;
					break;
				}					
				else
					System.out.println("Input is outside the valid range. Min number of shuffles is 1, and max is 2,147,483,647.");
			}
		} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid integer.");
		}
	
		if (vldcntplyr && vldcntshfl) {
			flgProcess = true;
		} else {
			flgProcess = false;
			System.out.println("Not for processing");
		}
		scanner.close();
	}
	
	public boolean getFlgProcess() {
		return flgProcess;
	}

	public int getNumShfl() {
		return numShfls;
	}

	public int getNumPlyrs() {
		return numPlyrs;
	}

}
