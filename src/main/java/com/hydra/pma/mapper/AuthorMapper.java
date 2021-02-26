package com.hydra.pma.mapper;

import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorDto convert(Author author) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setFirstname(author.getFirstname());
        authorDto.setLastname(author.getLastname());

        return authorDto;
    }

    public Author convert(AuthorDto authorDto) {
        Author author = new Author();

        author.setId(authorDto.getId());
        author.setFirstname(authorDto.getFirstname());
        author.setLastname(authorDto.getLastname());

        return author;
    }
}
