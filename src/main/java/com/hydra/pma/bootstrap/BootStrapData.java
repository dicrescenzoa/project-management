package com.hydra.pma.bootstrap;

import com.hydra.pma.dao.AuthorRepository;
import com.hydra.pma.dao.BookRepository;
import com.hydra.pma.dao.PublisherRepository;
import com.hydra.pma.entities.Author;
import com.hydra.pma.entities.Book;
import com.hydra.pma.entities.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("name1", "lastname1");
        Book book1 = new Book("booktitle", "bookisbn");
        Publisher publisher1 = new Publisher("name", "street", "milan", "italy", "nope");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        System.out.println("Started with boostrap");
    }
}
