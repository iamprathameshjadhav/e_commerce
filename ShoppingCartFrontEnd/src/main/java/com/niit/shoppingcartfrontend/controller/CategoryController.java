package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
	
 

	@RequestMapping("manage_category_remove")
	public String deleteCategory(@RequestParam("id") String Category_id, Model model, HttpSession session) throws  Exception
	{
		

		category=categoryDAO.get(Category_id);
		System.out.println(category);
		boolean flag=categoryDAO.delete(Category_id);
		 
		List<Category> categoryList = categoryDAO.list();
		   session.setAttribute("CategoryList", categoryList);

		String msg="successfull done the operation";
	if(!flag==true)
		msg="operation could not be success";
	
		return "forward:/categorytable";
	

	}
	
	@RequestMapping("manage_category_edit")
	public String editCategory(@RequestParam("id") String id, Model model, HttpSession session)
	{
		
		category=categoryDAO.get(id);
		model.addAttribute("category", category);
		
		   
		model.addAttribute("UserClickedEDIT", "true");
		return "admin";

	}
	
	 @RequestMapping("/editcategory")
	 public String Addcategory(Model model, HttpSession session, @RequestParam("ID") String id, @RequestParam("name") String name, @RequestParam("description") String description,
			 @RequestParam("types") String types, @RequestParam("gender") String gender)
	 {
		 category.setCategory_id(id);
		 category.setName(name);
		 category.setDescription(description);
		 category.setTypes(types);
		 category.setGender(gender);
 if(categoryDAO.update(category))
 {
	 model.addAttribute("message","Category updated");
	 
	 session.setAttribute("category", category);
	   List<Category> categoryList = categoryDAO.list();
	   session.setAttribute("CategoryList", categoryList);
      model.addAttribute("EditCategory", "true");
	   return "admin";
 }
 
 else
     {
	      model.addAttribute("errormsg","Error Occured");
     }
      return "admin";
 } 
}
	

