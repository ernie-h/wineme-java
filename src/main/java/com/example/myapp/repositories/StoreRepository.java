package com.example.myapp.repositories;

import com.example.myapp.models.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends CrudRepository<Store, Integer> {
	@Query("SELECT s " +
			"FROM Store s " +
			"WHERE (s.longitude BETWEEN :longitude - :threshold AND :longitude + :threshold) " +
			"AND (s.latitude BETWEEN :latitude - :threshold AND :latitude + :threshold)")
	Iterable<Store> findStoresNear(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("threshold") double threshold);
}
