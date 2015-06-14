package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.mvc.PathBindable;

import com.avaje.ebean.Model;

@Entity
public class Product extends Model implements PathBindable<Product> {

	@Id
	public Long id;

	@Required
	public String ean;
	@Required
	public String name;
	public String description;
	@OneToMany(mappedBy = "product")
	public List<StockItem> stockItems;
	public byte[] picture;
	@ManyToMany
	public List<Tag> tags;

	private static List<Product> products;
	public static Finder<Long, Product> find = new Finder<Long, Product>(
			Long.class, Product.class);

	public static List<Product> findAll() {
		return find.all();
	}

	public static Product findByEan(String ean) {
		return find.where().eq("ean", ean).findUnique();
	}

	public static List<Product> findByName(String term) {
		final List<Product> results = new ArrayList<Product>();
		for (Product candidate : products)
			if (candidate.name.toLowerCase().contains(term.toLowerCase()))
				results.add(candidate);
		return results;
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
