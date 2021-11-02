package com.pyc.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import com.pyc.models.Category;
import com.pyc.models.Product;
import com.pyc.repositories.AssociationRepository;
import com.pyc.repositories.CategoriesRepository;
import com.pyc.repositories.ProductsRepository;

@Service
public class AppService {

	private final CategoriesRepository cr;
	private final ProductsRepository pr;
	private final AssociationRepository ar;
	
	public AppService(CategoriesRepository cr, ProductsRepository pr, AssociationRepository ar) {
		this.cr = cr;
		this.pr = pr;
		this.ar = ar;
	}
	
//----------------------------------------Products------------------------------
	public List<Product> findallPro() {
		return pr.findAll();
	}
	
	public void addnewproduct(String name,String description,BigDecimal price) {
		pr.insertNewProduct(name,description,price);
	}
	
	public List<Product> findProductsNotInCategory(Category category) {
		return pr.findByCategoriesNotContains(category);
	}
	
	public Product getProduct(Long id) {
		return pr.findById(id).orElse(null);
	}
	

//----------------------------------------Categories------------------------------

	public List<Category> findallCat() {
		return cr.findAll();
	}
	
	public void addnewcategory(String name) {
		cr.insertNewCategory(name);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cr.findByProductsNotContains(product);
	}

	public Category getCategory(Long id) {
		return cr.findById(id).orElse(null);
	}
	
//----------------------------------------Associations------------------------------

	public void linktables(Long pro_id,Long cat_id) {
		ar.linkProAndCat(pro_id, cat_id);
	}
}
