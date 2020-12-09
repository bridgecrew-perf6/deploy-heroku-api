package com.prominentpixel.knowledgebuilder.service;

import com.prominentpixel.knowledgebuilder.domain.KBTestMaster;
import com.prominentpixel.knowledgebuilder.dto.KBTestMasterDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface KBTestMasterService {
   KBTestMasterDTO getTestById(long id);

 //  KBTestMasterDTO getManageTestTestById(Long id);

    List<KBTestMasterDTO> getAllTests();

}
