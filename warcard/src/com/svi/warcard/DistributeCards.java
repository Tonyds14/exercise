package com.svi.warcard;

public class DistributeCards {
	private String[][] plyrcrds;
	
	public void distributeCards(int numPlyrs, String[] shuffledCards) {
		int nummaxcrd = (short) (52 / numPlyrs); // ***get num of cards per player
		int remcrdcnt = 52 - (nummaxcrd * numPlyrs);

		int xtracol = 0;
		if (remcrdcnt > 0) {
			xtracol = 1;
		}
		plyrcrds = new String[numPlyrs][nummaxcrd + xtracol]; // 26 max card for 2 players
		int ctrcard = 0; // ***distribute initial shfldcards per player. Players Card by Round
		int crdidx = 0;
		int ctrplyr = 0;
		for (ctrcard = 0; ctrcard < nummaxcrd; ctrcard++) {
			for (ctrplyr = 0; ctrplyr < numPlyrs; ctrplyr++) {
				plyrcrds[ctrplyr][ctrcard] = shuffledCards[crdidx];
				crdidx++;
			}
		}
		if (xtracol == 1) {
			for (ctrplyr = 0; ctrplyr < remcrdcnt; ctrplyr++) {
				plyrcrds[ctrplyr][nummaxcrd] = shuffledCards[crdidx];
				crdidx++;
			}
		}
	}
	
	public String[][] getDistributedCards() {
		return plyrcrds;
	}
}
