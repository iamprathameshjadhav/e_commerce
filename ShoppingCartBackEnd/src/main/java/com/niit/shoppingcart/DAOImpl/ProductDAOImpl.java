package com.niit.shoppingcart.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
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
  public boolean delete(String product_id) {
		Product del=new Product();
		del.setProduct_id(product_id);
	  try{
		  
		 
		   sessionFactory.getCurrentSession().delete(del);
		  return true;
		  }
	
	  
	  /* try{
		
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
*/	      
	  
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
   
   

	@Transactional
   public List<Product> listByCategoryAndSubCategory(String categoryId, String subCategoryId) {
		String hql = "from Product where category_id = '" + categoryId + "' and subcategory_id = '" + subCategoryId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
   }
  
	@Transactional
	public List<Product> getAll() 
		{

			String hql ="from Product";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
	
	@Transactional
	public List<String> productnames() 
		{
			List<String> list=new ArrayList<String>();
			Query query = sessionFactory.getCurrentSession().createQuery("from Product");
			List<Product> productList =query.list();
			for(int i=0; i<productList.size(); i++)
				list.add(productList.get(i).getName());
			return list;
		}
	
}
