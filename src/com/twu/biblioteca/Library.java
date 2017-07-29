package com.twu.biblioteca;

import java.io.*;
import java.util.List;

public class Library {
  public PrintStream printStream;
  public List<Book> bookList;

  public Library(PrintStream printStream, List<Book> bookList) {
    this.printStream = printStream;
    this.bookList = bookList;
  }

  public void displayBooks() {
    for(Book book:bookList){
      printStream.println(book.getBookDetail());
    }
  }
}
