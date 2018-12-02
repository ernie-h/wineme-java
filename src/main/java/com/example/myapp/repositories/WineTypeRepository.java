package com.example.myapp.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Store;

public interface WineTypeRepository extends CrudRepository<Store, Integer> {}
