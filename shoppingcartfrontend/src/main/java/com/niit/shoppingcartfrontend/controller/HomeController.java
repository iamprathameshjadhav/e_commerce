package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.DAOImpl.CartDAOImpl;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.SubCategory;
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
	@Autowired
	SubCategory subcategory;
	@Autowired
	SubCategoryDAO subcategoryDAO;
	@Autowired
	Cart cart;
	@Autowired
	CartDAO cartDAO;
	
	
	
	@RequestMapping("/login")
	public String login(Model model) 
	{
		model.addAttribute("UserClickedLogin", "true");
		 
		return "index";
	}
	
	@RequestMapping("/aboutus")
	public String AboutUs(Model model)
	{
		model.addAttribute("UserClickedAboutUs", "true");
		
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
		   session.setAttribute("subcategory", subcategory);
			session.setAttribute("subcategoryList", subcategoryDAO.list());
			List<Cart> cartList = cartDAO.getActiveByUser(user.getId());
			session.setAttribute("cartItemCount", cartList.size());
	
			
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

				
				 session.setAttribute("isUser", true);
				
				 model.addAttribute("success"," successfully logged In");
				 session.setAttribute("name",user.getName());
				return "index";
				
			}
		 
		}
		
		
	}

	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
		session.invalidate();
		model.addAttribute("UserClickedLogout", "true");
	/*	session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());*/
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
	//	user.setAddress(address);
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
	public String homepage( Model model,HttpSession session)
	
	{
		model.addAttribute("UserClickedNavbar", "true");
		model.addAttribute("UserClickedcarousel", "true");
		model.addAttribute("UserClickedfooter", "true");
		session.setAttribute("category", category);
		session.setAttribute("categoryList",categoryDAO.list());
		   session.setAttribute("subcategory", subcategory);
			session.setAttribute("subcategoryList", subcategoryDAO.list());
		
		
		return "index";
	}

	
}
