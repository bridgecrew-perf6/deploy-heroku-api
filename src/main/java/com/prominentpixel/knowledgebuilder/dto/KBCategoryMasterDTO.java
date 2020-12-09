package com.prominentpixel.knowledgebuilder.dto;

import java.util.Date;
import java.util.List;

public class KBCategoryMasterDTO {

    private Long id;

    private String name;

    private String status;

    private int parentId;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

    private List<KBCategoryMasterDTO> kbCategoryMasterDTOList;

    public List<KBCategoryMasterDTO> getKbCategoryMasterDTOList() {
        return kbCategoryMasterDTOList;
    }

    public void setKbCategoryMasterDTOList(List<KBCategoryMasterDTO> kbCategoryMasterDTOList) {
        this.kbCategoryMasterDTOList = kbCategoryMasterDTOList;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

}
