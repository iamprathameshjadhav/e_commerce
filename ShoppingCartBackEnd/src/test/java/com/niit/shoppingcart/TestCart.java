package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;



public class TestCart {

	 @Autowired
	    static AnnotationConfigApplicationContext context;
	    
	    @Autowired
	    static Cart cart;
	    
	    @Autowired
	    static CartDAO cartDAO;
	    
	    @BeforeClass
	    public static void init()
	  
	    {
	        context = new AnnotationConfigApplicationContext();
	        context.scan("com.niit.shoppingcart");
	        context.refresh();
	        
	        cartDAO= (CartDAO) context.getBean("cartDAO");
	        cart=(Cart) context.getBean("cart");
	        System.out.println("BEAN CREATED");
	    }
	    
	    //Starting of JUnit Test Cases
	  
	    
	//   @Test
	  /*  public void createCartTestCase()
	   
	    {
	        
	        cart.setCart_id("Mob_25");
	        cart.setQuantity("101");
	        cart.setPrice("100");
	        cart.setProduct_id("Mob_00");
	        Boolean status=cartDAO.save(cart);
	        Assert.assertEquals("Create Cart Test Case",true,status);
	    }

	    
	  //  @Test
	  public void deleteCartTestCase()

	  {
	      cart.setCart_id("Mob_25");
	      Boolean status=cartDAO.delete(cart);
	      Assert.assertEquals("Delete Cart Test Case",true,status);
	    }
	  

	 @Test
	  public void updateCaerTestCase()
	 {
	      cart.setCart_id("Mob_25");
	      cart.setQuantity("201");
	      cart.setPrice("100");
	      cart.setProduct_id("Mob_00");
	      Boolean status=cartDAO.update(cart);
	      Assert.assertEquals("update Cart Test Case",true,status);
	  }
	  
	  
	 //@Test
	  public void getCartTestCase()
	 
	  {
	      Assert.assertEquals("Get Product Test Case",null,cartDAO.get("Mob_21"));  
	  }

	  // @Test
	  public void getAllCartTestCase()
	  {
	      Assert.assertEquals("Get Cart Test Case",3,cartDAO.list());
	  }*/
}
