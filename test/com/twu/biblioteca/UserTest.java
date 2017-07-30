package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserTest {
  private User user;

  @Before
  public void setUp() {
    user = new User("hiro", "test@163.com", "13111111111", "101-1111", "123456");
  }

  @Test
  public void should_return_user_detail() {
    assertEquals("name:hiro email:test@163.com phoneNumber:13111111111", user.getUserDetail());
  }

  @Test
  public void should_login_successfully() {
    assertTrue(user.checkLogin("101-1111", "123456"));
  }

  @Test
  public void should_login_failed() {
    assertFalse(user.checkLogin("101-1111", "123443"));
  }
}
