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
  private List<Movie> movieList;
  private List<Movie> checkedOutMovies;
  private List<User> users;
  private Display display;
  private Library library;
  private Book book1;
  private Movie movie1;
  private User user;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    display = mock(Display.class);
    checkedOutBooks = new ArrayList<Book>();

    bookList = new ArrayList<Book>();
    book1 = mock(Book.class);
    bookList.add(book1);

    movieList = new ArrayList<Movie>();
    movie1 = mock(Movie.class);
    movieList.add(movie1);

    users = new ArrayList<User>();
    user = mock(User.class);
    users.add(user);

    library = new Library(printStream, bookList, checkedOutBooks, movieList, checkedOutMovies, users, display);

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
  public void should_list_movies() {
    Movie movie2 = mock(Movie.class);
    movieList.add(movie2);
    library.displayMovie();
    for (Movie movie : movieList) {
      verify(movie).getMoiveDetail();
    }
  }

  @Test
  public void should_list_movies_with_number() {
    Movie movie2 = mock(Movie.class);
    movieList.add(movie2);
    library.displayMovieWithNumber();
    for (Movie movie : movieList) {
      verify(movie).getMoiveDetail();
    }

    verify(printStream).print("1. ");
    verify(printStream).print("2. ");
  }

  @Test
  public void should_checkout_the_selected_movie() {
    when(display.getUserInput()).thenReturn("1");
    library.checkOutMovie();
    verify(printStream).println("Thank you! Enjoy the movie.");
  }

  @Test
  public void should_inform_user_when_check_out_movie_failed() {
    when(display.getUserInput()).thenReturn("234");
    library.checkOutMovie();
    verify(printStream).println("That movie is not available.");
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
