package com.agriculture.project.repository;


import com.agriculture.project.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    Optional<Farm> findById(Long id);
}
