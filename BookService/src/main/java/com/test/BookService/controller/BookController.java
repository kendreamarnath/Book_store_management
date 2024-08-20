package com.test.BookService.controller;

import com.test.BookService.dto.BookDto;
import com.test.BookService.exception.BookNotFoundException;
import com.test.BookService.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public void addBook(@Valid @RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }
//
//    @PostMapping
//    public void addBook(@Valid @RequestBody BookDto bookDto) {
//        bookService.addBook(bookDto);
//    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBook(id, bookDto);
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @ExceptionHandler(BookNotFoundException.class)
    public String handleBookNotFoundException(BookNotFoundException ex) {
        return ex.getMessage();
    }
}
