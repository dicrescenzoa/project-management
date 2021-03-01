package com.hydra.pma.services;

import com.hydra.pma.dto.BookDto;
import com.hydra.pma.entities.Book;
import com.hydra.pma.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BookDto getDto(Book book) {
        return BookMapper.INSTANCE.bookToBookDto(book);
    }

    public Book getBook(BookDto dto) {
        return BookMapper.INSTANCE.bookDtoToBook(dto);
    }
}
