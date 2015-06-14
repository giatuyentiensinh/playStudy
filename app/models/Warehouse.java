package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;

@Entity
public class Warehouse extends Model{

	@Id
	public Long id;
	public String name;
	@OneToOne
	public Address address;
	@OneToMany(mappedBy = "warehouse")
	public List<StockItem> stock = new ArrayList<StockItem>();

	@Override
	public String toString() {
		return name;
	}
}
