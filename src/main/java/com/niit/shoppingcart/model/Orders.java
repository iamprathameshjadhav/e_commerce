package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Orders {
@Id
private String order_id;
private String cart_id;
private String payment_method;
private String billing_address_id;
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getCart_id() {
	return cart_id;
}
public void setCart_id(String cart_id) {
	this.cart_id = cart_id;
}
public String getPayment_method() {
	return payment_method;
}
public void setPayment_method(String payment_method) {
	this.payment_method = payment_method;
}
public String getBilling_address_id() {
	return billing_address_id;
}
public void setBilling_address_id(String billing_address_id) {
	this.billing_address_id = billing_address_id;
}

}
