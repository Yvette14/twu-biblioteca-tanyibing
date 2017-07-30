package com.twu.biblioteca;

import org.junit.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
  private Library library;
  private PrintStream printStream;
  private Display display;
  private Menu menu;
  private List<Book> bookList;
  private List<Book> checkedOutBooks;

  @Before
  public void setUp() {
    library = mock(Library.class);
    printStream = mock(PrintStream.class);
    display = mock(Display.class);

    menu = new Menu(printStream, display, library);

    bookList = new ArrayList<Book>();
    Book book1 = mock(Book.class);
    Book book2 = mock(Book.class);
    bookList.add(book1);
    bookList.add(book2);

    checkedOutBooks = new ArrayList<Book>();
    Book book3 = mock(Book.class);
    Book book4 = mock(Book.class);
    checkedOutBooks.add(book3);
    checkedOutBooks.add(book4);
  }

  @Test
  public void should_display_welcome_message() {
    when(display.getUserInput()).thenReturn("1","Q");
    menu.selectAnOption(1);
    verify(display).displayWelcomeMessage();
  }

  @Test
  public void should_display_message_when_input_invalid_option() {
    when(display.getUserInput()).thenReturn("233","Q");
    menu.selectAnOption(1);
    verify(printStream).println("Select a valid option!");
  }

  @Test
  public void should_display_books() {
    when(display.getUserInput()).thenReturn("1", "Q");
    menu.selectAnOption(1);
    verify(library).displayBooks();
  }

  @Test
  public void should_check_out_book() {
    when(display.getUserInput()).thenReturn("2", "1", "Q");
    menu.selectAnOption(1);
    verify(library).checkOutBook();
  }

  @Test
  public void should_return_book() {
    when(display.getUserInput()).thenReturn("3", "1", "Q");
    menu.selectAnOption(1);
    verify(library).returnBook();
  }
}
