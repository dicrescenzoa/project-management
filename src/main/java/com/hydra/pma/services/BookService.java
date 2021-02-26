package com.hydra.pma.services;

import com.hydra.pma.dto.BookDto;
import com.hydra.pma.entities.Book;
import com.hydra.pma.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public BookDto getDto(Book book) {
        return bookMapper.convert(book);
    }

    public Book getBook(BookDto dto) {
        return bookMapper.convert(dto);
    }
}
