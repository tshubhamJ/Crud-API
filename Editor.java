package com.auth0.ads.Entity;

import com.auth0.ads.model.EditorDto;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

   @Entity
   @Table(name = "Editor")
   @EqualsAndHashCode

   public class Editor
   {
       public EditorDto _toConvertEditorDto()
       {
           EditorDto dto = new EditorDto();
           dto.setId(this.getId());
           dto.setEmail(this.getEmail());
           dto.setDesignation(this.getDesignation());
           dto.setName(this.getName());
           return dto;
       }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @Column(name = "Name", nullable = false)
    private String name;
    @NotNull
    @Size(max = 50, message = "Please enter a valid email address")
    @Valid @Email
    @Column(name = "Email", unique = true,  nullable = false)
    private  String email;
    private  String designation;

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

        public String getEmail() {
        return email;
    }

        public void setEmail(String email) {
        this.email = email;
    }

        public String getDesignation() {
        return designation;
    }

        public void setDesignation(String designation) {
        this.designation = designation;
    }
}