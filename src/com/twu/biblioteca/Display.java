package com.twu.biblioteca;

import java.io.*;

public class Display {
  private PrintStream printStream;
  private BufferedReader bufferedReader;

  public Display(PrintStream printStream, BufferedReader bufferedReader) {
    this.printStream = printStream;
    this.bufferedReader = bufferedReader;
  }

  public String getUserInput(){
    String input = "";
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      input = is.readLine();
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    return input;
  }

  public void displayWelcomeMessage() {
    printStream.println("Welcome");
  }
}
