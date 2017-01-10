package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product {
	@Column(name = "PRODUCT_ID")
	@Id
	private String product_id;
	private String name;
	private String price;
	private String quantity;
	@Column(name = "CATEGORY_ID")
	private String category_id;
	@Column(name = "SUPPLIER_ID")
	private String supplier_id;

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
@Transient
	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
@Transient
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false, insertable = false)
	private Category category;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

}
