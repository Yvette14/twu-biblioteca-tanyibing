package com.twu.biblioteca;

public class User {
  private String name;
  private String emailAddress;
  private String phoneNumber;
  private String libraryNumber;
  private String password;

  public String getLibraryNumber() {
    return libraryNumber;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public User(String name, String emailAddress, String phoneNumber, String libraryNumber, String password) {
    this.name = name;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;
    this.libraryNumber = libraryNumber;
    this.password = password;
  }

  public String getUserDetail() {
    return String.format("name:%-2s email:%-2s phoneNumber:%s", name, emailAddress, phoneNumber);
  }

  public boolean checkLogin(String inputLibraryNumber,String inputPassword) {
    return (inputLibraryNumber.equals(libraryNumber)) && (inputPassword.equals(password));
  }
}
