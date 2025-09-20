package com.agriculture.project.repository;

import com.agriculture.project.model.TaskActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskActivityRepository extends JpaRepository<TaskActivity, Long> {
}
