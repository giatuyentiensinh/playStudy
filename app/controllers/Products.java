package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.Product;
import models.StockItem;
import models.Tag;
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
	
	public Result details(Product product) {
		if(product == null) 
			return notFound(String.format("Product %s does not exist", product.ean));
		Form<Product> filledForm = productForm.fill(product);
		return ok(views.html.details.render(filledForm));
	}
	
	public Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()) {
			flash("error", "Please correct the from below.");
			return badRequest(views.html.details.render(boundForm));
		}
		Product product = boundForm.get();
		List<Tag> tags = new ArrayList<Tag>();
		for (Tag tag : product.tags)
			tags.add(Tag.findById(tag.id));
		product.tags = tags;
		StockItem stockItem = new StockItem();
		stockItem.product = product;
		stockItem.quantity = 0L;
		product.save();
		stockItem.save();
		flash("success", String.format("Successfully added product %s", product));
		return redirect("/products/");
	}
	
	public Result delete(String ean) {
		Product product = Product.findByEan(ean);
		if(product == null) 
			return notFound(String.format("Product %s does not exist", ean));
		product.delete();
		return redirect("/products/");
	}
}
