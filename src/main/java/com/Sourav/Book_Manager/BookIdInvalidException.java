package com.Sourav.Book_Manager;

public class BookIdInvalidException extends RuntimeException{

    public BookIdInvalidException(Integer id)
    {
        super("Book not present with id:"+id);
    }
}
