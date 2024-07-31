package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlantationTest {

    @Autowired
    private PlantationRepository plantationRepository;

    @Autowired
    private CropTypeRepository cropTypeRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Test
    public void testPlantation() {
        CropType cropType = new CropType();
        cropType.setName("Wheat");
        CropType savedCropType = cropTypeRepository.save(cropType);

        Farm farm = new Farm();
        farm.setName("Devstaff Farm");
        Farm savedFarm = farmRepository.save(farm);

        Field field = new Field();
        field.setFarm(savedFarm);
        field.setName("Devstaff North Field");
        Field savedField = fieldRepository.save(field);

        Plantation plantation = new Plantation();
        plantation.setCropType(savedCropType);
        plantation.setField(savedField);
        plantation.setSeason(Season.SPRING);
        plantation.setExpectedProductAmount(200.0);
        Plantation savedPlantation = plantationRepository.save(plantation);

        assertThat(savedPlantation.getId()).isNotNull();
        assertThat(savedPlantation.getCropType()).isEqualTo(savedCropType);
        assertThat(savedPlantation.getField()).isEqualTo(savedField);
        assertThat(savedPlantation.getSeason()).isEqualTo(Season.SPRING);
        assertThat(savedPlantation.getExpectedProductAmount()).isEqualTo(200.0);

        Plantation foundPlantation = plantationRepository.findById(savedPlantation.getId())
                .orElse(null);

        assertThat(foundPlantation).isNotNull();
        assertThat(foundPlantation.getCropType()).isEqualTo(savedCropType);
        assertThat(foundPlantation.getField()).isEqualTo(savedField);
        assertThat(foundPlantation.getSeason()).isEqualTo(Season.SPRING);
        assertThat(foundPlantation.getExpectedProductAmount()).isEqualTo(200.0);
    }
}
