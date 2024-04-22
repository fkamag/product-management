package br.com.kamatech.productmanagement.repositories;

import br.com.kamatech.productmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
