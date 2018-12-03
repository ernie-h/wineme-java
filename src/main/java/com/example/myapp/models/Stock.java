package com.example.myapp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Stock")
@Table(name = "store_stocks_wine")
public class Stock {
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "wine_id", nullable = false)
	private Wine wine;
	
	@Column(name = "stock_count", nullable = false)
	private int count;
	
	@Column(name = "store_price", nullable = true)
	private Double price;
	
	public Stock() {}
	
	public Stock(Store store, Wine wine, int count, Double price) {
		this.store = store;
		this.wine = wine;
		this.count = count;
		this.price = price;
		this.id = Objects.hash(this.store.getStoreId(), this.wine.getWineId());
	}
	
	public Stock(Store store, Wine wine, int count) {
		this(store, wine, count, null);
	}
	
	public final int getId() { return this.id; }
	public final void setId(int id) { this.id = id; }
	
	public final Store getStore() { return this.store; }
	public final void setStore(Store store) { this.store = store; }
	
	public final Wine getWine() { return this.wine; }
	public final void setWine(Wine wine) { this.wine = wine; }
	
	public final int getCount() { return this.count; }
	public final void setCount(int count) { this.count = count; }
	
	public final Double getPrice() { return this.price; }
	public final void setPrice(Double price) { this.price = price; }
}
