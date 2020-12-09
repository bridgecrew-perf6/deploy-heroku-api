package com.prominentpixel.knowledgebuilder.service;

import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface KBQuestionMasterService {
    List<KBQuestionMasterDTO> getAllQuestions();

    KBQuestionMaster createQuestion(KBQuestionMasterDTO kbUserMaster) throws Exception;

    List<KBQuestionMasterDTO> getAllQuestionsSameCategory(Long categoryId);

    KBQuestionMaster updateQuestion(KBQuestionMasterDTO kbQuestionMasterDTO) throws Exception;

    KBQuestionMasterDTO getQuestionById(Long id);
}
