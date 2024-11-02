package com.uma.wiki.service;

import com.uma.wiki.dao.WikiRepository;

import com.uma.wiki.dto.WikiCreateDTO;
import com.uma.wiki.dto.WikiResponseDTO;
import com.uma.wiki.entity.WikiEntity;
import com.uma.wiki.exception.WikiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.uma.wiki.mapper.WikiMapper.*;

@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;


    public WikiResponseDTO getWiki(String entryId){
        WikiEntity wikiEntity = this.wikiRepository.findByWikiId(entryId);

        if (wikiEntity == null) {
            throw new WikiNotFoundException("Entry with ID " + entryId + " doesn't exist in DB");
        }

        return toResponseDto(wikiEntity);
    }

    public void deleteWiki(String entryId){
        WikiEntity wikiEntity = this.wikiRepository.findByWikiId(entryId);
        if (wikiEntity == null)
            throw new WikiNotFoundException("object doesn't exist in DB");

        this.wikiRepository.deleteByWikiId(entryId);
    }

    public WikiResponseDTO createWiki(WikiCreateDTO wikiCreateDto) {
        WikiEntity wikiEntity = toEntityInCreation(wikiCreateDto);
        WikiEntity savedWikiEntity = wikiRepository.save(wikiEntity);

        return toResponseDto(savedWikiEntity);
    }



}
