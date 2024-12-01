package com.svi.warcard;

public class ValInParm {
	public boolean flgProcess;
	public int numPlyrs;
	public int numShfls;
	
	public ValInParm(boolean flgProcess, int numPlyrs, int numShfls) {
		this.flgProcess = flgProcess;
		this.numPlyrs = numPlyrs;
		this.numShfls = numShfls;
	}
	
	public boolean getFlgProcess() {
		return flgProcess;
	}
	public int getnumPlyrs() {
		return numPlyrs;
	}
	public int getNumShfl() {
		return numShfls;
	}	
}
