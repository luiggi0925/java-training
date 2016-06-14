package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
	private String storeName;
	private int quantity;
	private Customer customer;
	private Date dateOfSale;
	private double singlePrice;
	
	public Receipt(String storeName, int quantity, Customer customer,
			Date dateOfSale, double singlePrice) {
		super();
		this.storeName = storeName;
		this.quantity = quantity;
		this.customer = customer;
		this.dateOfSale = dateOfSale;
		this.singlePrice = singlePrice;
	}
	
	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return String.format("Receipt: Store name: %s; Quantity: %d; Customer: [%s];"
				+ "Date: %s; Single price: [%f]", this.getStoreName(), this.getQuantity(),
				this.getCustomer(), df.format(this.getDateOfSale()), this.getSinglePrice());
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	

	public double getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(double singlePrice) {
		this.singlePrice = singlePrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	
}
