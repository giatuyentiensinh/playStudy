package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Warehouse {

	@Id
	public Long id;
	public String name;
	@OneToMany(mappedBy = "warehouse")
	public List<StockItem> stock = new ArrayList<StockItem>();

	@Override
	public String toString() {
		return name;
	}
}
