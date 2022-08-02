package com.poc.lms.endpoints;

import com.poc.lms.model.Book;
import com.poc.lms.services.BookManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/")
public class BookManagement{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final BookManagementService bookManagementService;

    public BookManagement(BookManagementService bookManagementService){
        this.bookManagementService = bookManagementService;
    }

    @GetMapping(value = "/{bookName}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book bookDetails(@PathVariable(value = "bookName") String bookName){
        logger.info("request received to fetch book details for: [{}]", bookName);

        return bookManagementService.fetchBook(bookName);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book bookDetails(@RequestBody Book book){
        logger.info("request received to add a new book in the system: [{}]", book);

        return bookManagementService.save(book);
    }
}
