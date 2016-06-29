package edu.globant.finalProject.model.Employee;

import java.util.ArrayList;

import edu.globant.finalProject.model.Sale.Sale;


public class Seller extends Employee{
	
	public Seller(String name) {
		super(name);
	}

	private ArrayList<Sale> sales;
	
	public ArrayList<Sale> getSales() {
		return sales;
	}
	
	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
}
