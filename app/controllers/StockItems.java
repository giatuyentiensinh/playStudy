package controllers;

import java.util.List;

import models.StockItem;
import play.mvc.Controller;
import play.mvc.Result;

public class StockItems extends Controller {

	public Result index() {
		List<StockItem> items = StockItem.find.findList();
		return ok(items.toString());
	}

	public Result greater() {
		List<StockItem> items = StockItem.find.where().ge("quantity", 300)
				.findList();
		return ok(items.toString());
	}

	public Result odergt() {
		List<StockItem> items = StockItem.find.where().ge("quantity", 300)
				.orderBy("quantity").findList();
		return ok(items.toString());
	}
}
