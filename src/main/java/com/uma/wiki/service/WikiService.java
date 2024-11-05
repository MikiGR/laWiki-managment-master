package com.uma.wiki.service;

import com.uma.wiki.dao.WikiRepository;

import com.uma.wiki.dto.WikiCreateDTO;
import com.uma.wiki.dto.WikiResponseDTO;
import com.uma.wiki.entity.WikiEntity;
import com.uma.wiki.exception.WikiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.uma.wiki.mapper.WikiMapper.*;

@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;

    public WikiResponseDTO getWikiByDate(LocalDateTime date) {
        WikiEntity wikiEntity = this.wikiRepository.findByDate(date);

        if (wikiEntity == null) {
            throw new WikiNotFoundException("No Wikis at date:  " + date );
        }

        return toResponseDto(wikiEntity);
    }

    public WikiResponseDTO getWikiByTitle(String title) {
        WikiEntity wikiEntity = this.wikiRepository.findByTitle(title);

        if (wikiEntity == null) {
            throw new WikiNotFoundException("No Wiki with title:  " + title );
        }

        return toResponseDto(wikiEntity);
    }

    public WikiResponseDTO getWiki(String wikiId){
        WikiEntity wikiEntity = this.wikiRepository.findByWikiId(wikiId);

        if (wikiEntity == null) {
            throw new WikiNotFoundException("Wiki with ID " + wikiId + " doesn't exist in DB");
        }

        return toResponseDto(wikiEntity);
    }

    public void deleteWiki(String wikiId){
        WikiEntity wikiEntity = this.wikiRepository.findByWikiId(wikiId);
        if (wikiEntity == null)
            throw new WikiNotFoundException("Wiki "+wikiId+" doesn't exist in DB");

        this.wikiRepository.deleteByWikiId(wikiId);
    }

    public WikiResponseDTO createWiki(WikiCreateDTO wikiCreateDto) {
        WikiEntity wikiEntity = toEntityInCreation(wikiCreateDto);
        WikiEntity savedWikiEntity = wikiRepository.save(wikiEntity);

        return toResponseDto(savedWikiEntity);
    }



}
