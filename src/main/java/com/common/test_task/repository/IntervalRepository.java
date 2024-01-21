package com.common.test_task.repository;

import com.common.test_task.model.IntervalDigits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntervalRepository extends JpaRepository<IntervalDigits, Long> {
    @Query(value = "SELECT * FROM intervall ORDER BY startt LIMIT 1;", nativeQuery = true)
    List<Integer> findMin();
}
