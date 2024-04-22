package br.com.kamatech.productmanagement.services;

import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.entities.Product;
import br.com.kamatech.productmanagement.exceptions.BrandNotFoundException;
import br.com.kamatech.productmanagement.exceptions.ProductNotFoundException;
import br.com.kamatech.productmanagement.repositories.BrandRepository;
import br.com.kamatech.productmanagement.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Product create(Product product) {
    return repository.save(product);
  }

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(ProductNotFoundException::new);
  }

  public Product update(Product product) {
    return repository.save(product);
  }

  public String deleteById(Long id) {
    Product product = findById(id);
    repository.delete(product);
    return String.format("Id %d deletado com sucesso", id);
  }

}
