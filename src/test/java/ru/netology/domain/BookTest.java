package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

  private Product product = new Book(1, "book1", 50, "Author");


  @Test
  public void shouldHaveAllFieldsAndMethodFromSuperClass() {
    Book book = new Book();
  }

  @Test
  public void shouldCastFromBaseClass() {
    Product product = new Book();
    if (product instanceof Book) {
      Book book = (Book) product;
    }
  }

  @Test
  public void shouldUseOverridedMethod() {
    Product product = new Book();
    product.toString();
  }

  @Test
  public void shouldFindBookName() {
    boolean isMatch = product.matches("book1");
    assertTrue(isMatch);
  }

  @Test
  public void shouldNotFindBookName() {
    boolean isMatch = product.matches("book5");
    assertFalse(isMatch);
  }

  @Test
  public void shouldFindBookAuthor() {
    boolean isMatch = product.matches("Author");
    assertTrue(isMatch);
  }

  @Test
  public void shouldNotFindBookAuthor() {
    boolean isMatch = product.matches("Petrov");
    assertFalse(isMatch);
  }

}
