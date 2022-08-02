package com.poc.lms.services;

import com.poc.lms.model.Book;
import com.poc.lms.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookManagementService{

    private final BookRepository bookRepository;

    public BookManagementService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        book.setIsbn(UUID.randomUUID().toString());
        return bookRepository.save(book);
    }

    public Book fetchBook(String bookName){
        return bookRepository.findByName(bookName);
    }
}
