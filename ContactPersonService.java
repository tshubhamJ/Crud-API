package com.auth0.ads.Service;

import com.auth0.ads.Entity.ContactPerson;
import com.auth0.ads.Repository.ContactPersonRepository;
import com.auth0.ads.model.ContactPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactPersonService {

        @Autowired
        private ContactPersonRepository contactpersonRepository;

        public ContactPersonDto findById(Long contacrpersonId) {
            Optional<ContactPerson> entityObj = contactpersonRepository.findById(contacrpersonId);
            if (entityObj.isPresent()) {
                return entityObj.get()._toConvertContactPersonDto();
            } else {
                return null;
            }
        }

        public void deleteById(Long id) {
            contactpersonRepository.deleteById(id);
        }

        public ContactPersonDto save(ContactPersonDto contactperson) {
            ContactPerson contactPersonEntity = contactperson.convertToContactPersonEntity();
            contactpersonRepository.save(contactPersonEntity);
            return contactPersonEntity._toConvertContactPersonDto();
        }

        public List<ContactPersonDto> findAll() {
            Iterable<ContactPerson> opList = contactpersonRepository.findAll();
            List<ContactPersonDto> list = new ArrayList<>();
            for (ContactPerson opObj: opList) {
                list.add(opObj._toConvertContactPersonDto());
            }
            return list;
        }
    }



