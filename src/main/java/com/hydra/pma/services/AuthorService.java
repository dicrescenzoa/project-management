package com.hydra.pma.services;

import com.hydra.pma.dao.AuthorRepository;
import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import com.hydra.pma.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public Optional<AuthorDto> getAuthorById(Long id) {
        Optional<Author> authorOpt = authorRepository.findById(id);
        if(authorOpt.isEmpty()) {
            return Optional.empty();
        }
        Author author = authorOpt.get();
        AuthorDto authorDto = AuthorMapper.INSTANCE.authorToAuthorDto(author);
        return Optional.ofNullable(authorDto);
    }

    public AuthorDto getAuthorDto(Author author) {
        return AuthorMapper.INSTANCE.authorToAuthorDto(author);
    }

    public List<AuthorDto> getAuthorDtoList(List<Author> authorList) {
        return AuthorMapper.INSTANCE.getAuthorDtoList(authorList);
    }
}
