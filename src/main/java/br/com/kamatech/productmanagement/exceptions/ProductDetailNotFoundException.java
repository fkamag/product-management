package br.com.kamatech.productmanagement.exceptions;

public class ProductDetailNotFoundException extends RuntimeException {
  public ProductDetailNotFoundException() {
    super("Detalhes do produto não encontrado");
  }

}
