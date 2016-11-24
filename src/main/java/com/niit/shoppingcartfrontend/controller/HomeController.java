package com.niit.shoppingcartfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String myhome( Model model)
	{
		return "index";
	}

	@RequestMapping("/login")   
	public String login(Model model)
       {
      
		model.addAttribute("UserClickedLogin","true");  
        return "index";
       }
  
	 @RequestMapping("/register")
     public String resigter(Model model)
    
	 {
     model.addAttribute("UserClickedRegister","true");  
      return "index";
     }

    @RequestMapping("/homepage")
    public String homepage(Model model)
  
    {
    model.addAttribute("UserClickedNavbar","true");  
     return "index";
    }

    



}




