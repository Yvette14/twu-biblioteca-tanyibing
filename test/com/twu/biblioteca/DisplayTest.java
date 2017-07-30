package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.mockito.Mockito.*;

public class DisplayTest {
  private Display display;
  private PrintStream printStream;
  private BufferedReader bufferedReader;

  @Before
  public void setUp() throws Exception {
    printStream = mock(PrintStream.class);
    bufferedReader = mock(BufferedReader.class);
    display = new Display(printStream, bufferedReader);
  }

  @Test
  public void should_display_welcome_message() {
    display.displayWelcomeMessage();
    verify(printStream).println("Welcome");
  }
}
