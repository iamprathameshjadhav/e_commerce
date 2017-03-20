package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		try {
			if (get(category.getCategory_id()) != null) {
				return false;
			}
			category = (Category) sessionFactory.getCurrentSession().merge(category);
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
public boolean update(Category category)
	{
       try{
	        if(get(category.getCategory_id()) ==null)
	        {
		 return false;
	        }
 category=(Category) sessionFactory.getCurrentSession().merge(category) ;
 sessionFactory.getCurrentSession().update(category);
        return true;
 }
	catch(HibernateException e)
	{
		e.printStackTrace();
		return false;
	}
}
	
  @Transactional
	public boolean delete(String Category_id) {
		Category del=new Category();
		del.setCategory_id(Category_id);
	  try{
		  
		 
		   sessionFactory.getCurrentSession().delete(del);
		  return true;
		  }
	
	  catch(HibernateException e){
		  e.printStackTrace();
	return false;
	  }
  }	  


	@Transactional
  public Category get(String id) {
	return (Category) sessionFactory.getCurrentSession() .get(Category.class,id);
	}

	@Transactional
	public List<Category> list() {
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}



}
