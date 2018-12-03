package com.example.myapp.services;

import com.example.myapp.models.Stock;
import com.example.myapp.repositories.StockRepository;
import com.example.myapp.repositories.StoreRepository;
import com.example.myapp.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
							 @PathVariable("count") int count) {
		return stocks.save(new Stock(
				stores.findById(storeId).orElse(null),
				wines.findById(wineId).orElse(null),
				count
		));
	}
}
