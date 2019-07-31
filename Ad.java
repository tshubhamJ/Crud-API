package com.auth0.ads.Entity;

import com.auth0.ads.model.AdDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

    @Entity
    @Table(name="Ad")
    @Getter
    @Setter
    @EqualsAndHashCode

    public class Ad
    {
       public AdDto _toConvertAdDto()
       {
          AdDto dto = new AdDto();
          dto.setId(this.getId());
          dto.setTitle(this.getTitle());
          dto.setDescription(this.getDescription());
          dto.setCreatedAt(this.getCreatedAt());
          dto.setUpdatedAt(this.getUpdatedAt());
          dto.setRemarks(this.getRemarks());
          dto.setEditorid(this.getEditorid());
          return dto;
       }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long editorid;
    @Column(name = "Created_At", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "Updated_At", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @NotNull
    @Size(max = 50)
    private String title;
    @NotNull
    @Size(max = 200)
    private String description;
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editor_id", nullable = false, insertable = false, updatable = false)
    private  Editor editor;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="ad_contactperson", joinColumns={ @JoinColumn(name = "ad_id")}, inverseJoinColumns={@JoinColumn(name="contact_person_id")} )
    private List<ContactPerson> contactperson;

    public Ad( ) { }

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }

        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        public LocalDateTime getCreatedAt() { return createdAt; }

        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

        public LocalDateTime getUpdatedAt() { return updatedAt; }

        public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

        public String getRemarks() { return remarks; }

        public Long getEditorid() { return editorid; }

        public void setEditorid(Long editorid) { this.editorid = editorid; }

        public void setRemarks(String remarks) { this.remarks = remarks; }
}