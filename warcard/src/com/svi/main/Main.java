package com.svi.main;


import java.io.*;
import java.util.*;

import com.svi.object.MsterInfo;
import com.svi.object.RoundInfo;
import com.svi.process.BuildConsoleMssg;
import com.svi.process.DistributeCards;
import com.svi.process.ProcessGame;
import com.svi.process.ReadInputTextFile;
import com.svi.process.ShuffleCards;
import com.svi.process.ValidateUserInput;

public class Main {
	
	static boolean flgwinnerfound = false;
	static boolean flgProcess = false;
	static int numShfls = 0;
	static int numPlyrs = 0;
	static int ctrround = 1;
	
	//working arraylist for processing of game cards
	static ArrayList<ArrayList<String>> cardsByPlayer = new ArrayList<>();	
	//RoundInfo object cardList Arraylist for processed column/cards that will store isuitnrank, rankseq, suitseq, iplyr, and count elements
	static ArrayList<RoundInfo> cardList = new ArrayList<>(); 
	// arraylist for MsterInfo mstrplyr,mstrcrntcard, mstrcrdsize,and mstrremcrds
	static ArrayList<MsterInfo> masterArray = new ArrayList<>();

	// LinkedHashSet for storing sorted cards
	LinkedHashSet<String> roundcardHolder = new LinkedHashSet<>();

	public static void main(String[] args) {
		ValidateUserInput validateInput = new ValidateUserInput();
		validateInput.validateUserInput();
		flgProcess = validateInput.getFlgProcess();
		numPlyrs = validateInput.getNumPlyrs();
		numShfls = validateInput.getNumShfl();
		
		ReadInputTextFile readInput = new ReadInputTextFile();
		readInput.readInputTextFile();
		String[] tokensCards = readInput.getTokensCards();
		flgProcess = readInput.getFlgProcess();
		
		// Convert tokensCards array elements to a single string
		String cardsAsString = String.join(", ", tokensCards);
		System.out.println("\nInitial Deck");
		System.out.println(cardsAsString);

		if (flgProcess) {
			
			ShuffleCards shuffle = new ShuffleCards();
			shuffle.shuffleCards(tokensCards, numShfls);
			String[] shuffledCards = shuffle.getShuffledCards();
			String shuffledCardsString = Arrays.toString(shuffledCards);
			System.out.println("\nShuffled Cards");
			System.out.println(shuffledCardsString);

			DistributeCards distribute = new DistributeCards();
			distribute.distributeCards(numPlyrs, shuffledCards);
			String[][] distributedCards = distribute.getDistributedCards();

			// Remove null elements from distributedCards
	        String[][] filterdistributedCards = removeNullElements(distributedCards);

			System.out.print("\nCards Distributed by Players\n");   // Print cardsByPlayer 2D arraylist
			int playerNum = 1;
			for (String[] rowList : filterdistributedCards) {
				System.out.print("Player " +playerNum+": ");
			  	for (String element : rowList) {
			  		System.out.print(element + ", ");
			    }
			    playerNum++;
			    System.out.println();
			}	        
						
			//move data of filterdistributedCards into cardsByPlayer
			for (String[] intRow : filterdistributedCards) {
				String[] row = new String[intRow.length];
				for (int i = 0; i < intRow.length; i++) {
					row[i] = String.valueOf(intRow[i]);
				}
				cardsByPlayer.add(new ArrayList<>(Arrays.asList(row)));
			}
						
			while (!flgwinnerfound) {
				
				System.out.println("\nROUND: " + ctrround);
				
				ProcessGame gameBegin = new ProcessGame();
				gameBegin.processGame(cardsByPlayer);				
				cardList = gameBegin.getDataByRound();
				masterArray = gameBegin.getMasterArrayData();				

				BuildConsoleMssg gameData = new BuildConsoleMssg();
				gameData.buildConsoleMssg(masterArray, cardList,cardsByPlayer);
				flgwinnerfound = gameData.getFlgWinnerFound();		
				
				ctrround++;

				}			
		} else
			System.out.print("\nNot for processing");		
	}
	
    public static String[][] removeNullElements(String[][] array) {
        return Arrays.stream(array)
                .map(row -> Arrays.stream(row)
                        .filter(Objects::nonNull)
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }
    
}