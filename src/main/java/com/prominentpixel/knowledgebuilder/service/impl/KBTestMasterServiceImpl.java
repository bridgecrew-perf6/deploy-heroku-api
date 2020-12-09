package com.prominentpixel.knowledgebuilder.service.impl;

import com.prominentpixel.knowledgebuilder.dao.KBTestMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBTestMaster;
import com.prominentpixel.knowledgebuilder.dto.KBTestMasterDTO;
import com.prominentpixel.knowledgebuilder.mapper.KBTestMasterMapper;
import com.prominentpixel.knowledgebuilder.service.KBTestMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KBTestMasterServiceImpl implements KBTestMasterService {

    @Autowired
    private KBTestMasterDAO kbTestMasterDAO;

    @Autowired
    KBTestMasterMapper kbTestMasterMapper;

    @Override
    public KBTestMasterDTO getTestById(long id) {
        if (kbTestMasterDAO.findById(id).isPresent()) {
            KBTestMaster fetchedTestDto = kbTestMasterDAO.findById(id).get();
            return kbTestMasterMapper.convertKBTestMasterDTOByQuestionsAndOptions(fetchedTestDto);
        } else {
            return null;
        }
    }

    @Override
    public List<KBTestMasterDTO> getAllTests() {
        List<KBTestMaster> kbTestMasters = kbTestMasterDAO.getAllTests();
        return kbTestMasterMapper.getTestMasterDtos(kbTestMasters);
    }


//    @Override
//    public KBTestMasterDTO getManageTestTestById(Long id) {
//      //  KBTestMaster fetchedTestDto = kbTestMasterDAO.findById(id).get();
//
//        KBTestMaster fetchedTestDto =  kbTestMasterDAO.findById(id).get();
//      // KBCategoryMaster kbCategoryMaster= fetchedTestDto.getKbCategoryMaster();
//         return kbTestMasterMapper.convertTestToCategory(fetchedTestDto);
//
//
//    }
}
