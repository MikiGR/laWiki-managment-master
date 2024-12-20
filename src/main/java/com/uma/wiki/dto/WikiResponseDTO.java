package com.uma.wiki.dto;

import com.uma.wiki.entity.CommentEntity;
import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.UserEntity;
import com.uma.wiki.entity.WikiEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WikiResponseDTO {
    @NotNull
    private String wikiId;

    @NotNull
    private String title;

    @NotNull
    private String description;

    //@NotNull desactivado porque todavia no esta modelado
    private List<EntryEntity> entries;

    private LocalDateTime creationDate;

    private UserEntity userEntity;


}
