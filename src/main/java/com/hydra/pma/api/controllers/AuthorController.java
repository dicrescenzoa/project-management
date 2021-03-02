package com.hydra.pma.api.controllers;

import com.hydra.pma.dao.AuthorRepository;
import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import com.hydra.pma.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") long id) {
        Optional<AuthorDto> authorDto = authorService.getAuthorById(id);
        if(authorDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorDto.get());
    }
}
