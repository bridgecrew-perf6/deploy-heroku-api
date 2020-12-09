package com.prominentpixel.knowledgebuilder.service.impl;

import com.prominentpixel.knowledgebuilder.dao.KBQuestionMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.UserBean;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import com.prominentpixel.knowledgebuilder.mapper.KBCategoryMasterMapper;
import com.prominentpixel.knowledgebuilder.service.KBQuestionMasterService;
import com.prominentpixel.knowledgebuilder.service.KBUserMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prominentpixel.knowledgebuilder.dao.KBQuestionOptionMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionOptionMaster;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionOptionMasterDTO;
import com.prominentpixel.knowledgebuilder.mapper.KBQuestionMasterMapper;
import com.prominentpixel.knowledgebuilder.mapper.KBQuestionOptionMasterMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service()
public class KBQuestionMasterServiceImpl implements KBQuestionMasterService {

    @Autowired
    private KBQuestionMasterDAO kbQuestionMasterDAO;

    @Autowired
    private KBQuestionOptionMasterDAO kbQuestionOptionMasterDAO;

    @Autowired
    KBQuestionMasterMapper kbQuestionMasterMapper;

    @Autowired
    KBQuestionOptionMasterMapper kbQuestionOptionMasterMapper;

    @Autowired
    KBCategoryMasterMapper kbCategoryMasterMapper;

    @Autowired
    KBUserMasterService kbUserMasterService;

    @Autowired
    UserBean userBean;

    @Override
    public List<KBQuestionMasterDTO> getAllQuestions() {
        List<KBQuestionMaster> kbQuestionMasters = kbQuestionMasterDAO.getAllQuestions();
        return kbQuestionMasterMapper.getKBQuestionMasterDTOs(kbQuestionMasters);
    }

    @Override
    public List<KBQuestionMasterDTO> getAllQuestionsSameCategory(Long categoryId) {
        List<KBQuestionMaster> kbQuestionMaster = kbQuestionMasterDAO.getAllQuestionsSameCategory(categoryId);
        return kbQuestionMasterMapper.getKBQuestionMasterDTOs(kbQuestionMaster);
    }

    @Override
    public KBQuestionMaster createQuestion(KBQuestionMasterDTO kbQuestionMasterDTO) throws Exception {
        long userID = userBean.getUserId();

        KBQuestionMaster kbQuestionMaster = new KBQuestionMaster();
        kbQuestionMaster.setQuestion(kbQuestionMasterDTO.getQuestion());
        kbQuestionMaster.setStatus(kbQuestionMasterDTO.getStatus());
        kbQuestionMaster.setLevel(kbQuestionMasterDTO.getLevel());
        kbQuestionMaster.setType(kbQuestionMasterDTO.getType());
        kbQuestionMaster.setCategory_id(kbCategoryMasterMapper.getKBCategoryMasterDTOs(kbQuestionMasterDTO.getCategory()));
        kbQuestionMaster.setCreatedBy(userID);
        kbQuestionMaster.setUpdatedBy(userID);
        kbQuestionMaster.setCreatedOn(new Date());
        kbQuestionMaster.setUpdatedOn(new Date());
        KBQuestionMaster savedQuestionMaster = kbQuestionMasterDAO.saveAndFlush(kbQuestionMaster);
        for (KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO : kbQuestionMasterDTO.getOptions()) {
            KBQuestionOptionMaster kbQuestionOptionMaster = kbQuestionOptionMasterMapper.getKBQuestionOptionDTOs(kbQuestionOptionMasterDTO);
            kbQuestionOptionMaster.setKbQuestionMaster(savedQuestionMaster);
            kbQuestionOptionMasterDAO.save(kbQuestionOptionMaster);
        }
        return null;
    }

    @Override
    public KBQuestionMaster updateQuestion(KBQuestionMasterDTO kbQuestionMasterDTO) throws Exception {
        Optional<KBQuestionMaster> updatedKBQuestionMaster = kbQuestionMasterDAO.findById(kbQuestionMasterDTO.getId());
        long userID = userBean.getUserId();
        if (updatedKBQuestionMaster == null) {
            throw new Exception(CommonConstants.QUESTION_NOT_FOUND + updatedKBQuestionMaster.get().getId());
        } else {
            updatedKBQuestionMaster.get().setQuestion(kbQuestionMasterDTO.getQuestion());
            updatedKBQuestionMaster.get().setStatus(kbQuestionMasterDTO.getStatus());
            updatedKBQuestionMaster.get().setLevel(kbQuestionMasterDTO.getLevel());
            updatedKBQuestionMaster.get().setType(kbQuestionMasterDTO.getType());
            updatedKBQuestionMaster.get().setCategory_id(kbCategoryMasterMapper.getKBCategoryMasterDTOs(kbQuestionMasterDTO.getCategory()));
            //   updatedKBQuestionMaster.get().setCreatedBy(userID);
            updatedKBQuestionMaster.get().setUpdatedBy(userID);
            //   updatedKBQuestionMaster.get().setCreatedOn(new Date());
            updatedKBQuestionMaster.get().setUpdatedOn(new Date());
            KBQuestionMaster updatedQuestionMaster = kbQuestionMasterDAO.saveAndFlush(updatedKBQuestionMaster.get());
            for (KBQuestionOptionMasterDTO kbQuestionOptionMasterDTO : kbQuestionMasterDTO.getOptions()) {
                KBQuestionOptionMaster kbQuestionOptionMaster = kbQuestionOptionMasterMapper.getKBQuestionOptionDTOs(kbQuestionOptionMasterDTO);
                kbQuestionOptionMaster.setKbQuestionMaster(updatedQuestionMaster);
                kbQuestionOptionMasterDAO.saveAndFlush(kbQuestionOptionMaster);
            }
        }
        return null;
    }

    @Override
    public KBQuestionMasterDTO getQuestionById(Long id) {
        if (kbQuestionMasterDAO.findById(id).isPresent()) {
            KBQuestionMaster fetchedKBQuestionMaster = kbQuestionMasterDAO.findById(id).get();
            return kbQuestionMasterMapper.convertKBQuestionMasterDTOByOptions(fetchedKBQuestionMaster);
        } else {
            return null;
        }
    }
}
