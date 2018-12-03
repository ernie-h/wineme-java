package com.example.myapp.repositories;

import com.example.myapp.models.Stock;
import com.example.myapp.models.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	@Query("SELECT s FROM Stock s WHERE s.store IN :stores")
	Iterable<Stock> findStocksFromStores(@Param("stores") List<Store> stores);
	
	@Query("SELECT s FROM Stock s WHERE s.count > 0")
	Iterable<Stock> findAllInStock();
	
	@Query("SELECT s FROM Stock s WHERE s.store.id=:storeId")
	Iterable<Stock> findByStoreId(@Param("storeId") int storeId);
}
