package com.hydra.pma.dto;

import lombok.*;

@Data
public class AuthorDto {
    private Long id;
    private String firstname;
    private String lastname;

    public AuthorDto() {
    }

    public AuthorDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
