package com.twu.biblioteca;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BookTest {
  @Test
  public void should_return_book_detail() {
    Book book = new Book("Head First Java", " Kathy Sierra", "2007");
    assertEquals("title:Head First Java author: Kathy Sierra publishedYear:2007", book.getBookDetail());
  }
}
