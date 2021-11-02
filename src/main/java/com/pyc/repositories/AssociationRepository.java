package com.pyc.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pyc.models.Association;

public interface AssociationRepository extends CrudRepository <Association,Long> {
	List<Association> findAll();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO associations(product_id,category_id) " +
	"VALUES(?1,?2)", nativeQuery=true)
	void linkProAndCat(Long pro_id,Long cat_id);
	
}
