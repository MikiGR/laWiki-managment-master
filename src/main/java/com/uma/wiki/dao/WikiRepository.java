package com.uma.wiki.dao;

import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.WikiEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WikiRepository extends MongoRepository<WikiRepository, ObjectId>{
    WikiEntity findByEntryIdAndVersion(String entryId, String version);
    void deleteByEntryIdAndVersion(String entryId, String version);
    EntryEntity findTopByEntryIdOrderByCreationDateDesc(String entryId);

    EntryEntity findTopByEntryIdAndActiveIsTrue(String entryId);

}

