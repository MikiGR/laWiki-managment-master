package com.uma.wiki.dto;

import com.uma.wiki.entity.EntryEntity;

import java.time.LocalDateTime;
import java.util.List;

public class WikiCreateDTO {
    private String wikiId;

    private String title;

    private String description;

    //@NotNull desactivado porque todavia no esta modelado
    private List<EntryEntity> entries;

    private LocalDateTime creationDate;
}
