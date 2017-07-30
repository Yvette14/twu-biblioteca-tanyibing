package com.twu.biblioteca;

public class Book {
  private String title;
  private String author;
  private String publishedYear;

  public Book(String title, String author, String publishedYear) {
    this.title = title;
    this.author = author;
    this.publishedYear = publishedYear;
  }

  public String getBookDetail() {
    return String.format("title:%-2s author:%-2s publishedYear:%-2s", title, author, publishedYear);
  }
}
