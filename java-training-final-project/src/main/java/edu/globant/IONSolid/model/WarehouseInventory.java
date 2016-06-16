package edu.globant.IONSolid.model;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.cases.*;

public class WarehouseInventory {

	private Map<String, Case> warehouseItems;
	private static WarehouseInventory instance; 
	
	private WarehouseInventory() {
		warehouseItems = new HashMap<String, Case>();
	}
	
	public static WarehouseInventory getInstance() {
		if(instance == null) {
			return new WarehouseInventory();
		}
		return instance;
	}
	
}
