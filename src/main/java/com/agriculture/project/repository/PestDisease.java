package com.agriculture.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PestDisease extends JpaRepository<PestDisease, Long> {
}
