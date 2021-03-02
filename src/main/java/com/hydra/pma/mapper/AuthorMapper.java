package com.hydra.pma.mapper;

import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper extends BookIdMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto authorToAuthorDto(Author author);

    List<AuthorDto> getAuthorDtoList(List<Author> authorList);

    Author authorDtoToAuthor(AuthorDto authorDto);
}
