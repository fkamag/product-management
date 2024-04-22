package br.com.kamatech.productmanagement.controllers;

import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.entities.Product;
import br.com.kamatech.productmanagement.services.BrandService;
import br.com.kamatech.productmanagement.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product productDb = service.create(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(productDb);
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> products = service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product product = service.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }

  @PutMapping
  public ResponseEntity<Product> update(@RequestBody Product product) {
    Product productDb = service.update(product);
    return ResponseEntity.status(HttpStatus.OK).body(productDb);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    String message = service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

}
