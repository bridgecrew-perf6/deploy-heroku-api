package com.prominentpixel.knowledgebuilder.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "kb_question_option_master")
public class KBQuestionOptionMaster implements Serializable {

    public KBQuestionOptionMaster() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "question_id", updatable = false, insertable = false)
    private Long questionId;

    @Column(name = "option")
    private String option;

    @Column(name = "is_answer")
    private String isAnswer;

    @Column(name = "answer_description")
    private String answerDescription;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private long updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private KBQuestionMaster kbQuestionMaster;

    public KBQuestionMaster getKbQuestionMaster() {
        return kbQuestionMaster;
    }

    public void setKbQuestionMaster(KBQuestionMaster kbQuestionMaster) {
        this.kbQuestionMaster = kbQuestionMaster;
    }

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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "KBQuestionOptionMaster{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", option='" + option + '\'' +
                ", isAnswer='" + isAnswer + '\'' +
                ", answerDescription='" + answerDescription + '\'' +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", kbQuestionMaster=" + kbQuestionMaster +
                '}';
    }
}
