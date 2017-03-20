package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;

import com.niit.shoppingcart.model.User;

@Controller
public class UserController {
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	

	
	@RequestMapping("manage_user_remove")
	public String deleteUser(@RequestParam("id") String id, Model model, HttpSession session) throws  Exception
	{
		

		user=userDAO.get(id);
		System.out.println(user);
		boolean flag=userDAO.delete(user);
		 
		List<User> userList = userDAO.list();
		   session.setAttribute("UserList", userList);

		String msg="successfull done the operation";
	if(!flag==true)
		msg="operation could not be success";
	
		return "forward:/usertable";
	

	}
	@RequestMapping("manage_user_edit")
	public String editUser(@RequestParam("id") String id, Model model, HttpSession session)
	{
		
		user=userDAO.get(id);
		model.addAttribute("user", user);
		
		   
		model.addAttribute("UserClickedEdit", "true");
		return "admin";

	}
	
	 @RequestMapping("/editusertable")
		public String Editusertable(Model model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password,
				 @RequestParam("contact") String contact, @RequestParam("address") String address, @RequestParam("role") String role, HttpSession session){
			 
		    user.setEmail(id);
		    user.setName(name);
			user.setPassword(password);
			user.setContact(contact);
			user.setAddress(address);
	        user.setRole(role);

	        if(userDAO.update(user))
	
		 model.addAttribute("massage","Table Updated");
	        
	        session.setAttribute("user", user);
	 	   List<User> userList = userDAO.list();
	 	   session.setAttribute("UserList", userList);
		 model.addAttribute("UpdateTable", "true");
	       return "admin";
	
		
	 }
}
