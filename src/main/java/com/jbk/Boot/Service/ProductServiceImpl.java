package com.jbk.Boot.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Boot.Dao.ProductDao;
import com.jbk.Boot.ModelClass.Product;
import com.jbk.Boot.sort.ProductSortById;
import com.jbk.Boot.sort.ProductSortByPrice;
import com.jbk.Boot.sort.ProductSoryByName;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		boolean isAdded = dao.saveProduct(product);

		return isAdded;
	}

	@Override
	public List<Product> getAllProduct() {

		List<Product> list = dao.getAllProduct();

		return list;
	}

	@Override
	public Product getProductById(int productId) {

		Product product = dao.getProductById(productId);

		return product;
	}

	@Override
	public boolean deleteProductById(int productId) {
		boolean isDeleted = dao.deleteProductById(productId);

		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = dao.updateProduct(product);

		return isUpdated;
	}

	@Override
	public List<Product> sortProduct_Asc(String sortType) {

		List<Product> list = getAllProduct();

		if (sortType.equalsIgnoreCase("productName")) {
			Collections.sort(list, new ProductSoryByName());
		}else if(sortType.equalsIgnoreCase("productPrice")) {
			Collections.sort(list, new ProductSortByPrice());
		}else if(sortType.equalsIgnoreCase("productId")) {
			Collections.sort(list, new ProductSortById());
		}

		return list;
	}

	@Override
	public List<Product> sortProduct_Desc(String sortType) {
		
		List<Product> list=sortProduct_Asc(sortType);
		Collections.reverse(list);
		
		return list;
	}

	@Override
	public Product getMaxPriceProduct_1() {
		Product product = null;
		
		List<Product> list=sortProduct_Desc("productPrice");
		
		if(list!=null) {
			 product=list.get(0);
		}
		
		return product;
	}

	@Override
	public Product getMaxPriceProduct_2() {
		
		List<Product>list=getAllProduct();
		
		Stream<Product> stream=list.stream();
		
		Optional<Product> optional=stream.max(new ProductSortByPrice());
		
		Product product=null;
		if(optional.isPresent()) {
			product=optional.get();
			
		}
		return product;
	}

	@Override
	public double getSumOfProductPrice() {
		
		double sumOfProductPrice =0;
		List<Product> list=getAllProduct();
		
		for (Product product : list) {
			
			sumOfProductPrice = sumOfProductPrice + product.getProductPrice();
		}
		
		
		return sumOfProductPrice;
	}

	@Override
	public int getTotalCountOfProduct() {
		
		List<Product> list=getAllProduct();
		
		int countOfProduct=list.size();
		
		return countOfProduct;
	}
	
	
	
	
	

}
