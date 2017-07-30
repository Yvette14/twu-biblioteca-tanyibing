package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {
  PrintStream printStream;
  Display display;
  Library library;

  public Menu(PrintStream printStream, Display display, Library library) {
    this.printStream = printStream;
    this.display = display;
    this.library = library;
  }

  public void displayMenu() {
    printStream.println("-------------------");
    printStream.println("Select an option:  ");
    printStream.println("1. List Books");
    printStream.println("2. Check Out Book");
    printStream.println("3. Return Book");
    printStream.println("Q. Quit");
    printStream.println("-------------------");
  }

  public void selectAnOption() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    display.displayWelcomeMessage();
    displayMenu();
    String input = display.getUserInput();
    if (!input.equals("Q")) {
      map.put(input, Integer.parseInt(input));
    }
    while (!input.equals("Q")) {
      map.put(input, Integer.parseInt(input));
      switch (map.get(input)) {
        case 1:
          library.displayBooks();
          break;
        case 2:
          library.checkOutBook();
          break;
        case 3:
          library.returnBook();
        default:
          printStream.println("Select a valid option!");
      }

      displayMenu();
      input = display.getUserInput();
    }
  }
}
