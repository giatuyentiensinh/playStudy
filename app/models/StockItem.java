package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

@Entity
public class StockItem extends Model{

	@Id
	public Long id;
	public Warehouse warehouse;
	@ManyToOne
	public Product product;
	public Long quantity;

	@Override
	public String toString() {
		return String.format("%d %s", quantity, product);
	}

}
