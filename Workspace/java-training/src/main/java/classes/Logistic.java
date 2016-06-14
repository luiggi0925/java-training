package classes;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Logistic extends Employee {
	
	private HashMap<Case, Integer> inventory;
	//faltaria Keep track of how many cases get from each provider
	
	public HashMap<Case, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Case, Integer> inventory) {
		this.inventory = inventory;
	}
	
	public void addCaseToInventory(Case aCase, int quantity){
		this.inventory.put(aCase, this.inventory.get(aCase)+quantity);
	}
	
	public void removeCaseFromInventory(Case aCase, int quantity){
		this.inventory.put(aCase, this.inventory.get(aCase)-quantity);
	}
	
	public void receiveCaseFromProvider(Order madeOrder){
		this.addCaseToInventory(madeOrder.getMyCase(),madeOrder.getQuantity());
	}
	
	public void makeRequestToProvider(Case aCase, Provider provider, int quantity){
		provider.addOrder(new ProviderOrder(aCase, quantity, new Date(), provider));
	}
	
}
