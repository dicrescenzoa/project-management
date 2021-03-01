package com.hydra.pma.dto;

import com.hydra.pma.entities.Author;

import java.util.List;

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

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        return id != null ? id.equals(bookDto.id) : bookDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
