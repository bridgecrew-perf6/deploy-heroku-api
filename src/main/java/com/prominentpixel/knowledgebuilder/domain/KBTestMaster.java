package com.prominentpixel.knowledgebuilder.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kb_test_master")
public class KBTestMaster {

    public KBTestMaster() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "level")
    private String level;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;

//    @OneToMany(mappedBy = "kbTestMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<KBQuestionMaster> kbQuestions;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private KBCategoryMaster kbCategoryMaster;


    public KBCategoryMaster getKbCategoryMaster() {
        return kbCategoryMaster;
    }

    public void setKbCategoryMaster(KBCategoryMaster kbCategoryMaster) {
        this.kbCategoryMaster = kbCategoryMaster;
    }

//    public List<KBQuestionMaster> getKbQuestions() {
//        return kbQuestions;
//    }
//
//    public void setKbQuestions(List<KBQuestionMaster> kbQuestions) {
//        this.kbQuestions = kbQuestions;
//    }

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
}
