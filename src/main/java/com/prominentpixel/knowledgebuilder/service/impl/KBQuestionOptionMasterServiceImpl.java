package com.prominentpixel.knowledgebuilder.service.impl;

import com.prominentpixel.knowledgebuilder.dao.KBQuestionOptionMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBQuestionOptionMaster;
import com.prominentpixel.knowledgebuilder.mapper.KBQuestionOptionMasterMapper;
import com.prominentpixel.knowledgebuilder.service.KBQuestionOptionMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class KBQuestionOptionMasterServiceImpl implements KBQuestionOptionMasterService {

    @Autowired
    private KBQuestionOptionMasterDAO kbQuestionOptionMasterDAO;

    @Override
    public List<KBQuestionOptionMaster> getOptionsByQuestionId(long questionId) {
        List<KBQuestionOptionMaster> fetchedQuestionDto = kbQuestionOptionMasterDAO.getOptionsByQuestionId(questionId);
        return KBQuestionOptionMasterMapper.getKBQuestionOptionMasterDTO(fetchedQuestionDto);
    }
}