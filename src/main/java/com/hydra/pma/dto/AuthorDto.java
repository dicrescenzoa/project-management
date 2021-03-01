package com.hydra.pma.dto;

import java.util.List;

public class AuthorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<BookDto> books;

    public AuthorDto() {
    }

    public AuthorDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
