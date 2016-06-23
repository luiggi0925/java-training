package exercices.day6.dependency_injection.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CaseDevice implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public CaseDevice(){}
	
	@Override
	public String toString(){
		return String.format("Name: %s", this.getName());
	}
	
	public CaseDevice(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
