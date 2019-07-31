package com.auth0.ads.Repository;

import com.auth0.ads.Entity.ContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends CrudRepository<ContactPerson , Long> { }
