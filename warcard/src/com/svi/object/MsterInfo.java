package com.svi.object;

public class MsterInfo {
	private int mstrplyr;
    private String mstrcrntcard;
    private int mstrcrdsize;
    private String mstrremcrds;

	public MsterInfo (int mstrplyr, String mstrcrntcard, int mstrcrdsize, String mstrremcrds) {
        this.mstrplyr = mstrplyr;
        this.mstrcrntcard = mstrcrntcard;
        this.mstrcrdsize = mstrcrdsize;
        this.mstrremcrds = mstrremcrds;
    }

    public int getMstrPlyr() {
        return mstrplyr;
    }

    public String getMstrCrntCrd() {
        return mstrcrntcard;
    }
    
    public int getMstrCrdSize() {
        return mstrcrdsize;
    }

    public String getMstrRemCrds() {
        return mstrremcrds;
    }
    
}
