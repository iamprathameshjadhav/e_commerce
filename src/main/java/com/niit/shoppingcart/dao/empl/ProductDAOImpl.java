package com.niit.shoppingcart.dao.empl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public boolean save(Product product) {
		try{
			if(get(product.getProduct_id()) !=null)
			{
				
		return false;
			}
	product = (Product) sessionFactory.getCurrentSession().merge(product);
	sessionFactory.getCurrentSession().save(product);
	
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			
		return false;
	}
}		
  @Transactional
	public boolean update(Product product)
  {
	  try{
		  if(get(product.getProduct_id()) ==null)
		  {
	  return false;
		  }
		  product=(Product) sessionFactory.getCurrentSession().merge(product);
	     sessionFactory.getCurrentSession().update(product);
		  return true;
}
	  catch(HibernateException e)
	  {
		  e.printStackTrace();
		  return false;
	  }
  }
		
  @Transactional
  public boolean delete(Product product) {
	  try{
		  Product a=new Product();
		  a=get(product.getProduct_id());
		  System.out.println(a.getProduct_id());
		  if(get(product.getProduct_id()) !=null){
			  product=(Product) sessionFactory.getCurrentSession().merge(product);
			  sessionFactory.getCurrentSession().delete(product);
			  return true;
		  }
		  else
		  {
		  return false;
		  }
	      }
	  
	  catch(HibernateException e) {
		  e.printStackTrace();
		return false;
	}
 }
    @Transactional
	public Product get(String id) {
	 return(Product) sessionFactory.getCurrentSession().get(Product.class,id);
		 
	}
   @Transactional
	public List<Product> list() {
	String hql="from Product";
	Query query=sessionFactory.getCurrentSession() .createQuery(hql);
		return query.list();
	}
}
