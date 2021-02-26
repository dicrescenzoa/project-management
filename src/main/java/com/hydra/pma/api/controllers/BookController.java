package com.hydra.pma.api.controllers;

import com.hydra.pma.dao.BookRepository;
import com.hydra.pma.dto.BookDto;
import com.hydra.pma.entities.Book;
import com.hydra.pma.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.getDto(bookOpt.get()));
    }
}
