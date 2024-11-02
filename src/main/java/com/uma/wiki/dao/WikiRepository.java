package com.uma.wiki.dao;

import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.WikiEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WikiRepository extends MongoRepository<WikiEntity, ObjectId>{
    WikiEntity findByWikiId(String wikiId);
    void deleteByWikiId(String wikiId);

    // tambien supongo que haran falta los tipicos como pa filtrar y toda la movida esa

}

