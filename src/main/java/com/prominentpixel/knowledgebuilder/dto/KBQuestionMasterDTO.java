package com.prominentpixel.knowledgebuilder.dto;

import java.util.Date;
import java.util.List;

public class KBQuestionMasterDTO {

    public KBQuestionMasterDTO() {
    }

    private Long id;

    private String question;

    private String status;

    private String level;

    private String type;

    private long createdBy;

    private Date createdOn;

    private long updatedBy;

    private Date updatedOn;

    private List<KBQuestionOptionMasterDTO> options;

    private KBCategoryMasterDTO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<KBQuestionOptionMasterDTO> getOptions() {
        return options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public void setOptions(List<KBQuestionOptionMasterDTO> options) {
        this.options = options;
    }

    public KBCategoryMasterDTO getCategory() {
        return category;
    }

    public void setCategory(KBCategoryMasterDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "KBQuestionMasterDTO{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", options=" + options +
                ", category=" + category +
                '}';
    }
}
