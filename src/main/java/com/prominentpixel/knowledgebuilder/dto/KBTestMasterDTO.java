package com.prominentpixel.knowledgebuilder.dto;

import java.util.Date;

public class KBTestMasterDTO {

    public KBTestMasterDTO() {
    }

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String status;

    private String level;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

/*    private List<KBQuestionMasterDTO> questions;

    public List<KBQuestionMasterDTO> getQuestions() {
        return questions;
    }*/

    private KBCategoryMasterDTO kbCategoryMaster;


 /*   public void setQuestions(List<KBQuestionMasterDTO> questions) {
        this.questions = questions;
    }*/

    public KBCategoryMasterDTO getKbCategoryMaster() {
        return kbCategoryMaster;
    }

    public void setKbCategoryMaster(KBCategoryMasterDTO kbCategoryMaster) {
        this.kbCategoryMaster = kbCategoryMaster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
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
        return "KBTestMasterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedOn=" + updatedOn +
                //     ", questions=" + questions +
                '}';
    }
}
