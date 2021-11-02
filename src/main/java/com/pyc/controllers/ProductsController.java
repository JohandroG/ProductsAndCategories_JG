package com.pyc.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pyc.models.Category;
import com.pyc.models.Product;
import com.pyc.services.AppService;

@Controller
public class ProductsController {

	private final AppService as;
	
	public ProductsController(AppService as) {
		this.as = as;
	}
//----------------------------------------------------------------------
	
	@RequestMapping( value="/product/new", method = RequestMethod.GET )
	public String displayaddcat(Model model) {
		
		List<Product> proinfo = as.findallPro();
		model.addAttribute("prodInfo", proinfo);
		return "newpro.jsp";
	}
	
	
	@RequestMapping( value="/product/insert", method = RequestMethod.POST )
	public String newpro(@RequestParam(value="name") String name,
			@RequestParam(value="desc") String description,
			@RequestParam(value="price") BigDecimal price) {
		
		as.addnewproduct(name,description,price);
		
		return "redirect:/product/new";
	}
	
	@RequestMapping( value="/add/pro/{id}", method = RequestMethod.GET )
	public String editpro(@PathVariable("id") Long id, Model model) {
		
		Product current = as.getProduct(id);
		List<Category> notin = as.findCategoriesNotInProduct(current);
				
		model.addAttribute("current", current);
		model.addAttribute("CatList", notin);
		return "addpro.jsp";
	}
	
	@RequestMapping( value="/add/new/cat/{id}", method = RequestMethod.POST )
	public String addcat(@PathVariable("id") Long prod_id, @RequestParam(value="cat") Long cat_id) {
		
		as.linktables(prod_id, cat_id);
		return "redirect:/add/pro/" + prod_id;
	}
	
}
