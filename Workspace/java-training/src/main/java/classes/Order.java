package classes;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class Order {
	private Case myCase;
	private int quantity;
	private Date dateOfRequest, dateOfDelivery;
	
	public Order(){
		
	}
	
	public Order(Case myCase, int quantity, Date dateOfRequest) {
		super();
		this.myCase = myCase;
		this.quantity = quantity;
		this.dateOfRequest=dateOfRequest;
	}
	
	public int delay(){
		if(dateOfDelivery==null) return -1;
		int difference = DateMethods.differenceBetweenDates(dateOfRequest, dateOfDelivery);
		if(difference>30) return difference-30;
		return 0;
	}
	
	public boolean deliveredOnTime(){
		if(dateOfDelivery==null) return false;
		return DateMethods.differenceBetweenDates(dateOfRequest, dateOfDelivery)<30; //we assume that after 30 days, the delivery is late
	}
	
	public Case getMyCase() {
		return myCase;
	}
	public void setMyCase(Case myCase) {
		this.myCase = myCase;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	
}
