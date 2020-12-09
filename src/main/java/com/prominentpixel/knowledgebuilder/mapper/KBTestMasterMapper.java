package com.prominentpixel.knowledgebuilder.mapper;

import com.prominentpixel.knowledgebuilder.domain.KBCategoryMaster;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import com.prominentpixel.knowledgebuilder.domain.KBTestMaster;
import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import com.prominentpixel.knowledgebuilder.dto.KBTestMasterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KBTestMasterMapper {

    @Autowired
    KBQuestionMasterMapper kbQuestionMasterMapper;

    @Autowired
    KBCategoryMasterMapper kbCategoryMasterMapper;


    public static KBTestMaster getKBTestMasterDTO(KBTestMaster fetchedTestDto) {
        return fetchedTestDto;
    }

    public KBTestMasterDTO convertToKBTestMasterDTO(KBTestMaster kbTestMaster) {
        KBTestMasterDTO kbTestMasterDTO = new KBTestMasterDTO();
        kbTestMasterDTO.setId(kbTestMaster.getId());
        kbTestMasterDTO.setName(kbTestMaster.getName());
        kbTestMasterDTO.setLevel(kbTestMaster.getLevel());
        kbTestMasterDTO.setStatus(kbTestMaster.getStatus());
        kbTestMasterDTO.setCreatedBy(kbTestMaster.getCreatedBy());
        kbTestMasterDTO.setCreatedOn(kbTestMaster.getCreatedOn());
        kbTestMasterDTO.setUpdatedBy(kbTestMaster.getUpdatedBy());
        kbTestMasterDTO.setUpdatedOn(kbTestMaster.getUpdatedOn());
        kbTestMasterDTO.setKbCategoryMaster(kbCategoryMasterMapper.getKBCategoryMasterDTO(kbTestMaster.getKbCategoryMaster()));
        //  kbTestMasterDTO.setQuestions(kbQuestionMasterMapper.getKBQuestionMasterDTOs(kbTestMaster.getKbQuestions()));
        return kbTestMasterDTO;
    }

    public KBTestMasterDTO convertKBTestMasterDTOByQuestionsAndOptions(KBTestMaster kbTestMaster) {
        KBTestMasterDTO kbTestMasterDTO = new KBTestMasterDTO();
        kbTestMasterDTO.setId(kbTestMaster.getId());
        kbTestMasterDTO.setName(kbTestMaster.getName());
        kbTestMasterDTO.setLevel(kbTestMaster.getLevel());
        kbTestMasterDTO.setStatus(kbTestMaster.getStatus());
        kbTestMasterDTO.setCreatedBy(kbTestMaster.getCreatedBy());
        kbTestMasterDTO.setCreatedOn(kbTestMaster.getCreatedOn());
        kbTestMasterDTO.setUpdatedBy(kbTestMaster.getUpdatedBy());
        kbTestMasterDTO.setUpdatedOn(kbTestMaster.getUpdatedOn());
        kbTestMasterDTO.setKbCategoryMaster(kbCategoryMasterMapper.getKBCategoryMasterDTO(kbTestMaster.getKbCategoryMaster()));
    //    kbTestMasterDTO.setQuestions(kbQuestionMasterMapper.getKBQuestionMasterDTOs(kbTestMaster.getKbQuestions()));
        return kbTestMasterDTO;
    }

    public List<KBTestMasterDTO> getTestMasterDtos(List<KBTestMaster> kbTestMaster) {
        List<KBTestMasterDTO> result = new ArrayList<>(kbTestMaster.size());
        for (KBTestMaster kb : kbTestMaster) {
            KBTestMasterDTO kbTestMasterDTO = convertToKBTestMasterDTO(kb);
            result.add(kbTestMasterDTO);
        }
        return result;
    }


    // TODO : move to dto
//    public static List<KBQuestionMasterDTO> getKBQuestionMasterDTOs(List<KBQuestionMaster> kbQuestionMaster) {
//        List<KBQuestionMasterDTO> kbQuestionMasterDTOS = new ArrayList<>();
//        for (KBQuestionMaster kbQuestionMasterObj : kbQuestionMaster) {
//            KBQuestionMasterDTO kbQuestionMasterDTO = new KBQuestionMasterDTO();
//            kbQuestionMasterDTO.setId(kbQuestionMasterObj.getId());
//            kbQuestionMasterDTO.setQuestion(kbQuestionMasterObj.getQuestion());
//            kbQuestionMasterDTO.setType(kbQuestionMasterObj.getType());
//            kbQuestionMasterDTO.setStatus(kbQuestionMasterObj.getStatus());
//            kbQuestionMasterDTO.setLevel(kbQuestionMasterObj.getLevel());
//            kbQuestionMasterDTO.setTestId(kbQuestionMasterObj.getTestId());
//            kbQuestionMasterDTO.setCreatedBy(kbQuestionMasterObj.getCreatedBy());
//            kbQuestionMasterDTO.setCreatedOn(kbQuestionMasterObj.getCreatedOn());
//            kbQuestionMasterDTO.setUpdatedBy(kbQuestionMasterObj.getUpdatedBy());
//            kbQuestionMasterDTO.setUpdatedOn(kbQuestionMasterObj.getUpdatedOn());
//            kbQuestionMasterDTO.setOptions(getKBQuestionOptionMasterDTOs(kbQuestionMasterObj.getKbQuestionOptions()));
//            kbQuestionMasterDTOS.add(kbQuestionMasterDTO);
//        }
//        return kbQuestionMasterDTOS;
//    }

//    public static List<KBQuestionOptionMasterDTO> getKBQuestionOptionMasterDTOs(List<KBQuestionOptionMaster> kbQuestionOptionMaster) {
//        List<KBQuestionOptionMasterDTO> kbQuestionOptionMasterDTOS = new ArrayList<>();
//        for (KBQuestionOptionMaster kbQuestionMasterObj : kbQuestionOptionMaster) {
//            KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO = new KBQuestionOptionMasterDTO();
//            kbQuestionOptionMasterDTO.setQuestionId(kbQuestionMasterObj.getQuestionId());
//            kbQuestionOptionMasterDTO.setId(kbQuestionMasterObj.getId());
//            kbQuestionOptionMasterDTO.setOption(kbQuestionMasterObj.getOption());
//            //  kbQuestionOptionMasterDTO.setIsAnswer(kbQuestionMasterObj.getIsAnswer());
//            // kbQuestionOptionMasterDTO.setAnswerDescription(kbQuestionMasterObj.getAnswerDescription());
//            kbQuestionOptionMasterDTO.setCreatedBy(kbQuestionMasterObj.getCreatedBy());
//            kbQuestionOptionMasterDTO.setCreatedOn(kbQuestionMasterObj.getCreatedOn());
//            kbQuestionOptionMasterDTO.setUpdatedBy(kbQuestionMasterObj.getUpdatedBy());
//            kbQuestionOptionMasterDTO.setUpdatedOn(kbQuestionMasterObj.getUpdatedOn());
//            kbQuestionOptionMasterDTO.setStatus(kbQuestionMasterObj.getStatus());
//            kbQuestionOptionMasterDTOS.add(kbQuestionOptionMasterDTO);
//        }
//        return kbQuestionOptionMasterDTOS;
//    }
}
