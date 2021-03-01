package com.hydra.pma.dao;

import com.hydra.pma.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
