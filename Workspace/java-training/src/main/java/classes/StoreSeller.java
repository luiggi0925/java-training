package classes;

import java.util.Date;

import enums.Gender;
import interfaces.StoreSellerInterface;

public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	public static void main(String[] args){
		StoreSeller test = new StoreSeller();
		test.registerOrder(new StoreOrder());
		CaseDesign designMock = new CaseDesign("IPhone design");
		CaseDevice deviceMock = new CaseDevice("IPhone 6");
		Case caseMock = new Case(designMock, deviceMock, 100.50);
		Customer customerMock = new Customer("ilan", "LP 7 y 50", 22, Gender.M);
		StoreOrder orderMock = new StoreOrder(caseMock, 10, new Date(),customerMock);
		Sale saleMock = new Sale(orderMock);
		test.sellCase(saleMock,test.getLogistic());
	}
}
