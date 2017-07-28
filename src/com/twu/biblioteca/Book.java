package com.twu.biblioteca;

public class Book {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(String publishedYear) {
    this.publishedYear = publishedYear;
  }

  private String author;
  private String publishedYear;

  public Book(String name, String author, String publishedYear) {
    this.name = name;
    this.author = author;
    this.publishedYear = publishedYear;
  }

  public String getBookDetail(){
    String result = "The book is " + name + "\n";
    result += "The book is written by " + author + "\n";
    result += "The book is published in " + publishedYear + "\n";
    return result;
  }
}
