package com.poc.lms.repositories;

import com.poc.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByName(String bookName);
}
