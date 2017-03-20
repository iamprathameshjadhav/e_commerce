package com.niit.shoppingcartfrontend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcartfrontend.util.Util;

@Controller
public class ProductController {
	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;
	private String path="D:\\NIIT Project\\shoppingcartfrontend\\src\\main\\webapp\\resources\\lib\\images\\ProductImages";
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	
	 @RequestMapping("/addproduct")
	 public String Addproduct(Model model, @RequestParam("image") MultipartFile file , @RequestParam("ID") String product_id, @RequestParam("name") String name, @RequestParam("price") int price,
	 @RequestParam("quantity") int quantity, @RequestParam("category_id") String category_id, @RequestParam("supplier_id") String supplier_id,@RequestParam("id") String subcategory_id, HttpSession session)
	 {
		 boolean isPresent = productDAO.get(product_id) !=null;
		 product.setProduct_id(product_id);
		 product.setName(name);
		 product.setPrice(price);
		 product.setQuantity(quantity);
		 product.setCategory_id(category_id);
		 product.setSupplier_id(supplier_id);
		 product.setSubcategory_id(subcategory_id);
		 System.out.println("prathamesh");
		 
		 boolean flag = false;
		 if(isPresent){
			 flag = productDAO.save(product);
		 }
		 else
		 {
			 flag = productDAO.save(product);
		 }
		 
     if(flag)
 {
	 
	 Util.upload(path, file, product.getProduct_id()+".jpg");
	 
	 model.addAttribute("pmessage","Product added");
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
		}

	@RequestMapping("manage_product_remove")
	public String DeleteProduct(@RequestParam("id") String product_id, Model model, HttpSession session) throws  Exception
	{


		product=productDAO.get(product_id);
		System.out.println(product);
		boolean flag=productDAO.delete(product_id);
		 
		List<Product> productList = productDAO.list();
		   session.setAttribute("ProductList", productList);

		String msg="successfull done the operation";
	if(!flag==true)
		msg="operation could not be success";
	
		return "forward:/producttable";
	

	}
	@RequestMapping("manage_product_edit")
	public String editProduct(@RequestParam("id") String id, Model model, HttpSession session)
	{
		
		product=productDAO.get(id);
		model.addAttribute("product", product);
		
		   
		model.addAttribute("UserClickedPRODUCTEDIT", "true");
		return "admin";

	}
	 @RequestMapping("/editproduct")
	 public String Editproduct(Model model, @RequestParam("ID") String product_id, @RequestParam("name") String name, @RequestParam("price") int price,
	 @RequestParam("quantity") int quantity, @RequestParam("category_id") String category_id, @RequestParam("supplier_id") String supplier_id, HttpSession session)
	 {
		 product.setProduct_id(product_id);
		 product.setName(name);
		 product.setPrice(price);
		 product.setQuantity(quantity);
		 product.setCategory_id(category_id);
		 product.setSupplier_id(supplier_id);
 if(productDAO.update(product))
 

	 model.addAttribute("message","Product updated");
 List<Category> categoryList = categoryDAO.list();
 session.setAttribute("CategoryList", categoryList);
 List<Supplier> supplierList = supplierDAO.list();
 session.setAttribute("SupplierList", supplierList);
	 session.setAttribute("product", product);
	   List<Product> productList = productDAO.list();
	   session.setAttribute("ProductList", productList);
	 
	   model.addAttribute("UserClickedUpadateProduct", true);
      return "admin";
		} 
	 
	 @RequestMapping("/displayProduct")
		public String displayProduct(Model model, HttpSession session,	@RequestParam("categoryId") String categoryId, @RequestParam("subCategoryId") String subCategoryId)
	 {

			List<Product> productList = productDAO.listByCategoryAndSubCategory(categoryId, subCategoryId);
			if (productList != null) {
				model.addAttribute("successMsg", productList.size() + " product(s) found !!!");
				session.setAttribute("productListBySubCategory", productList);
				model.addAttribute("productListLoaded", true);
				
			} 
			else
			{
				model.addAttribute("successMsg", "No products found for this category !!!");
			}

			return "index";
		}
	 
	 @RequestMapping("/searchProduct")
		public ModelAndView searchProduct(@RequestParam("search") String searchname, HttpServletRequest request)
			{
	
				ModelAndView model=new ModelAndView("index");
				List<Product> list = productDAO.getAll();
				List<Product> productList=new ArrayList<Product>();
				for(int i=0;i<list.size(); i++)
					if(list.get(i).getName().toLowerCase().contains(searchname.toLowerCase()))
						productList.add((Product) list.get(i));
				model.addObject("productList",productList);
				model.addObject("searchname",searchname);
				model.addObject("Param", "SearchResult");
				return model;
			}
}
