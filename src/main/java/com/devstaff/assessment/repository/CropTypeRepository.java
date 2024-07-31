package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.CropType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropTypeRepository extends JpaRepository<CropType, Long> {

    @Query("SELECT ct FROM CropType ct WHERE ct.name = ?1")
    CropType findByName(String name);
}
