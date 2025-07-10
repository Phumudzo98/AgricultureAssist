package com.agriculture.project.repository;


import com.agriculture.project.model.LandDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandDetailsRepository extends JpaRepository<LandDetails, Long> {
}
