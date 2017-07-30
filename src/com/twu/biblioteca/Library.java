package com.twu.biblioteca;

import java.io.*;
import java.util.List;

public class Library {
  private PrintStream printStream;
  private List<Book> bookList;
  private List<Book> checkedOutBooks;
  private List<Movie> movieList;
  private List<Movie> checkedOutMovies;
  private List<User> users;
  private Display display;

  public Library(PrintStream printStream, List<Book> bookList, List<Book> checkedOutBooks, List<Movie> movieList, List<Movie> checkedOutMovies, List<User> users, Display display) {
    this.printStream = printStream;
    this.bookList = bookList;
    this.checkedOutBooks = checkedOutBooks;
    this.movieList = movieList;
    this.checkedOutMovies = checkedOutMovies;
    this.users = users;
    this.display = display;
  }

  public void displayBooks() {
    for (Book book : bookList) {
      printStream.println(book.getBookDetail());
    }
  }

  public void displayBooksWithNumber() {
    for (int x = 0; x < bookList.size(); x++) {
      printStream.print(x + 1 + ". ");
      printStream.println(bookList.get(x).getBookDetail());
    }
  }

  public void displayCheckedOutBooksWithNumber() {
    for (int x = 0; x < checkedOutBooks.size(); x++) {
      printStream.print(x + 1 + ". ");
      printStream.println(checkedOutBooks.get(x).getBookDetail());
    }
  }

  public void checkOutBook() {
    printStream.println("Which book would you like to check out?");
    displayBooksWithNumber();
    String input = display.getUserInput();
    int index = Integer.parseInt(input) - 1;
    if (index >= 0 && index < bookList.size()) {
      Book book = bookList.remove(index);
      checkedOutBooks.add(book);
      printStream.println("Thank you! Enjoy your book.");
    } else {
      printStream.println("That book is not available.");
    }
  }

  public void returnBook() {
    printStream.println("Which book would you like to return?");
    displayCheckedOutBooksWithNumber();
    String input = display.getUserInput();
    int index = Integer.parseInt(input) - 1;
    if (index >= 0 && index < checkedOutBooks.size()) {
      Book book = checkedOutBooks.remove(index);
      bookList.add(book);
      printStream.println("Thank you for returning the book.");
    } else {
      printStream.println("That is not a valid book to return.");
    }
  }

  public void displayMovie() {
    for (Movie movie : movieList) {
      printStream.println(movie.getMoiveDetail());
    }
  }

  public void displayMovieWithNumber() {
    for (int x = 0; x < movieList.size(); x++) {
      printStream.print(x + 1 + ". ");
      printStream.println(movieList.get(x).getMoiveDetail());
    }
  }

  public void checkOutMovie() {
    printStream.println("Which movie would you like to check out?");
    displayMovieWithNumber();
    String input = display.getUserInput();
    int index = Integer.parseInt(input) - 1;
    if (index >= 0 && index < movieList.size()) {
      Movie movie = movieList.remove(index);
      checkedOutMovies.add(movie);
      printStream.println("Thank you! Enjoy your movie.");
    } else {
      printStream.println("That movie is not available.");
    }
  }

  public int getUserLoginInformation() {
    printStream.println("Please input your library number: ");
    String libraryNumber = display.getUserInput();
    printStream.println("Please input your password: ");
    String password = display.getUserInput();
    return findUserIndexByLibraryNumebrAndPassword(libraryNumber, password);
  }

  private int findUserIndexByLibraryNumebrAndPassword(String libraryNumber, String password) {
    int index = -1;
    for (int i=0;i<users.size();i++) {
      if (users.get(i).checkLogin(libraryNumber, password)) {
        index = i;
      }
    }
    return index;
  }

  public void displayUserInformation(int index) {
    printStream.println(users.get(index).getUserDetail());
  }
}
