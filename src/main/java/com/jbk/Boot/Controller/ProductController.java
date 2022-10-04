package com.jbk.Boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Boot.ModelClass.Product;
import com.jbk.Boot.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping(value ="welcome")
	public String welcome(){
		return "Welcome to our project";
	}

	@PostMapping(value = "/saveProduct")
	public boolean saveProduct(@RequestBody Product product) {
		boolean isAdded = service.saveProduct(product);

		return isAdded;
	}
	
	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct(){
		List<Product>list=service.getAllProduct();
		
		return list;
	}
	
	// method-1 get single product
	@GetMapping(value = "/getProductById_req")
	public Product getProductById_req(@RequestParam int productId) {
		Product product=service.getProductById(productId);
		
		return product;
	}
	
	// method-2 get single product
	@GetMapping(value = "/getProductById_path/{productId}")
	public Product getProductById_path(@PathVariable int productId) {
		Product product=service.getProductById(productId);
		
		return product;
	}
	
	//method-1 delete product
	@DeleteMapping(value = "deleteProductById_req")
	public boolean deleteProductById_req(@RequestParam int productId) {
		boolean isDeleted=service.deleteProductById(productId);
		
		return isDeleted;
	}
	
	//method-2 delete product
	@DeleteMapping(value = "deleteProductById_path/{productId}")
	public boolean deleteProductById_path(@PathVariable int productId ) {
		boolean isDeleted=service.deleteProductById(productId);
		
		return isDeleted;
	}
	
	@PutMapping(value = "updateProduct")
	public boolean updateProduct(@RequestBody Product product) {
		boolean isUpdated=service.updateProduct(product);
		
		return isUpdated;
	}
	
	@GetMapping(value = "/sortProduct_Asc")
	public List<Product> sortProduct_Asc (@RequestParam String sortType){
		
		List<Product> list=service.sortProduct_Asc(sortType);
		
		return list;
	}
	
	@GetMapping(value = "/sortProduct_Desc")
	public List<Product> sortProduct_Desc (@RequestParam String sortType){
		
		List<Product> list=service.sortProduct_Desc(sortType);
		
		return list;
	}
	
	@GetMapping(value = "/getMaxPriceProduct")
	public Product getMaxPriceProduct () {
		
	//	Product product=service.getMaxPriceProduct_1();
		
		Product product=service.getMaxPriceProduct_2();
		
		return product;
	}
	
	@GetMapping(value = "/getSumOfProductPrice")
	public double getSumOfProductPrice() {
		double sumOfProductPrice=service.getSumOfProductPrice();
		
		return sumOfProductPrice;
	}
	
	@GetMapping(value = "/getTotalCountOfProduct")
	public int getTotalCountOfProduct() {
		int countOfProduct=service.getTotalCountOfProduct();
		
		return countOfProduct;
	}


}
