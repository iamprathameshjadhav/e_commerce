package com.niit.shoppingcart.dao.empl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory  sessionFactory;
	
  public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
   @Transactional
	public boolean save(User user) {
	  
		try {
			if (get(user.getEmail()) != null) 
			{
				
				return false;
			}
			user = (User) sessionFactory.getCurrentSession().merge(user);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	} 
   @Transactional	
   public boolean update(User user)
	   {
	       try{
		        if(get(user.getEmail()) ==null)
		        {
			 return false;
		        }
	 user=(User) sessionFactory.getCurrentSession().merge(user) ;
	 sessionFactory.getCurrentSession().update(user);
	        return true;
	 }
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
     }
   @Transactional
	public boolean delete(User user) {
	
	  try{
		  User a=new User();
		  a=get(user.getEmail());
		  System.out.println(a.getEmail());
		  if(get(user.getEmail()) !=null){
	         user=(User) sessionFactory.getCurrentSession().merge(user);
	         sessionFactory.getCurrentSession().delete(user);
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
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession() .get(User.class,id);
	}
	@Transactional
	public List<User> list()
	{
		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
   }

	@Transactional
	public User getUserName(String email)
{
	String hql="from User where email='"+email+"'";
	
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	
	if(query.list().isEmpty())
	{
		return null;
	}
	else
	{
		
	    return (User) query.list().get(0);
	}
	
}	
	
	//*********************************************************************validation user*************************************************************************************************************************************//
	@Transactional
	public User isValidUser(String userName, String userPassword)
	{
		System.out.println("Received" +userName +"  "+ userPassword);
		User user =getUserName(userName);
		if(user==null)
		{
			    return null;
		}
		else if(user.getEmail().equals(userName) && user.getPassword().equals(userPassword))
		{
			
			return user;
		}
		
		else
		{
			return null;
		}
	}
}
