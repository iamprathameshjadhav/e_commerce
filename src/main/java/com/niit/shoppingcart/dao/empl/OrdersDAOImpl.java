package com.niit.shoppingcart.dao.empl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Orders;

@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO{
    @Autowired
    SessionFactory sessionFactory;
	
    public OrdersDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    @Transactional
    public boolean save(Orders orders) {
    	try {
			if (get(orders.getOrder_id()) != null) {
				return false;
			}
			orders = (Orders) sessionFactory.getCurrentSession().merge(orders);
			sessionFactory.getCurrentSession().save(orders);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
  @Transactional
	public boolean update(Orders orders) {
	  try {
			if (get(orders.getOrder_id()) != null) {
				return false;
			}
			orders = (Orders) sessionFactory.getCurrentSession().merge(orders);
			sessionFactory.getCurrentSession().save(orders);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional	
	public boolean delete(Orders orders) {
		
		  try{
			  Orders a=new Orders();
			  a=get(orders.getOrder_id());
			  System.out.println(a.getOrder_id());
			  if(get(orders.getOrder_id()) !=null){
		         orders=(Orders) sessionFactory.getCurrentSession().merge(orders);
		         sessionFactory.getCurrentSession().delete(orders);
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
	public Orders get(String id) {
	   return (Orders) sessionFactory.getCurrentSession() .get(Orders.class,id);
	}


	public List<Orders> list() {
		String hql="from Orders";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
