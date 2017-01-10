package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table (name="CATEGORY")
@Component
public class Category {
@Column(name="CATEGORY_ID")
@Id
private String category_id;

private String name;
private String description;
private String types;
private String gender;
@Transient
@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
private Set<Product> products;

public String getTypes() {
	return types;
}
public void setTypes(String types) {
	this.types = types;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCategory_id() {
	return category_id;
}
public void setCategory_id(String category_id) {
	this.category_id = category_id;
}
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}

