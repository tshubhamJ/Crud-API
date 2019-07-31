package com.auth0.ads.model;

import com.auth0.ads.Entity.Editor;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditorDto
{
    public Editor convertToEditorEntity()
    {
        Editor entity = new Editor();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setEmail(this.getEmail());
        entity.setDesignation(this.getDesignation());
        return entity;
    }

        private Long id;
        @NotNull
        private String name;
        @NotNull
        @Size(max=50, message= "Please enter a valid email address")
        @Valid @Email
        private String email;
        private String designation;

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getDesignation() { return designation; }

        public void setDesignation(String designation) { this.designation = designation; }

        public String getEmail() { return email; }

        public void setEmail(String email) { this.email = email; }
}


