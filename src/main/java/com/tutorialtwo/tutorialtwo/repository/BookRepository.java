package com.tutorialtwo.tutorialtwo.repository;

import com.tutorialtwo.tutorialtwo.domain.Book;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
