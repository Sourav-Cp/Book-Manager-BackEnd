package com.Sourav.Book_Manager;

public class BookNameInvalidException extends RuntimeException{
    public BookNameInvalidException(String str)
    {
        super(str);
    }
}
