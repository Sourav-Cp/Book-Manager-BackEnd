package com.Sourav.Book_Manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class BookController {

    BookService bookService = new BookService();
    @PostMapping("/add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book)
    {
      String str = bookService.addBook(book);
       return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    @GetMapping("/get-book")
    public ResponseEntity<Book> getBook(@RequestParam Integer id)
    {
       try
       {
           Book book = bookService.getById(id);
           return new ResponseEntity<>(book,HttpStatus.OK);
       }
       catch(BookIdInvalidException ex)
       {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/get-book/{name}")
    public ResponseEntity<Book> getBooksByName(@PathVariable String name)
    {
       try
       {
          return new ResponseEntity<>(bookService.getByName(name),HttpStatus.OK);
       }
       catch(BookIdInvalidException ex)
       {
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/update-book-pages")
    public ResponseEntity<Book> updatePages(@RequestParam Integer id,@RequestParam Integer pages)
    {
       try
       {
           Book book = bookService.updatePages(id,pages);
           return new ResponseEntity<>(book,HttpStatus.CREATED);
       }
       catch (BookIdInvalidException ex)
       {
           return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
       }
    }

    public ResponseEntity<String> deleteBooks(@PathVariable Integer id)
    {
        bookService.removeBook(id);
        return new ResponseEntity<>("Book deleted",HttpStatus.OK);
    }
}
