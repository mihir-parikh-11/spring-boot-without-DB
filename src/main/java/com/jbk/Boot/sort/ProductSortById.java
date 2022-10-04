package com.jbk.Boot.sort;

import java.util.Comparator;

import com.jbk.Boot.ModelClass.Product;

public class ProductSortById implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		
		if(p1.getProductId()==p2.getProductId()) {
			return 0;
		}else if(p1.getProductId()>p2.getProductId()) {
			return 1;
		}else {
			return -1;		}
		
	}
	

}
