package com.niit.shoppingcartfrontend.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcartfrontend.util.Util;

import ch.qos.logback.core.util.FileUtil;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;

 @Controller
public class AdminController {
	
	 @Autowired
	 Category  category;
	 
	 @Autowired
	 CategoryDAO categoryDAO;

	 @Autowired
	 Supplier supplier;
	 
	 @Autowired
	 SupplierDAO supplierDAO;

	 
	 @Autowired
	 Product product;
	 
	 @Autowired
	 ProductDAO productDAO;
	 /*private String path="D:\\NIIT Project\\shoppingcartfrontend\\src\\main\\webapp\\resources\\lib\\images\\ProductImages";*/
	 
	 @RequestMapping("/addcategory")
	 public String Addcategory(Model model, HttpSession session, @RequestParam("ID") String category_id, @RequestParam("name") String name, @RequestParam("description") String description,
			 @RequestParam("types") String types, @RequestParam("gender") String gender)
	 {
		 category.setCategory_id(category_id);
		 category.setName(name);
		 category.setDescription(description);
		 category.setTypes(types);
		 category.setGender(gender);
 if(categoryDAO.save(category))
 {
	 
 
	 model.addAttribute("message","Category added");
	 
	 session.setAttribute("category", category);
	   List<Category> categoryList = categoryDAO.list();
	   session.setAttribute("CategoryList", categoryList);
 }
 else
	 model.addAttribute("message","Error occured");
  model.addAttribute("UserClickedCATEGORY", "true");
  
  return "admin";
		} 
	  
	 @RequestMapping("/addsupplier")
	 public String Addsupplier(Model model, HttpSession session, @RequestParam("ID") String supplier_id, @RequestParam("name") String name, @RequestParam("Address") String Address)
	 {
		 supplier.setSupplier_id(supplier_id);
		 supplier.setName(name);
		 supplier.setAddress(Address);
 if(supplierDAO.save(supplier))
 {
	 model.addAttribute("message","Supplier added");
	 
	  session.setAttribute("supplier", supplier);
	   List<Supplier> supplierList = supplierDAO.list();
	   session.setAttribute("SupplierList", supplierList);
 }
 else
	 model.addAttribute("message","Error occured");
  model.addAttribute("UserClickedSUPPLIER", "true");
  
  return "admin";
		} 
	 
	/* @RequestMapping("/addproduct")
	 public String Addproduct(Model model, @RequestParam("image") MultipartFile file, @RequestParam("ID") String product_id, @RequestParam("name") String name, @RequestParam("price") String price,
	 @RequestParam("quantity") String quantity, @RequestParam("category_id") String category_id, @RequestParam("supplier_id") String supplier_id, HttpSession session)
	 {
		 product.setProduct_id(product_id);
		 product.setName(name);
		 product.setPrice(price);
		 product.setQuantity(quantity);
		 product.setCategory_id(category_id);
		 product.setSupplier_id(supplier_id);
		 System.out.println("prathamesh");
 if(productDAO.save(product))
 {
	 Util.upload(path, file, product.getProduct_id()+".jpg");

	 
	 model.addAttribute("message","Product added");
	 session.setAttribute("product", product);
	   List<Product> productList = productDAO.list();
	   session.setAttribute("ProductList", productList);
	  

 }
	 else
	 {
		
	 model.addAttribute("message","Error occured");
  model.addAttribute("UserClickedPRODUCT", "true");
	 }
  
  return "admin";
		} 
	 
	 
	 @RequestMapping(value = { "/usertable"})
		public String Usertable(Model model)
		

		{
		 model.addAttribute("UserClickedViewManage", "true");
		 			return "admin";
		}*/
	 
	 
	 @RequestMapping(value = { "/categorytable"})
		public String categorytable(Model model)
		

		{
		 model.addAttribute("UserClickedViewCategoryTable", "true");
		 			return "admin";
		}
	 
	 @RequestMapping(value = { "/suppliertable"})
		public String Suppliertable(Model model)
		

		{
		 model.addAttribute("UserClickedViewSupplierTable", "true");
		 			return "admin";
		}
	 
	 
	 @RequestMapping(value = { "/producttable"})
		public String Producttable(Model model)
		

		{
		 model.addAttribute("UserClickedViewProductTable", "true");
		 			return "admin";
		}
	
	 
	 @RequestMapping(value = { "/adminnavbar"})
		public String adminnavbar(Model model)

		{
			model.addAttribute("UserClickedAdminnavbar", "true");
			return "admin";
		}

	@RequestMapping("/category")
	public String Category(Model model)

	{
		model.addAttribute("UserClickedCATEGORY", "true");
		return "admin";
	}
	
	@RequestMapping("/supplier")
	public String Supplier(Model model)

	{
		model.addAttribute("UserClickedSUPPLIER", "true");
		return "admin";
	}

	@RequestMapping("/product")
	public String Product(Model model,HttpSession session)

	{
		model.addAttribute("UserClickedPRODUCT", "true");
		   List<Category> categoryList = categoryDAO.list();
		   session.setAttribute("CategoryList", categoryList);
				return "admin";
	}

	
 }
