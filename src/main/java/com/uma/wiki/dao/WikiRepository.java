package com.uma.wiki.dao;

import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.UserEntity;
import com.uma.wiki.entity.WikiEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface WikiRepository extends MongoRepository<WikiEntity, ObjectId>{
    WikiEntity findByWikiId(String wikiId);
    void deleteByWikiId(String wikiId);

    @Query("SELECT w FROM Wiki w WHERE w.creationDate = :date")
    WikiEntity findByDate(@Param("date") LocalDateTime date);

    @Query("SELECT w FROM Wiki w WHERE w.title LIKE CONCAT('%',:title,'%')")
    List<WikiEntity> findByTitle(@Param("title") String title);

    @Query("SELECT w FROM Wiki w WHERE w.description LIKE CONCAT('%',:description,'%')")
    List<WikiEntity> findByDescription(@Param("description") String description);
}

