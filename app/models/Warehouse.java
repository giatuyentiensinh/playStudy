package models;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	public String name;
	public List<StockItem> stock = new ArrayList<StockItem>();
	
	@Override
	public String toString() {
		return name;
	}
}
