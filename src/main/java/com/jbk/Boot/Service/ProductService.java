package com.jbk.Boot.Service;

import java.util.List;

import com.jbk.Boot.ModelClass.Product;

public interface ProductService {
	
	public boolean saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int productId);
	
	public boolean deleteProductById(int productId);
	
	public boolean updateProduct(Product product);
	
	public List<Product> sortProduct_Asc (String sortType);
	
	public List<Product> sortProduct_Desc (String sortType);
	
	public Product getMaxPriceProduct_1();
	
	public Product getMaxPriceProduct_2();
	
	public double getSumOfProductPrice();
	
	public int getTotalCountOfProduct();
	
}
