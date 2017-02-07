package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


public class TestUser { 
	
	 @Autowired
	    static AnnotationConfigApplicationContext context;
	    
	    @Autowired
	    static User user;
	    
	    @Autowired
	    static UserDAO userDAO;
	    
	    @BeforeClass
	    public static void init()
	  
	    {
	        context = new AnnotationConfigApplicationContext();
	        context.scan("com.niit.shoppingcart");
	        context.refresh();
	        
	        userDAO= (UserDAO) context.getBean("userDAO");
	        user=(User) context.getBean("user");
	        System.out.println("BEAN CREATED");
	    }
	    
	    //Starting of JUnit Test Cases
	  
	    
	//  @Test
	    public void createUserTestCase()
	   
	    {
	        
	        user.setEmail("Mob_02");
	        user.setName("abc");
	        user.setPassword("123");
	        user.setContact("12345678");
	    //    user.setAddress("pqr");
	       
	        
	        Boolean status=userDAO.save(user);
	        Assert.assertEquals("Create User Test Case",true,status);
	    }

	    
	  //  @Test
	  public void deleteUserTestCase()

	  {
	      user.setEmail("Mob_02");
	      Boolean status=userDAO.delete(user);
	      Assert.assertEquals("Delete User Test Case",true,status);
	    }
	  

	// @Test
	  public void updateCategoryTestCase(){
		  user.setEmail("Mob_02");
	        user.setName("my name is prahamesh updated");
	        user.setPassword("123");
	        user.setContact("12345678");
	      //  user.setAddress("pqr");
	      
	        
	      Boolean status=userDAO.update(user);
	      Assert.assertEquals("update User Test Case",true,status);
	  }
	  
	  
	 //@Test
	  public void getUserTestCase()
	 
	  {
	      Assert.assertEquals("Get User Test Case",null,userDAO.get("Mob_02"));  
	  }

	  // @Test
	  public void getAllUserTestCase()
	  {
	      Assert.assertEquals("Get User Test Case",3,userDAO.list().size());
	  }

}
