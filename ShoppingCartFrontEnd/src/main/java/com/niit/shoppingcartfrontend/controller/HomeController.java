package com.niit.shoppingcartfrontend.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.catalina.connector.Request;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.SubCategory;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {

	
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
	@Autowired
	private HttpSession session;

	@Autowired
	@Qualifier("myAuthenticationManager")
	private AuthenticationManager authenticationManager;

	
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
	
	@RequestMapping(value="/addToCart")
	public String addToCart(@RequestParam("productId") String productId , HttpSession session ,Model model)
	{
		

		// get the product based on product name
		Product product = productDAO.get(productId);

		cart.setProductName(product.getName());
		cart.setStock(product.getQuantity());
		cart.setPrice(product.getPrice());
		cart.setUser_email(user.getEmail());
		cart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
		cart.setOrdered(0);
		cartDAO.save(cart);
	
		
		int cartItemCount = (Integer) session.getAttribute("cartItemCount") + 1;
		session.setAttribute("cartItemCount", cartItemCount);
		
		model.addAttribute("message", "Successfully added the product to Cart !!!");
		model.addAttribute("ShowMessage", true);

		return "index";

	}

	@RequestMapping("/carttable")
	public String Cart(Model model,HttpSession session) 
	{
		
		List<Cart> cartList = cartDAO.getActiveByUser(cart.getUser_email());
		model.addAttribute("cartList", cartList);
		model.addAttribute("totalAmount", cartDAO.getTotalAmount(cart.getUser_email()));
		model.addAttribute("UserClickedCart", "true");
		return "index";
	}
	
	@RequestMapping("/manage_cart_remove")
	public String removeCart(@RequestParam("id") int cartId, Model model, HttpSession session) throws Exception
	{
		boolean flag = cartDAO.delete(cartId);
		if (flag)
		{
			int cartItemCount = (Integer) session.getAttribute("cartItemCount") - 1;
			session.setAttribute("cartItemCount", cartItemCount);
		}
		return "index";
	}
	
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
	public ModelAndView logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		ModelAndView mv = new ModelAndView("/index");
		
		session = request.getSession(false);
		if (session != null)
			
		session.invalidate();
		
		session = request.getSession(true);

		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("subcategoryList", subcategoryDAO.list());
		session.setAttribute("productList", productDAO.list());

		mv.addObject("UserClickedLogout", "true");
		mv.addObject("logoutmsg", "You Are Successfully Logged-Out");
		return mv;
	}


  

	@RequestMapping(value = { "/homepage", "/" })
	public String homepage( Model model,HttpSession session)
	
	{
		model.addAttribute("UserClickedaboutus", "true");
		model.addAttribute("UserClickedNavbar", "true");
		model.addAttribute("UserClickedcarousel", "true");
		model.addAttribute("UserClickedfooter", "true");
		session.setAttribute("category", category);
		session.setAttribute("categoryList",categoryDAO.list());
		   session.setAttribute("subcategory", subcategory);
			session.setAttribute("subcategoryList", subcategoryDAO.list());
			session.setAttribute("cart", cart);
			session.setAttribute("cartList", cartDAO.getActiveByUser(user.getEmail()));
			
		
		
		return "index";
	}

	
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError(Model model) {
	//	log.debug("Starting of the method loginError");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("ShowMessage", true);
		mv.addObject("message", "Invalid credentials");
	//	log.debug("Ending of the method loginError");
		return mv;

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied(Model model) {
	//	log.debug("Starting of the method accessDenied");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("ShowMessage", true);
		mv.addObject("message", "You are not authorized to access this page");
	//	log.debug("Ending of the method accessDenied");
		return mv;

	}
}
