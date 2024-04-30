package br.com.kamatech.productmanagement.controllers.dtos;

import br.com.kamatech.productmanagement.entities.ProductDetail;

public record ProdutctDetailDto(
    Long id,
    Integer availableStock,
    Double unitPrice
) {

  public static ProdutctDetailDto fromEntity(ProductDetail productDetail) {
    return new ProdutctDetailDto(
        productDetail.getId(),
        productDetail.getAvailableStock(),
        productDetail.getUnitPrice()
    );
  }

}
