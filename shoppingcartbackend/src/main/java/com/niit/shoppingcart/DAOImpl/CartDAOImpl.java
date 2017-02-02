package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    @Transactional
	public boolean save(Cart cart) {
    	try {
			if (get(cart.getCart_id()) != null) {
				return false;
			}
			cart = (Cart) sessionFactory.getCurrentSession().merge(cart);
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
@Transactional
	public boolean update(Cart cart) {
	{
	       try{
		        if(get(cart.getCart_id()) ==null)
		        {
			 return false;
		        }
	 cart=(Cart) sessionFactory.getCurrentSession().merge(cart) ;
	 sessionFactory.getCurrentSession().update(cart);
	        return true;
	 }
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}     
	}
	      
}
 @Transactional
	public boolean delete(Cart cart) {
    
	 try{
		  Cart a=new Cart();
		  a=get(cart.getCart_id());
		  System.out.println(a.getCart_id());
		  if(get(cart.getCart_id()) !=null){
	         cart=(Cart) sessionFactory.getCurrentSession().merge(cart);
	         sessionFactory.getCurrentSession().delete(cart);
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

	public Cart get(String id) {
		return (Cart) sessionFactory.getCurrentSession() .get(Cart.class,id);
	}	
   
	@Transactional
	public List<Cart> list() {
		String hql="from Cart";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	
	

	}
}

