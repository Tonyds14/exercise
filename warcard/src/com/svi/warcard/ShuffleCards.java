package com.svi.warcard;
import java.util.ArrayList;

public class ShuffleCards {
	private String[] leftcards = new String[26];
	private String[] rightcards = new String[26];
	private String[] shfldcards = new String[52];
	private ArrayList<String> tmpshfldcards = new ArrayList<String>(); // define tmpshfldcards array list
	
	public void shuffleCards(String[] tokensCards, int numShfls) {
		
		System.arraycopy(tokensCards, 0, shfldcards, 0, 52); // copy tokensCards content into shfldcards array

		for (int ctrshfls = 1; ctrshfls <= numShfls; ctrshfls++) {
			int leftcardidx = 0;
			int rightcardidx = 0;
			tmpshfldcards.clear();
			System.arraycopy(shfldcards, 0, leftcards, 0, 26); // Copy first 26 elements of shfldcards to leftcards
			System.arraycopy(shfldcards, 26, rightcards, 0, 26); // Copy remaining elements of shfldcards to
																	// rightcards
			// ***merge left and right data to create tmpshfldcards
			for (int ctrcard = 0; ctrcard < 52; ctrcard++) {
				if (ctrcard % 2 == 0) {
					tmpshfldcards.add(leftcards[leftcardidx]);
					leftcardidx = leftcardidx + 1;
				} else {
					tmpshfldcards.add(rightcards[rightcardidx]);
					rightcardidx = rightcardidx + 1;
				}
			}
//			System.out.println("Left Card: ");   			//print left card for validation
//			for (leftcardidx = 0; leftcardidx < 26; leftcardidx++) {
//				System.out.println(leftcards[leftcardidx]);}			
//			System.out.println("Right Card: ");   			//print right card for validation
//			for (rightcardidx = 0; rightcardidx < 26; rightcardidx++) {
//				System.out.println(rightcards[rightcardidx]);}
//			System.out.println("Temp Shuffled Cards: ");	//print tmpshfldcards  for validation
//			System.out.println(tmpshfldcards);	
			// System.out.println("\nShuffle Cards:" +ctrshfls);
			for (int ctrcard = 0; ctrcard < 52; ctrcard++) {
				shfldcards[ctrcard] = tmpshfldcards.get(ctrcard);
				// System.out.println(shfldcards[ctrcard]); //print shuffle cards for validation
			}
		}
	}
	
	public String[] getShuffledCards() {
		return shfldcards;
	}

	
}
