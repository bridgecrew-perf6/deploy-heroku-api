package com.prominentpixel.knowledgebuilder.dao;

import com.prominentpixel.knowledgebuilder.domain.KBQuestionOptionMaster;
import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KBQuestionOptionMasterDAO extends JpaRepository<KBQuestionOptionMaster, Long> {

    @Query("SELECT q FROM KBQuestionOptionMaster q WHERE q.questionId = :questionId")
    List<KBQuestionOptionMaster> getOptionsByQuestionId(@Param("questionId") long questionId);


}
