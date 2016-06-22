package exercices.day6.dependency_injection;

import exercices.day6.dependency_injection.enums.SaleStatus;

public class Sale {
	private Receipt receipt;
	private Order order;
	private SaleStatus status;
	
	public Sale(Order order) {
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	
	
}
