package com.svi.process;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.svi.object.MsterInfo;
import com.svi.object.RoundInfo;

public class BuildConsoleMssg {
	
	int mstrplyr = 0;
	String mstrcrntcard = "";
	int mstrcrdsize = 0;
	String mstrremcrds;
	
//	int ctrround = 1;
	
	boolean flgwinnerfound;
	
	// LinkedHashSet for storing sorted cards
//	LinkedHashSet<String> colcardHolder = new LinkedHashSet<>();
	LinkedHashSet<String> roundcardHolder = new LinkedHashSet<>();
	
	public void buildConsoleMssg(ArrayList<MsterInfo> masterArray, ArrayList<RoundInfo> cardList, ArrayList<ArrayList<String>> cardsByPlayer) {
		roundcardHolder.clear();
		
//		System.out.println("\nROUND: " + ctrround);
		for (MsterInfo innerList : masterArray) {
		    mstrplyr = (int) innerList.getMstrPlyr();              // Read mstrplyr (int)
		    mstrcrntcard = (String) innerList.getMstrCrntCrd();          // Read mstrcrntcard (int)
		    mstrcrdsize = (int) innerList.getMstrCrdSize();           // Read mstrcrdsize (int)
		    mstrremcrds = (String) innerList.getMstrRemCrds();     // Read mstrremcrds (String)
		
			StringBuilder consolemssg = new StringBuilder(); // Append strings to the StringBuilder
			consolemssg.append("Player " + (mstrplyr) + " reveals: " +mstrcrntcard);
			consolemssg.append(" Remaining Card Size: " +mstrcrdsize);
			consolemssg.append(" Remaining Cards: " +mstrremcrds);
			String finalmssg = consolemssg.toString();
			System.out.println(finalmssg);
			
//			ctrround++;			    
		}			
		
		// 7000-A BUILD MSSG CONSOLE FOR ROUND WINNER 
		// Retrieving values from the 0th row
		RoundInfo card = cardList.get(0);
		String winningcard = card.getIsuitnrank();
		int winningplyr = card.getIplyr();

		System.out.println("\tWinning Card is " + winningcard);
		System.out.println("\tRound Winner is " + winningplyr);

		// 7000-B UPLOAD DATA INTO ROUNDCARDHOLDER ARRAY
		for (RoundInfo card1 : cardList) {
			String isuitnrank = card1.getIsuitnrank();
			// System.out.println("isuitnrank: " + isuitnrank);
			roundcardHolder.add(isuitnrank);
		}
//		System.out.println("roundcardHolder data");
//		System.out.println(roundcardHolder);

		// roundcardHolder.addAll(colcardHolder);
//		System.out.println("colcardHolder content: "+colcardHolder);
//		colcardHolder.clear();

		// ADD ALL ELEMENTS OF CARDHOLDER INTO cardsByPlayer, ROW OF WINNER
		cardsByPlayer.get(winningplyr - 1).addAll(roundcardHolder); // should be based on count of elements

//		System.out.println("roundcardHolder content: "+roundcardHolder);
//		System.out.println("colcardHolder content: "+colcardHolder);

//		System.out.println("Round Info cardList: cardvalue, player, rankseq, suitseq");
////		// Print the elements of cardList
//		for (RoundInfo icard : cardList) {
//        	System.out.println(icard.getIsuitnrank()+ ": " +icard.getIplyr()+ ": " +icard.getRankSeq()+ ": " +icard.getSuitSeq());
//		}

		// REMOVE DATA/ELEMENTS OF COL 0/FIRST COL ON ALL ROWS OF cardsByPlayer
		for (ArrayList<String> row : cardsByPlayer) {
			if (row.size() > 0 && row.get(0) != null) {
				row.remove(0);
			}
		}

//        System.out.println("\ncardsByPlayer after remove data of 0th columns");  //Print the updated 2D ArrayList
//        for (ArrayList<String> row : cardsByPlayer) 
//        	{System.out.println(row);
//        		}	        
//        
		// 7400 WRAP-UP
		cardList.clear();

		if (cardsByPlayer.get(0).size() == 52) {
			flgwinnerfound = true;
			System.out.println("\nWinner of the Game is Player: " + winningplyr);
			System.out.println("GAME OVER");
		} else 
			flgwinnerfound = false;		
		
		}	
	
    public boolean getFlgWinnerFound() {
        return flgwinnerfound;
    }
}

