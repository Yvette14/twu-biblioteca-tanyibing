package com.twu.biblioteca;

import java.io.PrintStream;

public class Menu {
  PrintStream printStream;
  Display display;
  Library library;

  public Menu(PrintStream printStream, Display display, Library library) {
    this.printStream = printStream;
    this.display = display;
    this.library = library;
  }

  public void displayMenu(){
    printStream.println("-------------------");
    printStream.println("Select an option:  ");
    printStream.println("1. List Books");
    printStream.println("Q. Quit");
    printStream.println("-------------------");
  }

  public void selectAnOption(){
    display.displayWelcomeMessage();
    displayMenu();
    String input = display.getUserInput();
    while (!input.equals("Q")) {
      if (input.equals("1")) {
        library.displayBooks();

      } else {
        printStream.println("Select a valid option!");

      }

      displayMenu();
      input = display.getUserInput();
    }
  }
}
