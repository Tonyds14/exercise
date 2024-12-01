package com.svi.warcard;

class RoundInfo {
	private String isuitnrank;
    private int suitSeq;
    private int rankSeq;
    private int iplyr;
    private int ctrelements;

	public RoundInfo(String isuitnrank, int suitSeq, int rankSeq, int iplyr,int ctrelements) {
        this.isuitnrank = isuitnrank;
        this.suitSeq = suitSeq;
        this.rankSeq = rankSeq;
        this.iplyr = iplyr;
        this.ctrelements = ctrelements;
    }

    public String getIsuitnrank() {
        return isuitnrank;
    }

    public int getSuitSeq() {
        return suitSeq;
    }
    
    public int getRankSeq() {
        return rankSeq;
    }

    public int getIplyr() {
        return iplyr;
    }
    
    public int getCtrElements() {
        return ctrelements;
    }
}
