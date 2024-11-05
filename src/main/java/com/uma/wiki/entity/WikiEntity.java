package com.uma.wiki.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "comments")
public class WikiEntity {

    @MongoId
    @Builder.Default
    private ObjectId id = new ObjectId();

    @NotNull
    private String wikiId;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private List<EntryEntity> entryEntities;

    private LocalDateTime creationDate;

    @NotNull
    private UserEntity userEntity;


    public WikiEntity(UserEntity userEntity,String title, String description,List<EntryEntity> entryEntities, String wikiId) {
        this.id = new ObjectId();
        this.wikiId = validateWikiId(wikiId) ? wikiId : null ;
        this.userEntity = userEntity;
        this.creationDate = LocalDateTime.now();
        this.title = title;
        this.description = description;
        this.entryEntities = entryEntities;
    }

    public WikiEntity(UserEntity userEntity,String title, String description,List<EntryEntity> entryEntities) {
        this.id = new ObjectId();
        this.wikiId = UUID.randomUUID().toString();
        this.userEntity = userEntity;
        this.creationDate = LocalDateTime.now();
        this.title = title;
        this.description = description;
        this.entryEntities = entryEntities;
    }


    private boolean validateWikiId(String wikiId) {
        try {
            UUID.fromString(wikiId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("wikiId must be a valid UUID");
        }
        return true;
    }
}
