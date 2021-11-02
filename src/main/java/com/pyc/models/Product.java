package com.pyc.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long product_id;
	
	@NotNull
	@Size( min = 2, max = 50)
	private String name;
	
	@NotNull
	@Size( min = 2, max = 500)
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	        )
	private List<Category> categories;

	public Product() {}
	
	public Product(String name, String description, BigDecimal price) 
	{
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product(Long product_id, String name, String description, BigDecimal price, List<Category> categories) 
	{
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
	}
	
	
//------------------------------------Getter y Setters----------------------------
	
	
	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
}
