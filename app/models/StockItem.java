package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

@Entity
public class StockItem extends Model {

	@Id
	public Long id;
	@ManyToOne
	public Warehouse warehouse;
	@ManyToOne
	public Product product;
	public Long quantity;

	public static Finder<Long, StockItem> find = new Finder<Long, StockItem>(
			Long.class, StockItem.class);

	@Override
	public String toString() {
		return String.format("%d %s x product %s", id, quantity,
				product == null ? null : product.id);
	}

}
