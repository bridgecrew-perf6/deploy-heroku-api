package com.prominentpixel.knowledgebuilder.dto;

import java.util.Date;

public class KBQuestionOptionMasterDTO {

    public KBQuestionOptionMasterDTO() {
    }

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long questionId;

    private String option;

    private String isAnswer;

    private String answerDescription;

    private long createdBy;

    private Date createdOn;

    private long updatedBy;

    private Date updatedOn;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(String isAnswer) {
        this.isAnswer = isAnswer;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "KBQuestionOptionMasterDTO{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", option='" + option + '\'' +
                ", isAnswer='" + isAnswer + '\'' +
                ", answerDescription='" + answerDescription + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", status='" + status + '\'' +
                '}';
    }
}
