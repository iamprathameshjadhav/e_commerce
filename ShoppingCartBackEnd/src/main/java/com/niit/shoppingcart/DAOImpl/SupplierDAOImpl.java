package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
     @Autowired
     SessionFactory sessionFactory;
     
     public SupplierDAOImpl (SessionFactory sessionFactory) {
    	 this.sessionFactory = sessionFactory;
     }
         @Transactional 
    	 public boolean save(Supplier supplier) {
		    try{
		    	if (get(supplier.getSupplier_id()) != null) {
		    		return false;
		    	}
		    	supplier = (Supplier) sessionFactory.getCurrentSession().merge(supplier);
		        sessionFactory.getCurrentSession().save(supplier);
		        return true;   
		    }catch (HibernateException e) {
		    	e.printStackTrace();
		       return false;
		    }
	}
     @Transactional
	public boolean update(Supplier supplier) {
    	 {
    		 try{
    			 if(get(supplier.getSupplier_id()) ==null)
    			 {
    				 return false;
    			 }
   supplier=(Supplier) sessionFactory.getCurrentSession().merge(supplier); 
   sessionFactory.getCurrentSession().update(supplier);
   return true; 		
    		 }
    		 catch(HibernateException e)
    		 {
    			 e.printStackTrace();
    		 }
    	
		return false;
    	 }
	}
@Transactional
	public boolean delete(Supplier supplier) {
		try{
			Supplier a=new Supplier();
			a=get(supplier.getSupplier_id());
			System.out.println(a.getSupplier_id());
			if(get(supplier.getSupplier_id()) !=null){
			 supplier=(Supplier) sessionFactory.getCurrentSession().merge(supplier);
			   sessionFactory.getCurrentSession().delete(supplier);
			   return true;
			}
			else
			{
				return false;
		 	}
		    }
	    catch(HibernateException e){
	    	e.printStackTrace();
	    	return false;
	    }
 }
    @Transactional
	public Supplier get(String id) {
		return (Supplier) sessionFactory.getCurrentSession() .get(Supplier.class, id);
	}
    @Transactional
	public List<Supplier> list() {
		String hql="from Supplier";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
