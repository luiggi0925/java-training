package ilan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderAlert {
	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	@ManyToOne
	private CaseProduct product;
	
	public OrderAlert(){}
	
	public OrderAlert(int quantity, CaseProduct product) {
		super();
		this.quantity = quantity;
		this.product=product;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CaseProduct getProduct() {
		return product;
	}

	public void setProduct(CaseProduct product) {
		this.product = product;
	}
	
	
}