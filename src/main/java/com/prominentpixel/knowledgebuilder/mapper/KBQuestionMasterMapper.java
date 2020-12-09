package com.prominentpixel.knowledgebuilder.mapper;

import com.prominentpixel.knowledgebuilder.dao.KBQuestionMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class KBQuestionMasterMapper {

    @Autowired
    KBQuestionOptionMasterMapper kbQuestionOptionMasterMapper;

    @Autowired
    KBQuestionMasterDAO kbQuestionMasterDAO;

    public List<KBQuestionMasterDTO> getKBQuestionMasterDTOs(List<KBQuestionMaster> kbQuestionMaster) {
        List<KBQuestionMasterDTO> kbQuestionMasterDTOS = new ArrayList<>();
        for (KBQuestionMaster kbQuestionMasterObj : kbQuestionMaster) {

            KBQuestionMasterDTO kbQuestionMasterDTO = new KBQuestionMasterDTO();
            kbQuestionMasterDTO.setId(kbQuestionMasterObj.getId());
            kbQuestionMasterDTO.setQuestion(kbQuestionMasterObj.getQuestion());
            kbQuestionMasterDTO.setType(kbQuestionMasterObj.getType());
            kbQuestionMasterDTO.setStatus(kbQuestionMasterObj.getStatus());
            kbQuestionMasterDTO.setLevel(kbQuestionMasterObj.getLevel());
            kbQuestionMasterDTO.setCreatedBy(kbQuestionMasterObj.getCreatedBy());
            kbQuestionMasterDTO.setCreatedOn(kbQuestionMasterObj.getCreatedOn());
            kbQuestionMasterDTO.setUpdatedBy(kbQuestionMasterObj.getUpdatedBy());
            kbQuestionMasterDTO.setUpdatedOn(kbQuestionMasterObj.getUpdatedOn());
          //  kbQuestionMasterDTO.setCategory(kbQuestionMasterObj.getKbCategoryMaster());
            kbQuestionMasterDTO.setOptions(kbQuestionOptionMasterMapper.getKBQuestionOptionMasterDTOs(kbQuestionMasterObj.getKbQuestionOptions()));
            kbQuestionMasterDTOS.add(kbQuestionMasterDTO);
        }
        return kbQuestionMasterDTOS;
    }

    public KBQuestionMasterDTO convertKBQuestionMasterDTOByOptions(KBQuestionMaster fetchedKBQuestionMaster) {
        KBQuestionMasterDTO kbQuestionMasterDTO = new KBQuestionMasterDTO();
        kbQuestionMasterDTO.setId(fetchedKBQuestionMaster.getId());
        kbQuestionMasterDTO.setQuestion(fetchedKBQuestionMaster.getQuestion());
        kbQuestionMasterDTO.setType(fetchedKBQuestionMaster.getType());
        kbQuestionMasterDTO.setStatus(fetchedKBQuestionMaster.getStatus());
        kbQuestionMasterDTO.setLevel(fetchedKBQuestionMaster.getLevel());
        kbQuestionMasterDTO.setCreatedBy(fetchedKBQuestionMaster.getCreatedBy());
        kbQuestionMasterDTO.setCreatedOn(fetchedKBQuestionMaster.getCreatedOn());
        kbQuestionMasterDTO.setUpdatedBy(fetchedKBQuestionMaster.getUpdatedBy());
        kbQuestionMasterDTO.setUpdatedOn(fetchedKBQuestionMaster.getUpdatedOn());
        //   kbQuestionMasterDTO.setCategory(kbQuestionMasterObj.getKbCategoryMaster());
        kbQuestionMasterDTO.setOptions(kbQuestionOptionMasterMapper.getKBQuestionOptionMasterDTOs(fetchedKBQuestionMaster.getKbQuestionOptions()));
        return kbQuestionMasterDTO;
    }
}
