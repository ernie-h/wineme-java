package com.example.myapp.services;

import com.example.myapp.models.Location;
import com.example.myapp.models.Stock;
import com.example.myapp.models.Store;
import com.example.myapp.repositories.StockRepository;
import com.example.myapp.repositories.StoreRepository;
import com.example.myapp.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockService {
	@Autowired
	StockRepository stocks;
	@Autowired
	StoreRepository stores;
	@Autowired
	WineRepository wines;
	
	@PostMapping("/api/store/{storeId}/stock/{wineId}/{count}")
	public Stock createStock(@PathVariable("storeId") int storeId,
							 @PathVariable("wineId") int wineId,
							 @PathVariable("count") int count,
							 @RequestBody Double price) {
		return stocks.save(new Stock(
				stores.findById(storeId).orElse(null),
				wines.findById(wineId).orElse(null),
				count,
				price
		));
	}
	
	@DeleteMapping("/api/stock/{stockId}")
	public void deleteStock(@PathVariable("stockId") int stockId) { stocks.deleteById(stockId); }
	
	@PutMapping("api/stock/{stockId}")
	public Stock updateStock(@PathVariable("stockId") int stockId, @RequestBody Stock updateTo) {
		Stock res = stocks.findById(stockId).orElse(null);
		if (res != null) {
			res.setCount(updateTo.getCount());
			res.setPrice(updateTo.getPrice());
		}
		return res;
	}
	
	@GetMapping("/api/wine/nearby")
	public List<Stock> getNearby(@RequestBody Location userLocation) {
		List<Store> nearby = (List<Store>) stores.findStoresNear(userLocation.getLongitude(), userLocation.getLatitude(), 0.075);
		return (List<Stock>) stocks.findStocksFromStores(nearby);
	}
	
	@GetMapping("/api/wine/stock")
	public List<Stock> getInStock() { return (List<Stock>) stocks.findAllInStock(); }
	
	@GetMapping("/api/stock")
	public List<Stock> findAllStocks() { return (List<Stock>) stocks.findAll(); }
	
	@GetMapping("/api/store/{storeId}/stock")
	public List<Stock> findStockAtStore(@PathVariable("storeId") int storeId) { return (List<Stock>) stocks.findByStoreId(storeId); }
}
