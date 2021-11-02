package com.pyc.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.pyc.models.Category;
import com.pyc.models.Product;


public interface CategoriesRepository extends CrudRepository <Category,Long> {

	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	void save(String name);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO categories(category) " +
	"VALUES(?1)", nativeQuery=true)
	void insertNewCategory(String name);
}
