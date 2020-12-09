package com.prominentpixel.knowledgebuilder.dao;

import com.prominentpixel.knowledgebuilder.domain.KBTestMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface KBTestMasterDAO extends JpaRepository<KBTestMaster, Long> {
    @Query("SELECT q FROM KBTestMaster q")
    List<KBTestMaster> getAllTests();


    Optional<KBTestMaster> findById(Long testId);

}
