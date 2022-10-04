package com.jbk.Boot.sort;

import java.util.Comparator;

import com.jbk.Boot.ModelClass.Product;

public class ProductSoryByName implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {

		return p1.getProductName().compareTo(p2.getProductName());
	}

}
