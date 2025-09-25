package com.agriculture.project.repository;

import com.agriculture.project.model.TaskActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TaskActivityRepository extends JpaRepository<TaskActivity, Long> {

    List<TaskActivity> findByLandDetailsId(Long landId);
    List<TaskActivity> findByTaskDate(LocalDate date);
}
