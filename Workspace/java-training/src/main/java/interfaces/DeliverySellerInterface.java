package interfaces;

import classes.CaseSeller;
import classes.DeliverySeller;
import classes.Order;
import classes.Sale;

public interface DeliverySellerInterface {
	
	default void deliver(){}
	default void registerSales(DeliverySeller me){
		for(Sale sale: me.getSales()){
			//register sale
		}
	}
	
}
