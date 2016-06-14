package classes;

import java.util.Date;

public class StoreOrder extends Order{
	private Customer owner;
	
	public StoreOrder(){
		
	}
	
	public StoreOrder(Case myCase, int quantity, Date dateOfRequest, Customer owner){
		super(myCase,quantity,dateOfRequest);
		this.owner=owner;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
}
