package com.devstaff.assessment.repository;

import com.devstaff.assessment.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HarvestTest {
    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private CropTypeRepository cropTypeRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Test
    public void testHarvest() {
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

        Harvest harvested = new Harvest();
        harvested.setCropType(savedCropType);
        harvested.setField(savedField);
        harvested.setSeason(Season.SUMMER);
        harvested.setActualProductAmount(500.0);

        Harvest savedHarvest = harvestRepository.save(harvested);

        assertThat(savedHarvest.getId()).isNotNull();
        assertThat(savedHarvest.getCropType()).isEqualTo(savedCropType);
        assertThat(savedHarvest.getField()).isEqualTo(savedField);
        assertThat(savedHarvest.getSeason()).isEqualTo(Season.SUMMER);
        assertThat(savedHarvest.getActualProductAmount()).isEqualTo(500.0);

        Harvest foundHarvest = harvestRepository.findById(savedHarvest.getId()).orElse(null);

        assertThat(foundHarvest).isNotNull();
        assertThat(foundHarvest.getCropType()).isEqualTo(savedCropType);
        assertThat(foundHarvest.getField()).isEqualTo(savedField);
        assertThat(foundHarvest.getSeason()).isEqualTo(Season.SUMMER);
        assertThat(foundHarvest.getActualProductAmount()).isEqualTo(500.0);
    }
}
