package br.com.kamatech.productmanagement.exceptions;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException() {
    super("Categoria não encontrada");
  }

}
