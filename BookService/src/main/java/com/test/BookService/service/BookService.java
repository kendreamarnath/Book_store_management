package com.test.BookService.service;

import com.test.BookService.dto.BookDto;
import com.test.BookService.exception.BookNotFoundException;
import com.test.BookService.model.Book;
import com.test.BookService.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection of BookRepository
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Adds a new book
    public void addBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.title());
        book.setAuthor(bookDto.author());
        book.setPrice(bookDto.price());
        book.setStock(bookDto.stock());
        bookRepository.save(book);
    }


    // Deletes a book by its ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Updates an existing book
    public void updateBook(Long id, BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDto.title());
            book.setAuthor(bookDto.author());
            book.setPrice(bookDto.price());
            book.setStock(bookDto.stock());
            bookRepository.save(book);
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    // Retrieves a book by its ID
    public BookDto getBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getStock());
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    // Retrieves all books
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }
}
