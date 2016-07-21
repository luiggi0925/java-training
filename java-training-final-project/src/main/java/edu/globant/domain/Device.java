package edu.globant.domain;

import org.apache.commons.lang3.Validate;

public class Device extends BaseEntity{
	public enum TYPE {CELL, TABLET};
	
	public Device(TYPE type){
		Validate.isTrue(type.equals(TYPE.CELL) || type.equals(TYPE.TABLET));
	}
}