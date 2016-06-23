package edu.globant.day1.exercises.designPatterns.model;

public class CaseStock {
	private Case theCase;
	private int stock;
	private int miniumStockBeforeAlert;
	
	public CaseStock(){
		
	}

	public Case getTheCase() {
		return theCase;
	}

	public void setTheCase(Case theCase) {
		this.theCase = theCase;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getMiniumStockBeforeAlert() {
		return miniumStockBeforeAlert;
	}

	public void setMiniumStockBeforeAlert(int miniumStockBeforeAlert) {
		this.miniumStockBeforeAlert = miniumStockBeforeAlert;
	}

	@Override
	public String toString() {
		return "CaseStock [theCase=" + theCase + ", stock=" + stock + ", miniumStockBeforeAlert="
				+ miniumStockBeforeAlert + "]";
	}

	
}