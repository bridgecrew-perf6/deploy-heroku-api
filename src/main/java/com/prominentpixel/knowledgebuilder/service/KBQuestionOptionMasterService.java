package com.prominentpixel.knowledgebuilder.service;

import com.prominentpixel.knowledgebuilder.domain.KBQuestionOptionMaster;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public interface KBQuestionOptionMasterService {
    List<KBQuestionOptionMaster> getOptionsByQuestionId(long questionId);
}