package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {
  private PrintStream printStream;
  private List<Book> bookList;

  public BibliotecaApp(PrintStream printStream, List<Book> bookList) {
    this.printStream = printStream;
    this.bookList = bookList;
  }

  public void displayBooks() {
    for(Book book:bookList){
      printStream.println(book.getBookDetail());
    }
  }
}
