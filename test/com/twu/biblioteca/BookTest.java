package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
  @Test
  public void should_return_book_detail() {
    Book book = new Book("野人", "麦洛洛", "2010");
    assertEquals("The book is 野人\nThe book is written by 麦洛洛\nThe book is published in 2010\n", book.getBookDetail());
  }
}
