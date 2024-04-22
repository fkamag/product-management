package br.com.kamatech.productmanagement.controllers;

import br.com.kamatech.productmanagement.entities.Category;
import br.com.kamatech.productmanagement.services.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryService service;

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {
    Category categoryDb = service.create(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryDb);
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categories = service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    Category category = service.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(category);
  }

  @PutMapping
  public ResponseEntity<Category> update(@RequestBody Category category) {
    Category categoryDb = service.update(category);
    return ResponseEntity.status(HttpStatus.OK).body(categoryDb);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    String message = service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

}
