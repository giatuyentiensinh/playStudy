package controllers;

import java.util.List;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Products extends Controller{

	private static final Form<Product> productForm = Form.form(Product.class);
	
	public Result list() {
		List<Product> product = Product.findAll();
		return ok(views.html.list.render(product));
	}
	
	public Result newProduct() {
		return ok(views.html.details.render(productForm));
	}
	
	public Result details(String ean) {
		return ok();
	}
	
	public Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		Product product = boundForm.get();
		product.save();
		return ok(String.format("Save product %s", product));
	}
}
