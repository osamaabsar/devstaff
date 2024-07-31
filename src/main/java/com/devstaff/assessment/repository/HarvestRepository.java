package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestRepository  extends JpaRepository<Harvest, Long> {

    @Query("SELECT h FROM Harvest h WHERE h.season = ?1")
    List<Harvest> getHarvestBySeason(Season season);

    @Query("SELECT h FROM Harvest h WHERE h.cropType.name = ?1")
    List<Harvest> getHarvestByCrop(String season);

    @Query("SELECT h FROM Harvest h WHERE h.field.id = ?1")
    List<Harvest> getHarvestByField(Long id);
}
