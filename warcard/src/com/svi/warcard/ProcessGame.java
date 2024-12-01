package com.svi.warcard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class ProcessGame {

	private enum Suits {
		D(4), H(3), S(2), C(1);

		private int suitsseq;

		Suits(int s) {
			suitsseq = s;
		}

		public int getSuitsseq() {
			return suitsseq;
		}
	}

	private enum Ranks {
		ace(13), king(12), queen(11), jack(10), ten(9), nine(8), eight(7), seven(6), six(5), five(4), four(3), three(2),
		two(1);

		private int ranksseq;

		Ranks(int r) {
			ranksseq = r;
		}

		public int getRanksseq() {
			return ranksseq;
		}
	}

	int rowIndex = 0;
	int mstrplyr = 0;
	String mstrcrntcard = "";
	int mstrcrdsize = 0;
	String mstrremcrds;

	int suitSeq = 0;
	int rankSeq = 0;
	
	int ctrround = 1;
	int ctrelements = 0;
//	int cntactiveplyr = 0;	
	int numColumns = 0;
	
	// create an RoundInfo Arraylist for processed column that will store isuitnrank, cardseq, and iplyr
	// arraylist for RoundInfo isuitnrank,irankseq, isuitseq,and iplyr
	ArrayList<RoundInfo> cardList = new ArrayList<>(); 

	// arraylist for MsterInfo mstrplyr,mstrcrntcard, mstrcrdsize,and mstrremcrds
	ArrayList<MsterInfo> masterArray = new ArrayList<>();

	// LinkedHashSet for storing sorted cards
//	LinkedHashSet<String> colcardHolder = new LinkedHashSet<>();
	LinkedHashSet<String> roundcardHolder = new LinkedHashSet<>();

	
	public void processGame(ArrayList<ArrayList<String>> cardsByPlayer) {		
		
		masterArray.clear();
		rowIndex = 0;
		ctrelements = 0;
		numColumns = 0;
		
		for (ArrayList<String> rowList : cardsByPlayer) {// rowList refers to element of given column. iterates over
			
			if (rowList.size() > 0) {
//				int cntactiveplyr = rowList.size();
				String data = rowList.get(0); // get 0th element or cardsByPlayer in iteration
				int rowCount = cardsByPlayer.get(rowIndex).size(); // Count of elements in the given row
//				System.out.println("rowIndex: " +rowIndex +" rowCount: " +rowCount );

				if (rowCount > 0) {
					numColumns = cardsByPlayer.get(rowIndex).size(); // gets size (number of elements) at a
																		// specific row index
					ArrayList<String> row = cardsByPlayer.get(rowIndex);

					//GET ELEMENTS FROM COL 1 ONWARDS OF ROW
					StringBuilder sb = new StringBuilder(); // get elements from col 1 onwards of the given
																// row
					for (int i = 1; i < row.size(); i++) {
						sb.append(row.get(i));
						sb.append(", ");
						ctrelements++;
					}
					String rowData = sb.toString().trim();

					ctrelements = numColumns - 1;
					
					//POPULATE MSTR ARRAYLIST
					mstrplyr = rowIndex + 1;
					mstrcrntcard = data;
					mstrcrdsize = ctrelements;
					mstrremcrds = rowData;
					masterArray.add(new MsterInfo(mstrplyr, mstrcrntcard, mstrcrdsize, mstrremcrds));
	
					int iplyr = rowIndex + 1;
					// System.out.println(iplyr); // Output: player number
					
					ConvertSuitAndRank convertData = new ConvertSuitAndRank();
					convertData.convertSuitAndRank(data);
					suitSeq = convertData.getSuitSeq();
					rankSeq = convertData.getRankSeq();

					// populate array list of cardList
					cardList.add(new RoundInfo(data, suitSeq, rankSeq, iplyr, ctrelements));

					// Sort the cardList ArrayList based on suitseq and rankseq
					Collections.sort(cardList, new Comparator<RoundInfo>() {
					@Override
						public int compare(RoundInfo card1, RoundInfo card2) {
							if (card1.getRankSeq() != card2.getRankSeq()) {
								return Integer.compare(card2.getRankSeq(), card1.getRankSeq());
							} else {
								return Integer.compare(card2.getSuitSeq(), card1.getSuitSeq());
								}
							}
						}
					);
//					colcardHolder.add(data);
//					cardList.add(new RoundInfo(data, suitSeq, rankSeq, iplyr, ctrelements));

				} 
				ctrelements = 0;
				rowIndex++;
			} 
			else 
				rowIndex++;
		}
	}
	
//	public ArrayList<RoundInfo> getDataByRound() {
//		return cardList;
//	}
	
	public ArrayList<RoundInfo> getDataByRound() {
		return cardList;
	}
	
	public ArrayList<MsterInfo> getMasterArrayData() {
		return masterArray;
	}
}
