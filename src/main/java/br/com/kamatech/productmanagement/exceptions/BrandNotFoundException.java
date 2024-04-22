package br.com.kamatech.productmanagement.exceptions;

public class BrandNotFoundException extends RuntimeException {

  public BrandNotFoundException() {
    super("Marca não encontrada");
  }

}
