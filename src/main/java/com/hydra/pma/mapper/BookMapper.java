package com.hydra.pma.mapper;

import com.hydra.pma.dto.BookDto;
import com.hydra.pma.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    default List<Long> booksToIds(List<Book> books) {
        List<Long> list = new ArrayList();
        for (Book book : books) {
            list.add(book.getId());
        }
        return list;
    }

    default  List<Book> idsToBooks(List<Long> ids) {
        List<Book> list = new ArrayList();
        for (Long id : ids) {
            Book book = new Book();
            book.setId(id);
            list.add(book);
        }
        return list;
    }
}
