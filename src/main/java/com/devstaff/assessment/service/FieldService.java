package com.devstaff.assessment.service;

import com.devstaff.assessment.entity.Field;
import com.devstaff.assessment.repository.FieldRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final Logger log = LoggerFactory.getLogger(FieldService.class);

    @Autowired
    private FieldRepository fieldRepository;

    public Field save(Field field) {
        log.debug("Request to save field : {}", field);
        return fieldRepository.save(field);
    }

    public Field findById(Long id) {
        log.debug("Request to get field by id : {}", id);
        Optional<Field> field =  fieldRepository.findById(id);
        return field.orElseGet(Field::new);
    }

    public List<Field> findAll() {
        log.debug("Request to get all field");
        return fieldRepository.findAll();
    }

}
