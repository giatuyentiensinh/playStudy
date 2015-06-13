package models;

public class Product {

	public String ean;
	public String name;
	public String description;

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
}
