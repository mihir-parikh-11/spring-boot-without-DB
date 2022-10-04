package com.jbk.Boot.Dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.Boot.ModelClass.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	List<Product> list = new ArrayList<Product>();
	
	
	public ProductDaoImpl() {
		System.out.println("ProductDaoImpl");
		list.add(new Product(1, "Pen", 25, 15, "Stationary"));
		list.add(new Product(2, "Pencile", 750, 10, "Stationary"));
		list.add(new Product(3, "Book", 610, 45, "Stationary"));
		list.add(new Product(4, "Ruber", 350, 5, "Stationary"));
		list.add(new Product(5, "Not-Book", 150, 65, "Stationary"));
		list.add(new Product(6, "Long-Book", 10, 85, "Stationary"));
	}

	@Override
	public boolean saveProduct(Product product) {
		boolean isAdded = list.add(product);
		return isAdded;
	}

	@Override
	public List<Product> getAllProduct() {

		return this.list;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = null;
		for (Product product2 : list) {

			if (productId == product2.getProductId()) {
				product = product2;
				break;
			}
		}
		return product;
	}

	@Override
	public boolean deleteProductById(int productId) {
		boolean idDeleted = false;
		
		for (Product product : list) {
			if(productId==product.getProductId()) {
				list.remove(product);
				idDeleted=true;
				break;
			}
		}
		return idDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = false;
		
		for (Product product2 : list) {
			
			if(product.getProductId() == product2.getProductId()) {
				list.set(list.indexOf(product2), product);
				isUpdated=true;
				break;
			}
		}
		return isUpdated;
	}

}
