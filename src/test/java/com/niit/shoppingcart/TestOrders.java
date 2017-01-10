package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Orders;



public class TestOrders {
   
	 @Autowired
	    static AnnotationConfigApplicationContext context;
	    
	    @Autowired
	    static Orders orders;
	    
	    @Autowired
	    static OrdersDAO ordersDAO;
	    
	    @BeforeClass
	    public static void init()
	  
	    {
	        context = new AnnotationConfigApplicationContext();
	        context.scan("com.niit.shoppingcart");
	        context.refresh();
	        
	        ordersDAO= (OrdersDAO) context.getBean("ordersDAO");
	        orders=(Orders) context.getBean("orders");
	        System.out.println("BEAN CREATED");
	    }
	    
	    //Starting of JUnit Test Cases
	  
	    
	  @Test
	    public void createOrdersTestCase()
	   
	    {
	        
	        orders.setOrder_id("Mob_24");
	        orders.setPayment_method("abc");
	        orders.setBilling_address_id("123");
	        orders.setCart_id("Mob_25");
	       
	        
	        Boolean status=ordersDAO.save(orders);
	        Assert.assertEquals("Create Orders Test Case",true,status);
	    }

	    
	 //   @Test
	  public void deleteUserTestCase()

	  {
	      orders.setOrder_id("Mob_24");
	      Boolean status=ordersDAO.delete(orders);
	      Assert.assertEquals("Delete Orders Test Case",true,status);
	    }
	  

	 @Test
	  public void updateOrdersTestCase(){
		    orders.setOrder_id("Mob_24");
	        orders.setPayment_method("abc");
	        orders.setBilling_address_id("123 updated");
	        orders.setCart_id("Mob_25");
	     
	        
	      Boolean status=ordersDAO.update(orders);
	      Assert.assertEquals("update Orders Test Case",true,status);
	  }
	  
	  
	 //@Test
	  public void getOrdersTestCase()
	 
	  {
	      Assert.assertEquals("Get User Test Case",null,ordersDAO.get("Mob_02"));  
	  }

	  // @Test
	  public void getAllOrdersTestCase()
	  {
	      Assert.assertEquals("Get Orders Test Case",3,ordersDAO.list().size());
	  }

}
