package com.hydra.pma.dao;

import com.hydra.pma.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
