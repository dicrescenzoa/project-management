package com.hydra.pma.mapper;

import com.hydra.pma.dto.BookDto;
import com.hydra.pma.entities.Author;
import com.hydra.pma.entities.Book;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;

@Component
public class BookMapper {
    public BookDto convert(Book book) {
        BookDto dto = new BookDto();

        dto.setId(book.getId());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());

        return dto;
    }

    public Book convert(BookDto dto) {
        Book book = new Book();

        book.setId(dto.getId());
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());

        return new Book();
    }
}
