package com.twu.biblioteca;


import org.junit.*;

import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryTest {
  private PrintStream printStream;
  private List<Book> bookList;
  private List<Book> checkedOutBooks;
  private Display display;
  private Library library;
  private Book book1;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    display = mock(Display.class);
    checkedOutBooks = new ArrayList<Book>();
    bookList = new ArrayList<Book>();
    book1 = mock(Book.class);
    bookList.add(book1);

    library = new Library(printStream, bookList, checkedOutBooks, display);

  }

  @Test
  public void should_list_one_book_when_book_list_has_only_one() {
    library.displayBooks();
    verify(book1).getBookDetail();
  }

  @Test
  public void should_list_books() {
    Book book2 = mock(Book.class);
    bookList.add(book2);
    library.displayBooks();
    for (Book book : bookList) {
      verify(book).getBookDetail();
    }
  }

  @Test
  public void should_list_books_with_number() {
    Book book2 = mock(Book.class);
    bookList.add(book2);
    library.displayBooksWithNumber();
    for (Book book : bookList) {
      verify(book).getBookDetail();
    }

    verify(printStream).print("1. ");
    verify(printStream).print("2. ");
  }

  @Test
  public void should_checkout_the_selected_book() {
    when(display.getUserInput()).thenReturn("1");
    library.checkOutBook();
    verify(printStream).println("Thank you! Enjoy the book.");
  }

  @Test
  public void should_inform_user_when_checkout_book_failed() {
    when(display.getUserInput()).thenReturn("1013");
    library.checkOutBook();
    verify(printStream).println("That book is not available.");
  }

  @Test
  public void should_return_book_successfully() {
    when(display.getUserInput()).thenReturn("1");
    library.returnBook();
    verify(printStream).println("Thank you for returning the book.");
  }

  @Test
  public void should_inform_user_when_return_book_failed() {
    when(display.getUserInput()).thenReturn("909");
    library.returnBook();
    verify(printStream).println("That is not a valid book to return.");
  }
}
