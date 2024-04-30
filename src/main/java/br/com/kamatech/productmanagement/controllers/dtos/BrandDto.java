package br.com.kamatech.productmanagement.controllers.dtos;

import br.com.kamatech.productmanagement.entities.Brand;

public record BrandDto(
    Long id,
    String name
) {

  public static BrandDto fromEntity(Brand brand) {
    return new BrandDto(
        brand.getId(),
        brand.getName()
    );
  }

}
