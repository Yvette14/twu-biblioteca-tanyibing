package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Display {
  private PrintStream printStream;
  private BufferedReader bufferedReader;

  public Display(PrintStream printStream, BufferedReader bufferedReader) {
    this.printStream = printStream;
    this.bufferedReader = bufferedReader;
  }


  public void displayWelcomeMessage() {
    printStream.println("Welcome");
  }
}
