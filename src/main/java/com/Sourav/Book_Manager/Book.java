package com.Sourav.Book_Manager;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Integer pages;

    public Book(){

    }

    public Book(Integer id, String title, String author, Integer pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}
