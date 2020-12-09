package com.prominentpixel.knowledgebuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "kb_question_master")
public class KBQuestionMaster implements Serializable {

    public KBQuestionMaster() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "status")
    private String status;

    @Column(name = "level")
    private String level;

    @Column(name = "type")
    private String type;

    @Column(name = "category_id", updatable = false, insertable = false)
    private Long categoryId;

    @OneToOne(targetEntity = KBCategoryMaster.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private KBCategoryMaster category_id;

    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private long updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;

    @OneToMany(mappedBy = "kbQuestionMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KBQuestionOptionMaster> kbQuestionOptions;

    public List<KBQuestionOptionMaster> getKbQuestionOptions() {
        return kbQuestionOptions;
    }

    public void setKbQuestionOptions(List<KBQuestionOptionMaster> kbQuestionOptions) {
        this.kbQuestionOptions = kbQuestionOptions;
    }

    public KBCategoryMaster getCategory_id() {
        return category_id;
    }

    public void setCategory_id(KBCategoryMaster category_id) {
        this.category_id = category_id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "KBQuestionMaster{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", categoryId=" + categoryId +
                ", category_id=" + category_id +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", kbQuestionOptions=" + kbQuestionOptions +
                '}';
    }
}
