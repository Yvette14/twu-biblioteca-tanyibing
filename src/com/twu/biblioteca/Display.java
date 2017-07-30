package com.twu.biblioteca;

import java.io.*;

public class Display {
  private PrintStream printStream;
  private BufferedReader bufferedReader;

  public Display(PrintStream printStream, BufferedReader bufferedReader) {
    this.printStream = printStream;
    this.bufferedReader = bufferedReader;
  }

  public String getUserInput() {
    String input = "";
    try {
      input = bufferedReader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    printStream.println();
    return input;
  }

  public void displayWelcomeMessage() {
    printStream.println("Welcome");
  }
}
