package br.com.kamatech.productmanagement.controllers.dtos;

import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.entities.Product;
import br.com.kamatech.productmanagement.entities.ProductDetail;

public record ProductDto(
  Long id,
  String nane,
  String description,
  ProdutctDetailDto produtctDetail,
  Brand brand
) {

  public static ProductDto fromEntity(Product product) {
    ProdutctDetailDto produtctDetailDto = product.getProductDetail() != null ?
        ProdutctDetailDto.fromEntity(product.getProductDetail()) : null;

    return new ProductDto(
        product.getId(),
        product.getName(),
        product.getDescription(),
        produtctDetailDto,
        product.getBrand()
    );
  }

}
