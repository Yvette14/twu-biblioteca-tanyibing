package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
  @Test
  public void should_return_movie_detail() {
    Movie movie = new Movie("Interstellar", "2014", "Christopher Nolan", 2);
    assertEquals("movie:Interstellar year:2014 director:Christopher Nolan rate:2", movie.getMoiveDetail());
  }
}
