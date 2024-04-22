package br.com.kamatech.productmanagement.services;

import br.com.kamatech.productmanagement.entities.Category;
import br.com.kamatech.productmanagement.exceptions.CategoryNotFoundException;
import br.com.kamatech.productmanagement.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public Category create(Category category) {
    return repository.save(category);
  }

  public List<Category> findAll() {
    return repository.findAll();
  }

  public Category findById(Long id) {
    return repository.findById(id)
        .orElseThrow(CategoryNotFoundException::new);
  }

  public Category update(Category category) {
    return repository.save(category);
  }

  public String deleteById(Long id) {
    Category category = findById(id);
    repository.delete(category);
    return String.format("Id %d deletado com sucesso", id);
  }

}
