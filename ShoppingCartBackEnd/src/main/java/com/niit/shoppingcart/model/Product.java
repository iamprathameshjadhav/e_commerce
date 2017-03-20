package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "PRODUCT_ID")
	@Id
	private String product_id;
	private String name;
	private int price;
	private int quantity;
	@Column(name = "CATEGORY_ID")
	private String category_id;
	@Column(name = "SUPPLIER_ID")
	private String supplier_id;
    @Column(name = "SUBCATEGORY_ID")
    private String subcategory_id;
	public String getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(String subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	@Transient
	private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false, insertable = false)
	private Category category;
	

    @ManyToOne
	@JoinColumn(name = "subcategory_id", updatable = false, insertable = false, nullable = false)
	private SubCategory subcategory;

	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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

	

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

}
