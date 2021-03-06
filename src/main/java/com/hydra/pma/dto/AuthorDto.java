package com.hydra.pma.dto;

import lombok.*;

import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<Long> books;

    public AuthorDto() {
    }

    public AuthorDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
