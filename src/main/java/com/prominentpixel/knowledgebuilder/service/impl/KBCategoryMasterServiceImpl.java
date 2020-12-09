package com.prominentpixel.knowledgebuilder.service.impl;

import com.prominentpixel.knowledgebuilder.dao.KBCategoryMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBCategoryMaster;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import com.prominentpixel.knowledgebuilder.mapper.KBCategoryMasterMapper;
import com.prominentpixel.knowledgebuilder.service.KBCategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KBCategoryMasterServiceImpl implements KBCategoryMasterService {

    @Autowired
    KBCategoryMasterDAO kbCategoryMasterDAO;

    @Autowired
    KBCategoryMasterMapper kbCategoryMasterMapper;

    @Override
    public List<KBCategoryMasterDTO> getAllCategory() {
        List<KBCategoryMaster> kbCategoryMaster = kbCategoryMasterDAO.findAll();
        return kbCategoryMasterMapper.getKBCategoryMasterDTOs(kbCategoryMaster);
    }

    @Override
    public KBCategoryMasterDTO getCategoryById(Long id) {
        if (kbCategoryMasterDAO.findById(id).isPresent()) {
            KBCategoryMaster fetchedKBCategoryMaster = kbCategoryMasterDAO.findById(id).get();
            return kbCategoryMasterMapper.getKBCategoryMasterDTO(fetchedKBCategoryMaster);
        } else {
            return null;
        }
    }
}
