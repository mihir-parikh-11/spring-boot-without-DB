package com.jbk.Boot.Dao;

import java.util.List;

import com.jbk.Boot.ModelClass.Product;

public interface ProductDao {
	
	public boolean saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int productId);
	
	public boolean deleteProductById(int productId);
	
	public boolean updateProduct(Product product);
	

}
