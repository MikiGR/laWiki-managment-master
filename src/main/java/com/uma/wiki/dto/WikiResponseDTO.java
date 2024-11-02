package com.uma.wiki.dto;

import com.uma.wiki.entity.CommentEntity;
import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.UserEntity;
import com.uma.wiki.entity.WikiEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WikiResponseDTO {

    private String wikiId;

    private String title;

    private String description;

    //@NotNull desactivado porque todavia no esta modelado
    private List<EntryEntity> entries;

    private LocalDateTime creationDate;


}
