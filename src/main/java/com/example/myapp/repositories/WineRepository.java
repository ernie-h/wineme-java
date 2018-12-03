package com.example.myapp.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
    List<Wine> findINTJ(Pageable pageable);

        @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%oak%'" +
        "OR w.description LIKE '%cherry%' OR w.description LIKE '%cigar%'" +
        "OR w.description LIKE '%astringent%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%oak%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%cherry%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%cigar%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%astringent%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findINTP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%coffee%'" +
        "OR w.description LIKE '%plum%' OR w.description LIKE '%chocolate%'" +
        "OR w.description LIKE '%tann%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%coffee%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%plum%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%chocolate%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%tann%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findENTJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%leather%'" +
        "OR w.description LIKE '%wood%' OR w.description LIKE '%plum%'" +
        "OR w.description LIKE '%pepper%' OR w.description LIKE '%spicy%'" +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%leather%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%wood%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%plum%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%pepper%' THEN 1 ELSE 0 END + " +
        "CASE WHEN w.description LIKE '%spicy%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findENTP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%smooth%'" +
        "OR w.description LIKE '%herb%' OR w.description LIKE '%honey%'" +
        "OR w.description LIKE '%semidry%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%smooth%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%herb%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%honey%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%semidry%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findINFJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%berry%'" +
        "OR w.description LIKE '%orange%' OR w.description LIKE '%soft%'" +
        "OR w.description LIKE '%vanilla%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%berry%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%orange%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%soft%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%vanilla%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findINFP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%citrus%'" +
        "OR w.description LIKE '%juicy%' OR w.description LIKE '%crisp%'" +
        "OR w.description LIKE '%fruit%' OR w.description LIKE '%tropical%'" +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%citrus%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%juicy%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%crisp%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%fruit%' THEN 1 ELSE 0 END + " +
        "CASE WHEN w.description LIKE '%tropical%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findENFJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%peach%'" +
        "OR w.description LIKE '%flower%' OR w.description LIKE '%apple%'" +
        "OR w.description LIKE '%light%' OR w.description NOT LIKE '%blackberry%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%peach%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%flower%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%apple%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%light%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description NOT LIKE '%blackberry%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findENFP(Pageable pageable);

    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%herb%'" +
        "OR w.description LIKE '%tart%' OR w.description LIKE '%brisk%'" +
        "OR w.description LIKE '%almond%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%herb%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%tart%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%brisk%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%almond%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findISTJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%honey%'" +
        "OR w.description LIKE '%vanilla%' OR w.description LIKE '%caramel%'" +
        "OR w.description LIKE '%soft%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%honey%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%vanilla%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%caramel%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%soft%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findISFJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%earthy%'" +
        "OR w.description LIKE '%cherry%' OR w.description LIKE '%ripe%'" +
        "OR w.description LIKE '%medium%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%earthy%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%cherry%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%ripe%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%medium%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findESTJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%cream%'" +
        "OR w.description LIKE '%orange%' OR w.description LIKE '%toasted%'" +
        "OR w.description LIKE '%berry%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%cream%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%orange%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%toasted%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%berry%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findESFJ(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%firm%'" +
        "OR w.description LIKE '%medium%' OR w.description LIKE '%herb%'" +
        "OR w.description LIKE '%chocolate%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%firm%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%medium%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%herb%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%chocolate%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findISTP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%tart%'" +
        "OR w.description LIKE '%zesty%' OR w.description LIKE '%bright%'" +
        "OR w.description LIKE '%acid%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%tart%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%zesty%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%bright%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%acid%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findISFP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%cherry%'" +
        "OR w.description LIKE '%sage%' OR w.description LIKE '%sugar%'" +
        "OR w.description LIKE '%cardamom%' OR w.description LIKE '%ripe%'" +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%cherry%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%sage%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%sugar%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%cardamom%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%ripe%' THEN 1 ELSE 0 END " +
        "DESC"
        )
    List<Wine> findESTP(Pageable pageable);
    
    @Query(
        "SELECT w FROM Wine w WHERE w.description LIKE '%light%'" +
        "OR w.description LIKE '%pineapple%' OR w.description LIKE '%cand%'" +
        "OR w.description LIKE '%apricot%' " +
        "ORDER BY " +
        "CASE WHEN w.description LIKE '%light%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%pineapple%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%cand%' THEN 1 ELSE 0 END +" +
        "CASE WHEN w.description LIKE '%apricot%' THEN 1 ELSE 0 END " +
        "DESC"
        )
	List<Wine> findESFP(Pageable pageable);

}