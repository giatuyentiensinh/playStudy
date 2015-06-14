package models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.avaje.ebean.Model.Finder;

@Entity
public class Tag {

	@Id
	public Long id;
	public String name;
	@ManyToMany(mappedBy = "tags")
	public List<Product> products;

	public static Finder<Long, Tag> find = new Finder<Long, Tag>(Long.class,
			Tag.class);

	public static Tag findById(Long id) {
		return find.byId(id);
	}

	public Tag() {

	}

	public Tag(Long id, String name, Collection<Product> products) {
		super();
		this.id = id;
		this.name = name;
		for (Product product : products)
			product.tags.add(this);
	}

}
