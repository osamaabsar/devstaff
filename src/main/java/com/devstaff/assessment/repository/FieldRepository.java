package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

    @Query("SELECT f FROM Field f WHERE id = ?1")
    Field getFieldById(Long id);
}
