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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/v1/wiki")
@RestController
public class WikiController {

    @Autowired
    WikiService wikiService;
    @Qualifier("defaultServletHandlerMapping")

    /** Devuelve una lista de todas las Wikis .
     *
     * @return
     */
    @Operation(summary = "Get all the wikis", description = "Returns list of wikis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wikis founded", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<ResponseWrapper<List<WikiResponseDTO>>> getWikiByTitle() {
        try {
            List<WikiResponseDTO> wikiResponseDTO = wikiService.getAllWikis();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving wiki"));
        }
    }

    /** Coge todas las wikis que contengan el título pasado por parámetros
     *
     * @param title
     * @return
     */
    @Operation(summary = "Get a wiki by ID", description = "Returns an wiki based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wiki found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/findByTitle")
    public ResponseEntity<ResponseWrapper<List<WikiResponseDTO>>> getWikiByTitle(@RequestParam("title") String title) {
        try {
            List<WikiResponseDTO> wikiResponseDTO = wikiService.getWikiByTitle(title);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving wiki"));
        }
    }

    /** Coge todas las wikis que contengan la descripción pasado por parámetros
     *
     * @param description
     * @return
     */
    @Operation(summary = "Get a wiki by ID", description = "Returns an wiki based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wiki found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/findByDescription")
    public ResponseEntity<ResponseWrapper<List<WikiResponseDTO>>> getWikiByDescription(@RequestParam("description") String description) {
        try {
            List<WikiResponseDTO> wikiResponseDTO = wikiService.getWikiByDescription(description);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper<>(wikiResponseDTO, HttpStatus.OK.value(), "Wiki retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseWrapper<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving wiki"));
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

    // update una wiki
    @Operation(summary = "Update a new wiki", description = "Updates a wiki in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Wiki updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PutMapping
    public ResponseEntity<ResponseWrapper<WikiResponseDTO>> updateWiki(@Valid @RequestBody WikiUpdateDTO wikiUpdateDto) {
        WikiResponseDTO newWikiResponseDTO = wikiService.updateWiki(wikiUpdateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseWrapper<>(newWikiResponseDTO, HttpStatus.CREATED.value(), "Wiki updated successfully"));
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
