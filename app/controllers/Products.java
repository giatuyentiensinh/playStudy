package controllers;

import java.util.List;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller{

	public Result list() {
		List<Product> product = Product.findAll();
		return ok(views.html.list.render(product));
	}
	
	public Result newProduct() {
		return ok();
	}
	
	public Result details(String ean) {
		return ok();
	}
	
	public Result save() {
		return ok();
	}
}
