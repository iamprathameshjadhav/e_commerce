package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String Product_id);
	public Product get(String id);
	public List<Product> list();
	public List<Product> listByCategoryAndSubCategory(String categoryId, String subCategoryId);
	public List<Product> getAll(); 
	public List<String> productnames();
}
