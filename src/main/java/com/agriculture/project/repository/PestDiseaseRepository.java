package com.agriculture.project.repository;

import com.agriculture.project.model.PestDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PestDiseaseRepository extends JpaRepository<PestDisease, Long> {

    List<PestDisease> findByCropId(Long cropId);
}
