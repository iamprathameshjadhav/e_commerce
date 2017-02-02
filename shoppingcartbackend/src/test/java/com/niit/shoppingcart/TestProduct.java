package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;



public class TestProduct {

    @Autowired
    static AnnotationConfigApplicationContext context;
    
    @Autowired
    static Product product;
    
    @Autowired
    static ProductDAO productDAO;
    
    @BeforeClass
    public static void init()
  
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.niit.shoppingcart");
        context.refresh();
        
        productDAO= (ProductDAO) context.getBean("productDAO");
        product=(Product) context.getBean("product");
        System.out.println("BEAN CREATED");
    }
    
    //Starting of JUnit Test Cases
  
    
   @Test
    public void createProductTestCase()
   
    {
        
        product.setProduct_id("Mob_00");
        product.setName("abc");
        product.setPrice("100");
        product.setCategory_id("Mob_01");
        product.setSupplier_id("Mob_11");
        
        Boolean status=productDAO.save(product);
        Assert.assertEquals("Create Product Test Case",true,status);
    }

    
   // @Test
/*  public void deleteProductTestCase()

  {
      product.setProduct_id("Mob_00");
      Boolean status=productDAO.delete(product);
      Assert.assertEquals("Delete Product Test Case",true,status);
    }*/
  

 //@Test
  public void updateCategoryTestCase(){
      product.setProduct_id("Mob_00");
      product.setName("Prathmesh");
      product.setPrice("100");
      product.setCategory_id("mob_02");
      product.setSupplier_id("PS123");
      Boolean status=productDAO.update(product);
      Assert.assertEquals("update Product Test Case",true,status);
  }
  
  
 //@Test
  public void getProductTestCase()
 
  {
      Assert.assertEquals("Get Product Test Case",null,productDAO.get("Mob_00"));  
  }

  // @Test
  public void getAllProductTestCase()
  {
      Assert.assertEquals("Get Product Test Case",3,productDAO.list().size());
  }
} 

