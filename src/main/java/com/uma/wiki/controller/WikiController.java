package com.uma.wiki.controller;

import com.uma.wiki.dto.*;
import com.uma.wiki.service.WikiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/wiki")
@RestController
public class WikiController {

    @Autowired
    WikiService wikiService;

    // De momemento vamos a hacer los metodos para el CRUD de una wiki
    // no he incluido el UPDATE del crud ya que no se si se actualiza una wiki como tal o si eso es tarea de las entradas
/*
    @Operation(summary = "Get a wiki by ID", description = "Returns an wiki based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wiki found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<ResponseWrapper<WikiResponseDTO>> getWikiByDate(@RequestParam("wikiId") String wikiId) {
        try {
            WikiResponseDTO wikiResponseDTO = wikiService.getWiki(wikiId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving entry"));
        }
    }
    */

    @Operation(summary = "Get a wiki by ID", description = "Returns an wiki based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wiki found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<ResponseWrapper<WikiResponseDTO>> getWikiByTitle(@RequestParam("title") String title) {
        try {
            WikiResponseDTO wikiResponseDTO = wikiService.getWikiByTitle(title);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving entry"));
        }
    }

    // leer una wiki
    @Operation(summary = "Get a wiki by ID", description = "Returns an wiki based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wiki found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<ResponseWrapper<WikiResponseDTO>> getWiki(@RequestParam("wikiId") String wikiId) {
        try {
            WikiResponseDTO wikiResponseDTO = wikiService.getWiki(wikiId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving entry"));
        }
    }

    // crear una wiki
    @Operation(summary = "Create a new wiki", description = "Creates a new wiki in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Wiki created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ResponseWrapper<WikiResponseDTO>> createWiki(@Valid @RequestBody WikiCreateDTO wikiCreateDto) {
        WikiResponseDTO newWikiResponseDTO = wikiService.createWiki(wikiCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseWrapper<>(newWikiResponseDTO, HttpStatus.CREATED.value(), "Wiki created successfully"));
    }

    // borra una wiki
    @Operation(summary = "Delete a wiki", description = "This endpoint allows clients to delete a wiki by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "WIki deleted successfully", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Wiki not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<ResponseWrapper<String>> deleteWiki(@RequestParam("wikiId") String wikiId) {
        try {
            wikiService.deleteWiki(wikiId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>("Correctly deleted", HttpStatus.OK.value(), "Wiki deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting wiki"));
        }
    }
}
