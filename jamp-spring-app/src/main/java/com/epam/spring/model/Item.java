package com.epam.spring.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.epam.spring.enums.Size;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Articul atricul;
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Size.class)
	private List<Size> roles;
	private Long amount;
	private String barcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Size> getRoles() {
		return roles;
	}

	public void setRoles(List<Size> roles) {
		this.roles = roles;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Articul getAtricul() {
		return atricul;
	}

	public void setAtricul(Articul atricul) {
		this.atricul = atricul;
	}

}
