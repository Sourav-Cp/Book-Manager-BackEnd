package com.Sourav.Book_Manager;

import java.util.List;
import java.util.Optional;

public class BookService {

    BookRepository bookRepository = new BookRepository();

    public String addBook(Book book)
    {
        bookRepository.addBook(book);
        return "Book Added SuccessFully";
    }

    public Book getById(Integer id) throws BookIdInvalidException
    {
       Optional<Book> bookOptional = bookRepository.getById(id);
       if(bookOptional.isEmpty())
       {
           throw new BookIdInvalidException(id);
       }
       return bookOptional.get();
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.getAllBooks();
    }
    public Book getByName(String name) throws BookNameInvalidException
    {
        List<Book> books = bookRepository.getAllBooks();

        for(Book book : books)
        {
            if(book.getTitle().equals(name))
            {
                return book;
            }
        }
        throw new BookNameInvalidException("Book Name Invalid");
    }

    public Book updatePages(Integer id,Integer pages) throws BookIdInvalidException
    {
        Book book = getById(id);
        book.setPages(pages);
        bookRepository.update(book);
        return book;
    }
    public void removeBook(Integer id)
    {
        bookRepository.removeBook(id);
    }
}
