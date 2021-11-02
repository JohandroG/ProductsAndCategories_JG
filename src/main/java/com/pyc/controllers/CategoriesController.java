package com.pyc.controllers;

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
public class CategoriesController {

	
	private final AppService as;
	
	public CategoriesController(AppService as) {
		this.as = as;
	}

//----------------------------------------------------------------------

	@RequestMapping( value="/", method = RequestMethod.GET )
	public String home() {
		return "redirect:/product/new";
	}
	
	@RequestMapping( value="/category/new", method = RequestMethod.GET )
	public String displayaddcat(Model model) {
		
		List<Category> catinfo = as.findallCat();
		model.addAttribute("CatInfo", catinfo);
		return "newcat.jsp";
	}

	
	@RequestMapping( value="/category/insert", method = RequestMethod.POST )
	public String newcat(@RequestParam(value="name") String name) {
		
		as.addnewcategory(name);
		
		return "redirect:/category/new";
	}
	
	@RequestMapping( value="/add/cat/{id}", method = RequestMethod.GET )
	public String editpro(@PathVariable("id") Long id, Model model) {
		
		Category current = as.getCategory(id);
		List<Product> notin = as.findProductsNotInCategory(current);
				
		model.addAttribute("current", current);
		model.addAttribute("ProList", notin);
		return "addcat.jsp";
	}
	
	@RequestMapping( value="/add/new/pro/{id}", method = RequestMethod.POST )
	public String addcat(@PathVariable("id") Long cat_id, @RequestParam(value="prod") Long prod_id) {
		
		as.linktables(prod_id, cat_id);
		return "redirect:/add/cat/" + cat_id;
	}
	
}
