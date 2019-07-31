package com.auth0.ads.Entity;

import com.auth0.ads.model.ContactPersonDto;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

    @Entity
    @Table(name="Contact_Person")
    @EqualsAndHashCode

    public class ContactPerson
    {
        public ContactPersonDto _toConvertContactPersonDto()
        {
            ContactPersonDto dto = new ContactPersonDto();
            dto.setId(this.getId());
            dto.setName(this.getName());
            dto.setMobileNo(this.getMobileNo());
            return dto;
        }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    @Column(name="Name")
    private String name;
    @Valid
    @NotNull
    @Column(name = "Mobile_No" ,unique = true)
    @Size(min = 10 ,max = 10 ,message = "Mob No length is fixed as 10 so please enter a valid no")
    private String mobileNo;

    @ManyToMany(mappedBy = "contactperson")
    private Collection<Ad> ad;

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