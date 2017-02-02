package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.SubCategory;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SubCategoryController {
	@Autowired
	SubCategory subcategory;
	@Autowired
	SubCategoryDAO subcategoryDAO;
	
	
	@RequestMapping("/subcategory")
	public String subcategory(Model model)

	{
		model.addAttribute("UserClickedSubCategory", "true");
		return "admin";
	}
	
	@RequestMapping("/subcategorytable")
	public String subcategorytable(Model model)

	{
		model.addAttribute("UserClickedSubCategorytable", "true");
		return "admin";
	}
	
	
	 @RequestMapping("/addsubcategory")
	 public String Addsubcategory(Model model, HttpSession session, @RequestParam("ID") String id, @RequestParam("name") String name, @RequestParam("description") String description)
	 {
		 subcategory.setId(id);
		 subcategory.setName(name);
		 subcategory.setDescription(description);
		 ;
 if(subcategoryDAO.save(subcategory))
 {
	 
 
	 model.addAttribute("Smessage","SubCategory added");
	 
	 session.setAttribute("subcategory", subcategory);
	   List<SubCategory> subcategoryList = subcategoryDAO.list();
	   session.setAttribute("SubCategoryList", subcategoryList);
 }
 else
	 model.addAttribute("SEmessage","Error occured");
  model.addAttribute("UserClickedADDSUBCATEGORY", "true");
  
  return "admin";
		} 

	 
	 @RequestMapping("manage_subcategory_remove")
		public String deleteSubCategory(@RequestParam("id") String id, Model model, HttpSession session) throws  Exception
		{
			

			subcategory=subcategoryDAO.get(id);
			System.out.println(subcategory);
			boolean flag=subcategoryDAO.delete(id);
			 
			List<SubCategory> subcategoryList = subcategoryDAO.list();
			   session.setAttribute("SubCategoryList", subcategoryList);

			String msg="successfull done the operation";
		if(!flag==true)
			msg="operation could not be success";
		
			return "forward:/subcategorytable";
		

		}
	 @RequestMapping("manage_subcategory_edit")
     public String editSupplier(@RequestParam("id") String id, Model model, HttpSession session)
    {
	
	subcategory=subcategoryDAO.get(id);
	model.addAttribute("subcategory", subcategory);
	
	   
	model.addAttribute("UserclickedsubCEDIT", "true");
	return "admin";

}
	 
	 /*@RequestMapping("/editcategory")
	 public String Addcategory(Model model, HttpSession session, @RequestParam("ID") String id, @RequestParam("name") String name, @RequestParam("description") String description)
	 {
		 subcategory.setId(id);
		 subcategory.setName(name);
		 subcategory.setDescription(description);
 if(subcategoryDAO.update(subcategory))
 {
	 model.addAttribute("Smessage","Category updated");
	 
	 session.setAttribute("subcategory", subcategory);
	   List<SubCategory> subcategoryList = subcategoryDAO.list();
	   session.setAttribute("SubCategoryList", subcategoryList);
      model.addAttribute("EditSubCategory", "true");
	   return "admin";
 }
 
 else
     {
	      model.addAttribute("SEmessage","Error Occured");
     }
      return "admin";
 }*/

}
