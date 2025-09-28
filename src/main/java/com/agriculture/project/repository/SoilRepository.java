package com.agriculture.project.repository;

import com.agriculture.project.model.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Long> {
    List<Soil> findByLandDetailsId(Long landId);
}
