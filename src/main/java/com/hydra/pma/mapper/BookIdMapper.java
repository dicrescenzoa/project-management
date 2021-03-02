package com.hydra.pma.mapper;

import com.hydra.pma.entities.Book;

import java.util.List;
import java.util.stream.Collectors;

public interface BookIdMapper {
    private Book mapGetBookFromId(Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        return book;
    }

    default List<Long> booksToIds(List<Book> books) {
        return books.stream().map((Book book) -> book.getId()).collect(Collectors.toList());
    }

    default  List<Book> idsToBooks(List<Long> ids) {
        return ids.stream().map(this::mapGetBookFromId).collect(Collectors.toList());
    }
}
