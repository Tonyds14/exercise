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
//		try {
//			while(true) {
//				System.out.print("Enter the number of players: ");
//				numPlyrs = scanner.nextInt();
//				if (numPlyrs >= 2 && numPlyrs <= 52) {
//					vldcntplyr = true;
//					break;
//				}					
//				else
//					System.out.println("Input is outside the valid range. Min number of players is 2, and max is 52");
//			}
//		} catch (Exception e) {
//			System.out.println("Invalid input. Please enter a valid integer.");
//		}
		
		while (true) {
		    try {
		        System.out.print("Enter the number of players: ");
		        String input = scanner.nextLine().trim(); // Read input and remove leading/trailing spaces

		        if (input.isEmpty()) {
		            System.out.println("Invalid input. Input cannot be empty. Please enter a valid integer.");
		            continue; // Prompt the user again
		        }

		        // Check if the input is an integer
		        if (input.matches("\\d+")) {
		            numPlyrs = Integer.parseInt(input); // Convert the input to an integer
		            if (numPlyrs >= 2 && numPlyrs <= 52) {
		                vldcntplyr = true;
		                break; // Exit the loop if input is valid
		            } else {
		                System.out.println("Input is outside the valid range. Min number of players is 2, and max is 52.");
		            }
		        } else if (input.matches(".*\\D.*")) { // Check for non-integer characters (e.g., "1/2")
		            System.out.println("Invalid input. Fractions, symbols, or letters are not allowed. Please enter a valid integer.");
		        } else {
		            System.out.println("Invalid input. Please enter a valid integer.");
		        }
		    } catch (Exception e) {
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		    }
		}
		
		
		// try catch for input num of shuffles
//		try {
//			while (true) {
//				System.out.print("Enter the number of shuffles: ");
//				numShfls = scanner.nextInt();
//				if (numShfls >= 1 && numShfls <= 2147483647) {
//					vldcntshfl = true;
//					break;
//				}					
//				else
//					System.out.println("Input is outside the valid range. Min number of shuffles is 1, and max is 2,147,483,647.");
//			}
//		} catch (Exception e) {
//				System.out.println("Invalid input. Please enter a valid integer.");
//		}
		
		while (true) {
		    try {
		        System.out.print("Enter the number of shuffles: ");
		        String input = scanner.nextLine().trim(); // Read the input and remove leading/trailing spaces

		        if (input.isEmpty()) {
		            System.out.println("Invalid input. Input cannot be empty or just spaces. Please enter a valid integer.");
		            continue; // Prompt the user again
		        }

		        // Check if the input is a valid integer
		        if (input.matches("\\d+")) {
		            numShfls = Integer.parseInt(input); // Convert the input to an integer
		            if (numShfls >= 1 && numShfls <= 2147483647) {
		                vldcntshfl = true;
		                break; // Exit the loop if the input is valid
		            } else {
		                System.out.println("Input is outside the valid range. Min number of shuffles is 1, and max is 2,147,483,647.");
		            }
		        } else if (input.matches(".*[^\\d].*")) { // Check for any non-digit characters (e.g., "1/2", ".25")
		            System.out.println("Invalid input. Fractions, decimals, symbols, or letters are not allowed. Please enter a valid integer.");
		        } else {
		            System.out.println("Invalid input. Please enter a valid integer.");
		        }
		    } catch (Exception e) {
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		    }
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
