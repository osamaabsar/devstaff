package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.entity.Plantation;
import com.devstaff.assessment.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantationRepository extends JpaRepository<Plantation, Long> {

    @Query("SELECT p FROM Plantation p WHERE p.season = ?1")
    List<Plantation> getPlantationBySeason(Season season);

    @Query("SELECT p FROM Plantation p WHERE p.field.id = ?1")
    List<Plantation> getPlantationByField(Long id);
}
