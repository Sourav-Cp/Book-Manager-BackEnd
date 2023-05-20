package com.Sourav.Book_Manager;

import java.util.*;

public class BookRepository {
   private Map<Integer,Book> bookData = new HashMap<>();

   public void addBook(Book book)
   {
      bookData.put(book.getId(), book);
   }

   public Optional<Book> getById(Integer id)
   {
      if(bookData.containsKey(id))
      {
         Book bookToReturn = bookData.get(id);
         return Optional.of(bookToReturn);
      }
      return Optional.empty();
   }

   public List<Book> getAllBooks()
   {
      return new ArrayList<>(bookData.values());
   }

   public void update(Book book)
   {
      addBook(book);
   }

   public void removeBook(Integer id)
   {
      bookData.remove(id);
   }
}
