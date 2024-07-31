package com.devstaff.assessment.service;

import com.devstaff.assessment.entity.CropType;
import com.devstaff.assessment.repository.CropTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropTypeService {

    private final Logger log = LoggerFactory.getLogger(CropTypeService.class);

    @Autowired
    private CropTypeRepository cropTypeRepository;

    public CropType save(CropType cropType) {
        log.debug("Request to save cropType : {}", cropType);
        return cropTypeRepository.save(cropType);
    }

    public CropType findById(Long id) {
        log.debug("Request to get cropType by id : {}", id);
        Optional<CropType> cropType =  cropTypeRepository.findById(id);
        return cropType.orElseGet(CropType::new);
    }

    public CropType findByName(String name) {
        log.debug("Request to get cropType by name : {}", name);
        return cropTypeRepository.findByName(name);
    }

    public List<CropType> findAll() {
        log.debug("Request to get all cropType");
        return cropTypeRepository.findAll();
    }
}
