package com.twu.biblioteca;

import java.io.*;
import java.util.*;

public class BibliotecaApp {
  public static void main(String[] args) {
    PrintStream printStream = System.out;
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);
    Display display = new Display(printStream, reader);
    Library library = new Library(printStream, bookList());
    Menu menu = new Menu(printStream, display, library);
    menu.selectAnOption();
  }

  public static List<Book> bookList() {
    List<Book> bookList = new ArrayList<Book>();
    Book book1 = new Book("Book1 name", "Book1 author", "2000");
    bookList.add(book1);
    Book book2 = new Book("Book2 name", "Book2 author", "2010");
    bookList.add(book2);

    return bookList;
  }
}
