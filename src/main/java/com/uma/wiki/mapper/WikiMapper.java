package com.uma.wiki.mapper;

import com.uma.wiki.dto.*;
import com.uma.wiki.entity.WikiEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class WikiMapper {

    public static WikiResponseDTO toResponseDto(WikiEntity wikiEntity) {
        if (wikiEntity == null) {
            return null;
        }

        WikiResponseDTO dto = new WikiResponseDTO();
        // aqui iria ahora los atributos de una wiki, se hace set a todos, por ejemplo:
        dto.setWikiId(wikiEntity.getWikiId());
        dto.setTitle(wikiEntity.getTitle());
        dto.setDescription(wikiEntity.getDescription());
        dto.setEntries(wikiEntity.getEntryEntities());
        dto.setUserEntity(wikiEntity.getUserEntity());
        dto.setCreationDate(wikiEntity.getCreationDate());
        return dto;
    }

    public static List<WikiResponseDTO> toResponseDto(List<WikiEntity> wikiEntities) {
            List<WikiResponseDTO> wikiResponseDTOList = new ArrayList<>();

            for(WikiEntity wikiEntity : wikiEntities){
                wikiResponseDTOList.add(toResponseDto(wikiEntity));
            }

        return wikiResponseDTOList;
    }

    public static WikiEntity toEntityInCreation(WikiCreateDTO wikiCreateDto) {
        if (wikiCreateDto == null) {
            return null;
        }

        return new WikiEntity(wikiCreateDto.getTitle(), wikiCreateDto.getDescription(),wikiCreateDto.getEntries(),wikiCreateDto.getUserEntity());
    }

}
