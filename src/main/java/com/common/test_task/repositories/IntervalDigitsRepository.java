package com.common.test_task.repositories;

import com.common.test_task.models.IntervalDigits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalDigitsRepository extends JpaRepository<IntervalDigits, Long> {
    // sql-скрипт для выборки минимального интервала
    @Query(value = "SELECT * FROM digit_intervals ORDER BY _start, _end LIMIT 1;", nativeQuery = true)
    IntervalDigits findMin();
}
