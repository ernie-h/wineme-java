package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.myapp.models.Wine;

public interface WineRepository extends CrudRepository<Wine, Integer> {
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%dry%'" +
        "OR w.description LIKE '%depth%' OR w.description LIKE '%strong%'" +
        "OR w.description LIKE '%spicy%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%depth%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%strong%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%spicy%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%dry%' THEN 1 ELSE 0 END " +
        "DESC"
        )
	List<Wine> findINTJ();

}
//"ORDER BY DESC"
 // "IF(w.description LIKE '%dry%',1,0)+ " +
        // "IF(w.description LIKE '%depth%',1,0)+ " +
        // "IF(w.description LIKE '%strong%',1,0)+ " +
        // "IF(w.description LIKE '%spicy%',1,0) DESC"
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