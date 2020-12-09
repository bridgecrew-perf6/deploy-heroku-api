package com.prominentpixel.knowledgebuilder.dao;

import com.prominentpixel.knowledgebuilder.domain.KBQuestionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KBQuestionMasterDAO extends JpaRepository<KBQuestionMaster, Long> {

    @Query("SELECT q FROM KBQuestionMaster q WHERE q.categoryId = :categoryId")
    List<KBQuestionMaster> getAllQuestionsSameCategory(@Param("categoryId")Long categoryId) ;

//    @Query("SELECT q FROM KBQuestionMaster q WHERE q.testId = :testId")
//    List<KBQuestionMaster> getQuestionByTestId(@Param("testId") long testId);

    @Query("SELECT q FROM KBQuestionMaster q")
    List<KBQuestionMaster> getAllQuestions();
}
