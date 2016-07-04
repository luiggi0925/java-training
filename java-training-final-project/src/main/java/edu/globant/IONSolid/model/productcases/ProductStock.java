package edu.globant.IONSolid.model.productcases;

public class ProductStock {

	private Integer currentProductStock;
	
	public ProductStock(Integer stock) {
		this.currentProductStock = stock;
	}

	public Integer getCurrentProductStock() {
		return currentProductStock;
	}
	
	public void increaseStock(Integer stock) {
		this.currentProductStock =  this.currentProductStock + stock;
	}
	
	public void decreaseStock(Integer stock) {
		this.currentProductStock =  this.currentProductStock - stock;
	}
}
