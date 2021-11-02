package com.pyc.repositories;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pyc.models.Category;
import com.pyc.models.Product;


public interface ProductsRepository extends CrudRepository <Product,Long> {

	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);	
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO products(name,description,price) " +
	"VALUES(?1,?2,?3)", nativeQuery=true)
	void insertNewProduct(String name,String description,BigDecimal price);
	
}
