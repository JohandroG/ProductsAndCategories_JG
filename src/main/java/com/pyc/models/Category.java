package com.pyc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long category_id;
	
	@NotNull
	@Size( min = 2, max = 50)
	private String category;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "category_id"), 
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	        )
	private List<Product> products;
	
	public Category() {}
	
	public Category (String category) 
	{
		this.category = category;
	}
	
	public Category (String category, List<Product> products) 
	{
		this.category = category;
		this.products = products;
	}
	
	public Category (Long category_id, String category, List<Product> products) 
	{
		this.category_id = category_id;
		this.category = category;
		this.products = products;
	}
	
//------------------------------------Getter y Setters----------------------------


	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	

	
	
	
}
