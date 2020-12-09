package com.prominentpixel.knowledgebuilder.mapper;

import com.prominentpixel.knowledgebuilder.domain.KBCategoryMaster;
import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KBCategoryMasterMapper {
    public List<KBCategoryMasterDTO> getKBCategoryMasterDTOs(List<KBCategoryMaster> kbCategoryMasters) {
        List<KBCategoryMasterDTO> categoryMasterDTOS = new ArrayList<>();
        for (KBCategoryMaster kbCategoryMaster : kbCategoryMasters) {
            KBCategoryMasterDTO categoryMasterDTO = getKBCategoryMasterDTO(kbCategoryMaster);
            categoryMasterDTOS.add(categoryMasterDTO);
        }
        return categoryMasterDTOS;
    }

    public KBCategoryMasterDTO getKBCategoryMasterDTO(KBCategoryMaster kbCategoryMasters) {
        KBCategoryMasterDTO categoryMasterDTO = new KBCategoryMasterDTO();
        categoryMasterDTO.setId(kbCategoryMasters.getId());
        categoryMasterDTO.setName(kbCategoryMasters.getName());
        categoryMasterDTO.setStatus(kbCategoryMasters.getStatus());
        categoryMasterDTO.setCreatedBy(kbCategoryMasters.getCreatedBy());
        categoryMasterDTO.setCreatedOn(kbCategoryMasters.getCreatedOn());
        categoryMasterDTO.setUpdatedBy(kbCategoryMasters.getUpdatedBy());
        categoryMasterDTO.setUpdatedOn(kbCategoryMasters.getUpdatedOn());
        return categoryMasterDTO;
    }

    public KBCategoryMaster getKBCategoryMasterDTOs(KBCategoryMasterDTO category) {
        KBCategoryMaster kbCategoryMaster = new KBCategoryMaster();
        kbCategoryMaster.setId(category.getId());
        kbCategoryMaster.setName(category.getName());
        kbCategoryMaster.setStatus(category.getStatus());
        kbCategoryMaster.setCreatedBy(category.getCreatedBy());
        kbCategoryMaster.setCreatedOn(category.getCreatedOn());
        kbCategoryMaster.setUpdatedBy(category.getUpdatedBy());
        kbCategoryMaster.setUpdatedOn(category.getUpdatedOn());
        return kbCategoryMaster;
    }
}
