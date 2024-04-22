package br.com.kamatech.productmanagement.repositories;

import br.com.kamatech.productmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
