package br.com.kamatech.productmanagement.services;

import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.exceptions.BrandNotFoundException;
import br.com.kamatech.productmanagement.repositories.BrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

  @Autowired
  private BrandRepository repository;

  public Brand create(Brand brand) {
    return repository.save(brand);
  }

  public List<Brand> findAll() {
    return repository.findAll();
  }

  public Brand findById(Long id) {
    return repository.findById(id)
        .orElseThrow(BrandNotFoundException::new);
  }

  public Brand update(Brand brand) {
    return repository.save(brand);
  }

  public String deleteById(Long id) {
    Brand brand = findById(id);
    repository.delete(brand);
    return String.format("Id %d deletado com sucesso", id);
  }

}
