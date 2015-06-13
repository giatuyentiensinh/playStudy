package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import play.data.validation.Constraints.Required;
import play.mvc.PathBindable;

public class Product implements PathBindable<Product> {

	@Required
	public String ean;
	@Required
	public String name;
	public String description;

	public List<Tag> tags = new LinkedList<Tag>();
	private static List<Product> products;

	static {
		products = new ArrayList<Product>();
		products.add(new Product("1111111111111", "Paperclips 1",
				"Paperclips description 1"));
		products.add(new Product("2222222222222", "Paperclips 2",
				"Paperclips description 2"));
		products.add(new Product("3333333333333", "Paperclips 3",
				"Paperclips description 3"));
		products.add(new Product("4444444444444", "Paperclips 4",
				"Paperclips description 4"));
		products.add(new Product("5555555555555", "Paperclips 5",
				"Paperclips description 5"));
	}

	public static List<Product> findAll() {
		return new ArrayList<Product>(products);
	}

	public static Product findByEan(String ean) {
		for (Product candidate : products) {
			if (candidate.ean.equals(ean))
				return candidate;
		}
		return null;
	}

	public static List<Product> findByName(String term) {
		final List<Product> results = new ArrayList<Product>();
		for (Product candidate : products) {
			if (candidate.name.toLowerCase().contains(term.toLowerCase()))
				results.add(candidate);
		}
		return results;
	}

	public static boolean remove(Product product) {
		return products.remove(product);
	}

	public void save() {
		products.remove(findByEan(this.ean));
		products.add(this);
	}

	public Product() {
		super();
	}

	public Product(String ean, String name, String description) {
		super();
		this.ean = ean;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", ean, name);
	}
	

	@Override
	public Product bind(String key, String value) {
		return findByEan(value);
	}
	

	@Override
	public String javascriptUnbind() {
		return ean;
	}
	

	@Override
	public String unbind(String key) {
		return ean;
	}
}
