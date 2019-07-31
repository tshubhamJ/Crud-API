package com.auth0.ads.Repository;

import com.auth0.ads.Entity.Editor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends CrudRepository<Editor , Long> { }
