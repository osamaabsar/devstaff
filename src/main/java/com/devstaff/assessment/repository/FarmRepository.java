package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query("SELECT f FROM Farm f WHERE f.name = ?1")
    Farm findByName(String name);

}
