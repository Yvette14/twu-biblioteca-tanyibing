package com.twu.biblioteca;

public class Movie {
  private String name;
  private String year;
  private String director;
  private int rate;

  public String getName() {
    return name;
  }

  public String getYear() {
    return year;
  }

  public String getDirector() {
    return director;
  }

  public int getRate() {
    return rate;
  }

  public Movie(String name, String year, String director, int rate) {
    this.name = name;
    this.year = year;
    this.director = director;
    this.rate = rate;
  }

  public String getMoiveDetail() {
    return String.format("movie:%-2s year:%-2s director:%-2s rate:%d", name, year, director, rate);
  }
}
