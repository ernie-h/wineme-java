package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.myapp.models.Wine;

public interface WineRepository extends CrudRepository<Wine, Integer> {
    @Query("SELECT w FROM Wine w")
	List<Wine> findPersonalityWines(@Param("personality") String personality);

}
// SELECT * FROM wine WHERE
// description LIKE '%dry%'
// OR description LIKE '%depth%'
// OR description LIKE '%strong%'
// OR description LIKE '%spicy%'
// ORDER BY
// IF(description LIKE '%dry%',1,0)+
// IF(description LIKE '%depth%',1,0)+
// IF(description LIKE '%strong%',1,0)+ 
// IF(description LIKE '%spicy%',1,0) DESC LIMIT 10;