
package com.example.api.controller;

import javax.validation.Valid;
import java.util.List;
import com.example.api.entity.Book;
import com.example.api.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController

@RequestMapping("/api/books")

@CrossOrigin
public class BookController {

    @Autowired 
    private BookRepository bookRepository;
    
   
    @GetMapping("")
    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }

   
    @PostMapping("")
  
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book) {
        
        return bookRepository.save(book);
    }

   
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody Book newBook) {
        
        Book book = this.fetchBook(bookId);
      
        book.setBookTitle(newBook.getBookTitle());

        return bookRepository.save(book);
    } 
    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return this.fetchBook(bookId);
    } 
  
    @DeleteMapping("/{id}")
  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = this.fetchBook(bookId);
        bookRepository.delete(book);
    }

    
    public Book fetchbook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found")
        );
        return book;
    }
}