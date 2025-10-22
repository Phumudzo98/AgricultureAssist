package com.agriculture.project.repository;


import com.agriculture.project.model.Farm;
import com.agriculture.project.model.LandDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandDetailsRepository extends JpaRepository<LandDetails, Long> {

    List<LandDetails> findByFarm(Farm farm);
}
