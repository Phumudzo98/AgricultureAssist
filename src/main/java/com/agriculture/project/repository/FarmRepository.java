package com.agriculture.project.repository;


import com.agriculture.project.model.Farm;
import com.agriculture.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    Optional<Farm> findById(Long id);
    List<Farm> findByUser(User user);
    List<Farm> findByUserAndFarmNameContainingIgnoreCase(User user, String farmName);

}
