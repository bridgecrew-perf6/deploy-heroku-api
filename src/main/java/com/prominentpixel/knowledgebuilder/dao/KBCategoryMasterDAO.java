package com.prominentpixel.knowledgebuilder.dao;

import com.prominentpixel.knowledgebuilder.domain.KBCategoryMaster;
import com.prominentpixel.knowledgebuilder.domain.KBTestMaster;
import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KBCategoryMasterDAO extends JpaRepository<KBCategoryMaster, Long   > {

    List<KBCategoryMaster> findAll();
}
