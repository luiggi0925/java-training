package classes;

import java.util.Date;

public class Case {
	
	private CaseDesign design;
	private CaseDevice device;
	private double price;
	
	public Case(CaseDesign design, CaseDevice device, Double price) {
		super();
		this.design = design;
		this.device = device;
		this.price=price;
	}
	
	@Override
	public String toString(){
		return String.format("Design: %s, Device: %s", 
				this.getDesign().getName(), this.getDevice().getDeviceName());
	}
	
	public CaseDesign getDesign() {
		return design;
	}
	public void setDesign(CaseDesign design) {
		this.design = design;
	}
	public CaseDevice getDevice() {
		return device;
	}
	public void setDevice(CaseDevice device) {
		this.device = device;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
