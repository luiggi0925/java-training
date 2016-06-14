package classes;

import enums.SaleStatus;

public class Sale {
	private Receipt receipt;
	private StoreOrder order;
	private SaleStatus status;
	
	public Sale(StoreOrder order) {
		super();
		this.order=order;
		this.status = SaleStatus.DRAFT;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public StoreOrder getOrder() {
		return order;
	}

	public void setOrder(StoreOrder order) {
		this.order = order;
	}
	
	
	
}
