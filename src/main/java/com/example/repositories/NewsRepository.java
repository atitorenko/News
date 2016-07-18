package com.example.repositories;

import com.example.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "SELECT * FROM news WHERE (:fromDate IS NULL OR date>=:fromDate) AND (:toDate IS NULL OR date<=:toDate)",
            nativeQuery = true)

    List<News> findNewsByDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
