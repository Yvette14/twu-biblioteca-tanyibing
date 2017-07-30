package com.twu.biblioteca;

import java.io.*;
import java.util.List;

public class Library {
  private PrintStream printStream;
  private List<Book> bookList;
  private List<Book> checkedOutBooks;
  private Display display;

  public Library(PrintStream printStream, List<Book> bookList, List<Book> checkedOutBooks, Display display) {
    this.printStream = printStream;
    this.bookList = bookList;
    this.checkedOutBooks = checkedOutBooks;
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
}
