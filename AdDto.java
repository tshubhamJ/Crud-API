package com.auth0.ads.model;

import com.auth0.ads.Entity.Ad;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AdDto
{
    public Ad convertToAdEntity()
    {
        Ad entity = new Ad();
        entity.setId(this.getId());
        entity.setTitle(this.getTitle());
        entity.setDescription(this.getDescription());
        entity.setCreatedAt(this.getCreatedAt());
        entity.setUpdatedAt(this.getUpdatedAt());
        entity.setRemarks(this.getRemarks());
        entity.setEditorid(this.getEditorid());
        return entity;
    }

    private Long id;
    @NotNull
    @Size(max = 50)
    private String title;
    @NotNull
    @Size(max = 200)
    private String description;
    private String remarks;
    private Long editorid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public Long getEditorid() {
        return editorid;
    }

        public void setEditorid(Long editorid) {
        this.editorid = editorid;
    }

        public String getRemarks() {
        return remarks;
    }

        public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public String getDescription() {
        return description;
    }

        public void setDescription(String description) {
        this.description = description;
    }

        public LocalDateTime getCreatedAt() {
        return createdAt;
    }

        public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

        public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

        public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
