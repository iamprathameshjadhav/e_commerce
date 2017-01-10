package com.niit.shoppingcartfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
@Autowired
Supplier supplier;
@Autowired
SupplierDAO supplierDAO;

@RequestMapping("manage_supplier_remove")
public String deleteSupplier(@RequestParam("id") String id, Model model, HttpSession session) throws  Exception
{
	

	supplier=supplierDAO.get(id);
	System.out.println(supplier);
	boolean flag=supplierDAO.delete(supplier);
	 System.out.println("Prath" + flag);
	List<Supplier> supplierList = supplierDAO.list();
	   session.setAttribute("SupplierList", supplierList);

	String msg="successfull done the operation";
if(!flag==true)
	msg="operation could not be success";
	
model.addAttribute("msg", msg);
	return "forward:/suppliertable";


}

   @RequestMapping("manage_supplier_edit")
     public String editSupplier(@RequestParam("id") String id, Model model, HttpSession session)
    {
	
	supplier=supplierDAO.get(id);
	model.addAttribute("supplier", supplier);
	
	   
	model.addAttribute("UserclickedEDIT", "true");
	return "admin";

}
   @RequestMapping("/editsupplier")
	 public String Editsupplier(Model model, HttpSession session, @RequestParam("ID") String supplier_id, @RequestParam("name") String name, @RequestParam("Address") String Address)
	 {
		 supplier.setSupplier_id(supplier_id);
		 supplier.setName(name);
		 supplier.setAddress(Address);
if(supplierDAO.update(supplier))
	
	 model.addAttribute("message","Supplier updated");
	 
	  session.setAttribute("supplier", supplier);
	   List<Supplier> supplierList = supplierDAO.list();
	   session.setAttribute("SupplierList", supplierList);
      model.addAttribute("EditSupplier", true);

     return "admin";
		} 

}
