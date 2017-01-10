package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {

	/*
	 * @RequestMapping("/") public String myhome( Model model) {
	 * 
	 * return "index"; }
	 */
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/login")
	public String login(Model model) 
	{
		model.addAttribute("UserClickedLogin", "true");
		 
		return "index";
	}


	@RequestMapping("/validate")
	public String admin( Model model, @RequestParam("email") String email, @RequestParam("pwd") String password, HttpSession session) {
		model.addAttribute("UserClickedSubmit", "true");
		List<Supplier> supplierList = supplierDAO.list();
		   session.setAttribute("SupplierList", supplierList);
		   List<Category> categoryList = categoryDAO.list();
		   session.setAttribute("CategoryList", categoryList);
		   List<Product> productList = productDAO.list();
		session.setAttribute("ProductList", productList);
		 List<User> userList = userDAO.list();
		   session.setAttribute("UserList", userList);
	  
	
			
		user= userDAO.isValidUser(email, password);
		 System.out.println(user);

		if(user==null)
		{
			 model.addAttribute("error"," invalid credentials");
			 model.addAttribute("invalidCredentials", true);
						 return "index";
		}
		else
		{
			
			if(user.getRole().equals("admin"))
			{
				
				model.addAttribute("UserClickedADMIN", true);
				 return "admin";	
				
			}
			else
			{

				model.addAttribute("isUser", true);
				 model.addAttribute("success"," successfully logged In");
				return "index";
				
			}
		 
		}
		
		
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("UserClickedLogout", "true");
		return "index";
	}

	@RequestMapping("/register")
	public String resigter(Model model)

	{
      
		model.addAttribute("UserClickedRegister", "true");
		return "index";
	}
	
   @RequestMapping("/signup")
	public String Signup(Model model, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password,
			 @RequestParam("contact") String contact, @RequestParam("address") String address, HttpSession session){
		 
	  
	   user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		user.setAddress(address);
        user.setRole("user");

        if(userDAO.save(user))
 {  
	 
	 model.addAttribute("successmsg"," Thanking you to be a part of PRADHA.COM");
	 model.addAttribute("showLogin", "true");
       return "index";
	}
 else
	 model.addAttribute("errormsg"," Invalid Email Address"); 
 model.addAttribute("showRegister", "true");
		return "index";
	}
  

	@RequestMapping(value = { "/homepage", "/" })
	public String homepage( Model model)
	
	{
		model.addAttribute("UserClickedNavbar", "true");
		model.addAttribute("UserClickedcarousel", "true");
		model.addAttribute("UserClickedfooter", "true");
	  
		return "index";
	}

	@RequestMapping("/menstopwear")
	public String Menstop(Model model)

	{
		model.addAttribute("UserClickedTopWearr", "true");
		return "index";
	}

	@RequestMapping("/mensbottomwear")
	public String Mensbottom(Model model)

	{
		model.addAttribute("UserClickedBottomWear", "true");
		return "index";
	}

	@RequestMapping("/womenstopwear")
	public String Womenstop(Model model)

	{
		model.addAttribute("UserClickedTopWearr", "true");
		return "index";
	}

	@RequestMapping("/womensbottomwear")
	public String Womensbottom(Model model)

	{
		model.addAttribute("UserClickedBottomWear", "true");
		return "index";
	}

	@RequestMapping("/thehotlist")
	public String Hotlist(Model model)

	{
		model.addAttribute("UserClickedHotList", "true");
		return "index";
	}
	
}
