package com.uma.wiki.dto;

import com.uma.wiki.entity.EntryEntity;
import com.uma.wiki.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WikiUpdateDTO {
    @NotNull
    private String wikiId;

    @NotNull
    private String title;

    private String description;

    //@NotNull desactivado porque todavia no esta modelado
    private List<EntryEntity> entries;

    private LocalDateTime creationDate;

    private UserEntity userEntity;

}
