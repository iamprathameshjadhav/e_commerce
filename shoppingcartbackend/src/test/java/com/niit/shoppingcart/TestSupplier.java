package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestSupplier  {

    @Autowired
    static AnnotationConfigApplicationContext context;
    
    @Autowired
    static Supplier supplier;
    
    @Autowired
    static SupplierDAO supplierDAO;
    
    @BeforeClass
    public static void init()
  
    {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.niit.shoppingcart");
        context.refresh();
        
        supplierDAO= (SupplierDAO) context.getBean("supplierDAO");
        supplier=(Supplier) context.getBean("supplier");
        System.out.println("BEAN CREATED");
    }
    
    //Starting of JUnit Test Cases
  
    
   @Test
    public void createSupplierTestCase()
   
    {
        
        supplier.setSupplier_id("Mob_11");
        supplier.setName("abc");
        supplier.setAddress("xyz");
        
        
        Boolean status=supplierDAO.save(supplier);
        Assert.assertEquals("Create Supplier Test Case",true,status);
    }

    
   // @Test
  public void deleteSupplierTestCase()

  {
      supplier.setSupplier_id("Mob_00");
      Boolean status=supplierDAO.delete(supplier);
      Assert.assertEquals("Delete Supplier Test Case",true,status);
    }
  

 //@Test
  public void updateSupplierTestCase(){
      supplier.setSupplier_id("Mob_11");
      supplier.setName("Prathmesh");
      supplier.setAddress("xyz");
      Boolean status=supplierDAO.update(supplier);
      Assert.assertEquals("update Supplier Test Case",true,status);
  }
  
  
 //@Test
  public void getSupplierTestCase()
 
  {
      Assert.assertEquals("Get Supplier Test Case",null,supplierDAO.get("Mob_11"));  
  }

  // @Test
  public void getAllSupplierTestCase()
  {
      Assert.assertEquals("Get Supplier Test Case",3,supplierDAO.list().size());
  }
} 

