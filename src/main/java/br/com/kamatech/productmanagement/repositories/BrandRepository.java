package br.com.kamatech.productmanagement.repositories;

import br.com.kamatech.productmanagement.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
