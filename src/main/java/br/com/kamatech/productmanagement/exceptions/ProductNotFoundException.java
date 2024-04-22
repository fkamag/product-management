package br.com.kamatech.productmanagement.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException() {
    super("Produto não encontrado");
  }

}
