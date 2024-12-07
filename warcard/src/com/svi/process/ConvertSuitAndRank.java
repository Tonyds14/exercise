package com.svi.process;
import java.util.StringTokenizer;

public class ConvertSuitAndRank {

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

	int suitSeq = 0;
	int rankSeq = 0;
	
	public void convertSuitAndRank(String data) {
		// 6200 TOKENIZER TO SPLIT-REBUILD CARDVALUE INTO SUITS AND RANKS
		StringTokenizer tokenizer = new StringTokenizer(data, "-"); // StringTokenizer to split
		String isuit = tokenizer.nextToken();
		String irank = tokenizer.nextToken();
		// System.out.println("Suit: " + isuit); // Output: Card: card
		// System.out.println("Rank: " + irank); // Output: Rank: rank
		String isuitnrank = isuit + "-" + irank;
		// System.out.println(isuitnrank); // Output: card-rank

		// 6400 GET SUITSEQ USING ISUIT
//		System.out.println("data : " +data);
		String suitKey = isuit;
		for (Suits suit : Suits.values()) {
			if (suit.name().equals(suitKey)) {
				suitSeq = suit.getSuitsseq();
					break;
			}
		}
		// 6600 GET RANK SEQ USING IRANK
		// convert irank into variable applicable for enum
		String cnvrtdrKy = null; // Will hold the converted value
		switch (irank) {
			case "A":
				cnvrtdrKy = "ace";
				break;
			case "K":
				cnvrtdrKy = "king";
				break;
			case "Q":
				cnvrtdrKy = "queen";
				break;
			case "J":
				cnvrtdrKy = "jack";
				break;
			case "10":
				cnvrtdrKy = "ten";
				break;
			case "9":
				cnvrtdrKy = "nine";
				break;
			case "8":
				cnvrtdrKy = "eight";
				break;
			case "7":
				cnvrtdrKy = "seven";
				break;
			case "6":
				cnvrtdrKy = "six";
				break;
			case "5":
				cnvrtdrKy = "five";
				break;
			case "4":
				cnvrtdrKy = "four";
				break;
			case "3":
				cnvrtdrKy = "three";
				break;
			case "2":
				cnvrtdrKy = "two";
				break;
			}

		String rankKey = cnvrtdrKy;
		for (Ranks rank : Ranks.values()) {
			if (rank.name().equals(rankKey)) {
				rankSeq = rank.getRanksseq();
				break;
			}
		}
	}
	
	public int getSuitSeq() {
		return suitSeq;
	}

	public int getRankSeq() {
		return rankSeq;
	}

}
