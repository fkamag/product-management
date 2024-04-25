package br.com.kamatech.productmanagement.controllers;

import br.com.kamatech.productmanagement.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

}
