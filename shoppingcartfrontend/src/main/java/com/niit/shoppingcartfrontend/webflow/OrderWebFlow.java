package com.niit.shoppingcartfrontend.webflow;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.PaymentMethod;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.User;




public class OrderWebFlow implements Serializable{
	
	
	private static final long serialVersionUID = 1L;



	private static Logger log = LoggerFactory.getLogger(OrderWebFlow.class);
	

	
	@Autowired
	private OrdersDAO OrdersDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Orders Orders;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	
	@Autowired
	User user;
	
	public Orders initFlow(){
	
	log.debug("WEBFLOW->-> starting of the method initFlow");
	
	Orders = new Orders();
	
	log.debug("Webflow->-> ending of the method initFlow");
	
	return Orders;
	
	}
	
	public String addShippingAddress(Orders Orders, ShippingAddress shippingAddress){
		log.debug("WEBFLOW->-> starting of the method addShippingAddress");
		
		//Orders.set hippingAddress(shippingAddress);
		Orders.setShippingAddress(shippingAddress);
		
		log.debug("Webflow->-> ending of the method addShippingAddress");
		
		return "success";
		
	}
	
	public String addBillingAddress(Orders Orders, BillingAddress billingAddress){
		log.debug("WEBFLOW->-> starting of the method addBillingAddress");
		
		Orders.setBillingAddress(billingAddress);
		
		log.debug("Webflow->-> ending of the method addBillingAddress");
		
		return "success";
		
	}
	
	public String addPaymentMethod(Orders Orders, PaymentMethod paymentMethod){
		log.debug("WEBFLOW->-> starting of the method addPaymentMethod");
		
		
		Orders.setPaymentMethod(paymentMethod.getPaymentMethod());
		
		
		
		log.debug("Webflow->-> ending of the method addPaymentMethod");
		
		return "success";
			
	}
	
	public String confirmOrder(Orders Orders)
	{
		log.debug("WEBFLOW->-> starting of the method confirmOrder");
		
		Orders.setUserID(user.getEmail());
		Orders.setTotalAmount(product.getPrice());
		OrdersDAO.update(Orders);
		
		log.debug("Webflow->-> ending of the method confirmOrder");
		
		return "finalIndex";
	}
}
