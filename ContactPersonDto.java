package com.auth0.ads.model;

import com.auth0.ads.Entity.ContactPerson;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContactPersonDto
{
    public ContactPerson convertToContactPersonEntity()
    {
        ContactPerson entity = new ContactPerson();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setMobileNo(this.getMobileNo());
        return entity;
    }

    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 10, max = 10, message ="Mob No length is fixed as 10 so please enter a valid no")
    private String mobileNo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }
}

