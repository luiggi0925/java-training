package edu.globant.day1.ddd.excercises.IONSolid.services.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.globant.day2.exceptions.exercises.Sale;
import edu.globant.day2.exceptions.exercises.exception.SaleServiceException;

public class SaleManager {

	public SaleManager(/* WarehouseService warehouseService */) {
		// this.warehouseService = warehouseService;
	}

	public void registerASaleDraft(Sale sale) throws SaleServiceException {
		try {
			throw AlreadYExistRegisterException("The registry alread exists")
		} catch (AlreadyExistRegisterException e) {
			// If the sale is registered
			throw new SaleServiceException(
					"Service Sales exception: sale with id:" + sale.getIdSale() + " already exists ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public Sale getASale(Long saleId) throws SaleServiceException {
		try {
			return this.saleRegistry.getRegister(saleId);
		} catch (NotFoundRegisterException e) {
			throw new SaleServiceException("Service Sales exception: sale with id:" + saleId + " was not found ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public void registerAPayment(Sale sale) throws SaleServiceException {
		try {
			// If the sale has not already been payed
			if (!sale.getSaleState().equals(SaleState.PAID)) {
				// Check for inventory
				// Decrease Inventory
				sale.setNewSaleState(SaleState.PAID);
				this.saleRegistry.updateRegister(sale.getIdSale(), sale);
			}
		} catch (NotFoundRegisterException e) {
			throw new SaleServiceException(
					"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public void cancelASale(Sale sale) throws SaleServiceException {
		// If the sale is a a draft
		if (sale.getSaleState().equals(SaleState.DRAFT)) {
			try {
				// Cancel the sale
				sale.setNewSaleState(SaleState.CANCELLED);
				// update the registry sale
				this.saleRegistry.updateRegister(sale.getIdSale(), sale);
			} catch (NotFoundRegisterException e) {
				throw new SaleServiceException(
						"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
			} catch (Exception e) {
				throw new SaleServiceException("Service Sales throw an exception ", e);
			}
		}
	}

	public void refundASale(Sale sale) throws SaleServiceException {
		try {

		} catch (NotFoundRegisterException e) {
			throw new SaleServiceException(
					"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}
}
