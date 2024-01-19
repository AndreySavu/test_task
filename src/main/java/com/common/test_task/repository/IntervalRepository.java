package com.common.test_task.repository;
import com.common.test_task.model.Interval;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntervalRepository extends JpaRepository<Interval, Long> {
    // List<Tutorial> findByPublished(boolean published);
    // List<Tutorial> findByTitleContaining(String title);
}