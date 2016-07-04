package edu.globant.day1.designpatterns.IONSolid.services;

import edu.globant.day1.designpatterns.IONSolid.model.employee.SaleEmployee;
import edu.globant.day1.designpatterns.IONSolid.model.receipt.Receipt;
import edu.globant.day1.designpatterns.IONSolid.services.managers.SaleManager;
import edu.globant.day1.designpatterns.IONSolid.services.managers.WarehouseManager;

/*Singleton y patron Facade*/
public class ApplicationFacade {

	private SaleManager saleManager;
	private WarehouseManager warehouseManager;
	private static ApplicationFacade instance = null;
	
	private ApplicationFacade() {
		warehouseManager = new WarehouseManager();
		saleManager = new SaleManager(warehouseManager);
	}
	
	public static ApplicationFacade getInstance() {
		if(instance == null) {
			return new ApplicationFacade();
		}
		return instance;
	}
	
	public void registerASale(SaleEmployee emp, Receipt receipt) {
		saleManager.registerASale(emp, receipt);
	}
	
}