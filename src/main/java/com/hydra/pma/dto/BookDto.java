package com.hydra.pma.dto;

import lombok.*;

import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private List<AuthorDto> authors;

    public BookDto() {
    }

    public BookDto(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
