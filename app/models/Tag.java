package models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	public Long id;
	public String name;
	@ManyToMany(mappedBy = "tags")
	public List<Product> products;

	private static List<Tag> tags = new LinkedList<Tag>();

	public static Tag findById(Long id) {
		for (Tag tag : tags)
			if (tag.id == id)
				return tag;
		return null;
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
