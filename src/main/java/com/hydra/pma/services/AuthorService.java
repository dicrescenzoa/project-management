package com.hydra.pma.services;

import com.hydra.pma.dto.AuthorDto;
import com.hydra.pma.entities.Author;
import com.hydra.pma.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    public AuthorDto getAuthorDto(Author author) {
        return authorMapper.convert(author);
    }

    public List<AuthorDto> getAuthorDtoList(List<Author> authorList) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        authorList.forEach((author) -> populateDtoList(author, authorDtoList));
        return authorDtoList;
    }

    private void populateDtoList(Author author, List<AuthorDto> authorDtoList) {
        AuthorDto dto = authorMapper.convert(author);
        authorDtoList.add(dto);
    }
}
