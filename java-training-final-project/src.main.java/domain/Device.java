package domain;

import org.apache.commons.lang3.Validate;

import persistence.DAO.DTO;

public class Device implements DTO{
	public enum TYPE {CELL, TABLET};
	
	public Device(TYPE type){
		Validate.isTrue(type.equals(TYPE.CELL) || type.equals(TYPE.TABLET));
	}
}
