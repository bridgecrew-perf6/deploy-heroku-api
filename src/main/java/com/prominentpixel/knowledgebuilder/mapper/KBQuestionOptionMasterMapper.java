package com.prominentpixel.knowledgebuilder.mapper;

import com.prominentpixel.knowledgebuilder.domain.KBQuestionOptionMaster;
import com.prominentpixel.knowledgebuilder.domain.UserBean;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionOptionMasterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class KBQuestionOptionMasterMapper {

    @Autowired
    KBQuestionOptionMasterMapper kbQuestionOptionMasterMapper;

    @Autowired
    UserBean userBean;

    public List<KBQuestionOptionMaster> getKBQuestionOptionMstDTOs(List<KBQuestionOptionMasterDTO> options) {
        List<KBQuestionOptionMaster> kbQuestionMasterList = new ArrayList<>();
        for (KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO : options) {
            KBQuestionOptionMaster kbQuestionOptionMaster = new KBQuestionOptionMaster();
            kbQuestionOptionMaster.setId(kbQuestionOptionMasterDTO.getId());
            kbQuestionOptionMaster.setOption(kbQuestionOptionMasterDTO.getOption());
            kbQuestionOptionMaster.setQuestionId(kbQuestionOptionMasterDTO.getQuestionId());
            kbQuestionOptionMaster.setCreatedBy(kbQuestionOptionMasterDTO.getCreatedBy());
            kbQuestionOptionMaster.setCreatedOn(kbQuestionOptionMasterDTO.getCreatedOn());
            kbQuestionOptionMaster.setUpdatedBy(kbQuestionOptionMasterDTO.getUpdatedBy());
            kbQuestionOptionMaster.setUpdatedOn(kbQuestionOptionMasterDTO.getUpdatedOn());
            kbQuestionOptionMaster.setStatus(kbQuestionOptionMasterDTO.getStatus());
            kbQuestionMasterList.add(kbQuestionOptionMaster);
        }
        return kbQuestionMasterList;
    }

    public List<KBQuestionOptionMasterDTO> getKBQuestionOptionMasterDTOs(List<KBQuestionOptionMaster> kbQuestionOptionMaster) {
        List<KBQuestionOptionMasterDTO> kbQuestionOptionMasterDTOS = new ArrayList<>();
        for (KBQuestionOptionMaster kbQuestionMasterObj : kbQuestionOptionMaster) {
            KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO = new KBQuestionOptionMasterDTO();
            kbQuestionOptionMasterDTO.setQuestionId(kbQuestionMasterObj.getQuestionId());
            kbQuestionOptionMasterDTO.setId(kbQuestionMasterObj.getId());
            kbQuestionOptionMasterDTO.setOption(kbQuestionMasterObj.getOption());
            kbQuestionOptionMasterDTO.setIsAnswer(kbQuestionMasterObj.getIsAnswer());
            kbQuestionOptionMasterDTO.setAnswerDescription(kbQuestionMasterObj.getAnswerDescription());
            kbQuestionOptionMasterDTO.setCreatedBy(kbQuestionMasterObj.getCreatedBy());
            kbQuestionOptionMasterDTO.setCreatedOn(kbQuestionMasterObj.getCreatedOn());
            kbQuestionOptionMasterDTO.setUpdatedBy(kbQuestionMasterObj.getUpdatedBy());
            kbQuestionOptionMasterDTO.setUpdatedOn(kbQuestionMasterObj.getUpdatedOn());
            kbQuestionOptionMasterDTO.setStatus(kbQuestionMasterObj.getStatus());
            kbQuestionOptionMasterDTOS.add(kbQuestionOptionMasterDTO);
        }
        return kbQuestionOptionMasterDTOS;
    }

    public static List<KBQuestionOptionMaster> getKBQuestionOptionMasterDTO(List<KBQuestionOptionMaster> fetchedQuestionDto) {
        return fetchedQuestionDto;
    }

    public static KBQuestionOptionMasterDTO convertToKBQuestionOptionMasterDTO(KBQuestionOptionMaster kbQuestionOptionMaster) {
        KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO = new KBQuestionOptionMasterDTO();
        kbQuestionOptionMasterDTO.setId(kbQuestionOptionMaster.getId());
        kbQuestionOptionMasterDTO.setQuestionId(kbQuestionOptionMaster.getQuestionId());
        kbQuestionOptionMasterDTO.setOption(kbQuestionOptionMaster.getOption());
        kbQuestionOptionMasterDTO.setIsAnswer(kbQuestionOptionMaster.getIsAnswer());
        kbQuestionOptionMasterDTO.setStatus(kbQuestionOptionMaster.getStatus());
        kbQuestionOptionMasterDTO.setAnswerDescription(kbQuestionOptionMaster.getAnswerDescription());
        kbQuestionOptionMasterDTO.setCreatedBy(kbQuestionOptionMaster.getCreatedBy());
        kbQuestionOptionMasterDTO.setCreatedOn(kbQuestionOptionMaster.getCreatedOn());
        kbQuestionOptionMasterDTO.setUpdatedBy(kbQuestionOptionMaster.getUpdatedBy());
        kbQuestionOptionMasterDTO.setUpdatedOn(kbQuestionOptionMaster.getUpdatedOn());
        return kbQuestionOptionMasterDTO;
    }

    public KBQuestionOptionMaster getKBQuestionOptionDTOs(KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO) {
        long userID = userBean.getUserId();
        KBQuestionOptionMaster kbQuestionOptionMaster = new KBQuestionOptionMaster();
        kbQuestionOptionMaster.setId(kbQuestionOptionMasterDTO.getId());
        kbQuestionOptionMaster.setQuestionId(kbQuestionOptionMasterDTO.getQuestionId());
        kbQuestionOptionMaster.setOption(kbQuestionOptionMasterDTO.getOption());
        kbQuestionOptionMaster.setIsAnswer(kbQuestionOptionMasterDTO.getIsAnswer());
        kbQuestionOptionMaster.setStatus("ACTIVE");
        kbQuestionOptionMaster.setAnswerDescription(kbQuestionOptionMasterDTO.getAnswerDescription());
        kbQuestionOptionMaster.setCreatedBy(userID);
        kbQuestionOptionMaster.setCreatedOn(new Date());
        kbQuestionOptionMaster.setUpdatedBy(userID);
        kbQuestionOptionMaster.setUpdatedOn(new Date());
        return kbQuestionOptionMaster;
    }
}
