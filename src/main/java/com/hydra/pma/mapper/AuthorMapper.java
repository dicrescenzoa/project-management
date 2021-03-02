package com.hydra.pma.mapper;

import com.hydra.pma.dao.AuthorRepository;
import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import com.hydra.pma.entities.Book;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto authorToAuthorDto(Author author);

    List<AuthorDto> getAuthorDtoList(List<Author> authorList);

    Author authorDtoToAuthor(AuthorDto authorDto);

    default  List<Long> booksToIds(List<Book> books) {
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
