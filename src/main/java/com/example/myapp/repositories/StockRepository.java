package com.example.myapp.repositories;

import com.example.myapp.models.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer> {
}
