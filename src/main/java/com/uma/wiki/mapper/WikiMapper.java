package com.uma.wiki.mapper;

import com.uma.wiki.dto.*;
import com.uma.wiki.entity.WikiEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WikiMapper {

    public static WikiResponseDTO toResponseDto(WikiEntity wikiEntity) {
        if (wikiEntity == null) {
            return null;
        }

        WikiResponseDTO dto = new WikiResponseDTO();
        // aqui iria ahora los atributos de una wiki, se hace set a todos, por ejemplo:
       // dto.setEntryId(entryEntity.getEntryId());
       // dto.setVersion(entryEntity.getVersion());



        // Si tienes comentarios, conviértelos aquí usando un método similar
        // dto.setCommentEntities(convertCommentsToDto(entryEntity.getCommentEntities()));

        return dto;
    }

    // NO SE SI SE PUEDE ACTUALIZAR UNA WIKI O SI YA ES TEMA DE LA ENTITY ENTRADA
    public static WikiEntity toEntityInUpdate(WikiCreateDTO wikiCreateDto) {
        if (wikiCreateDto == null) {
            return null;
        }

        WikiEntity wikiEntity = new WikiEntity(/* aqui haces get de los atributos del dto pasado por parametro*/);


        return wikiEntity;
    }// este se usa pa crear una wiki
    public static WikiEntity toEntityInCreation(WikiCreateDTO wikiCreateDto) {
        if (wikiCreateDto == null) {
            return null;
        }

        WikiEntity wikiEntity = new WikiEntity(/* aqui haces get de los atributos del dto pasado por parametro*/);

        return wikiEntity;
    }

}
