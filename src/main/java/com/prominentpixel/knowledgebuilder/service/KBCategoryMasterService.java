package com.prominentpixel.knowledgebuilder.service;

import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface KBCategoryMasterService {
    List<KBCategoryMasterDTO> getAllCategory();

    KBCategoryMasterDTO getCategoryById(Long id);
}
