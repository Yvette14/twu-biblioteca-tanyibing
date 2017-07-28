package com.twu.biblioteca;

import java.io.PrintStream;

public class MenuTest {
  PrintStream printStream;
  Display display;

  public void displayMenu(){
    printStream.println("-------------------");
    printStream.println("Select an option:  ");
    printStream.println("1. List Books");
    printStream.println("Q. Quit");
    printStream.println("-------------------");
  }
}
