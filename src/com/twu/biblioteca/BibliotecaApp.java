package com.twu.biblioteca;

import java.io.*;
import java.util.*;

public class BibliotecaApp {
  public static void main(String[] args) {
    PrintStream printStream = System.out;
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);
    Display display = new Display(printStream, reader);
    Library library = new Library(printStream, bookList(), checkedOutBooks(), movieList(), checkedOutMovies(), users(), display);
    Menu menu = new Menu(printStream, display, library);
    int index = library.getUserLoginInformation();
    while (index==-1){
      printStream.println("You might input wrong library_number or password,please input again");
      index = library.getUserLoginInformation();
    }
    menu.selectAnOption(index);
  }

  public static List<Book> bookList() {
    List<Book> bookList = new ArrayList<Book>();
    Book book1 = new Book("Book1 name", "Book1 author", "2000");
    bookList.add(book1);
    Book book2 = new Book("Book2 name", "Book2 author", "2010");
    bookList.add(book2);

    return bookList;
  }

  public static List<Book> checkedOutBooks() {
    List<Book> checkedOutBooks = new ArrayList<Book>();
    Book book = new Book("Book", "Author", "2014");
    checkedOutBooks.add(book);
    return checkedOutBooks;
  }

  public static List<Movie> movieList() {
    List<Movie> movieList = new ArrayList<Movie>();
    Movie movie1 = new Movie("Movie1", "2010", "director1", 2);
    Movie movie2 = new Movie("Movie2", "2011", "director2", 7);
    movieList.add(movie1);
    movieList.add(movie2);
    return movieList;
  }

  public static List<Movie> checkedOutMovies() {
    List<Movie> checkedOutMovies = new ArrayList<Movie>();
    Movie movie = new Movie("Movie", "2009", "director", 3);
    checkedOutMovies.add(movie);
    return checkedOutMovies;
  }

  public static List<User> users() {
    List<User> users = new ArrayList<User>();
    User user1 = new User("name1", "user1@163.com", "18311112222", "101-1111", "123456");
    User user2 = new User("name2", "user2@163.com", "15211112222", "111-1111", "123456");
    users.add(user1);
    users.add(user2);
    return users;
  }
}
