package edu.globant.IONSolid.services.managers;

import edu.globant.IONSolid.model.employee.SaleEmployee;
import edu.globant.IONSolid.model.receipt.Receipt;

public class SaleManager {

	private WarehouseManager warehouse;
	
	public SaleManager(WarehouseManager warehouse) {
		this.warehouse = warehouse;
	}
	
	public void registerASale(SaleEmployee emp, Receipt receipt) {
		emp.sell(receipt);
	}
}
