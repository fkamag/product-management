package br.com.kamatech.productmanagement.controllers;

import br.com.kamatech.productmanagement.controllers.dtos.BrandDto;
import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.services.BrandService;
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
@RequestMapping("/brands")
public class BrandController {

  @Autowired
  private BrandService service;

  @PostMapping
  public ResponseEntity<BrandDto> create(@RequestBody Brand brand) {
    Brand brandDb = service.create(brand);
    BrandDto brandDto = BrandDto.fromEntity(brandDb);
    return ResponseEntity.status(HttpStatus.CREATED).body(brandDto);
  }

  @GetMapping
  public ResponseEntity<List<BrandDto>> findAll() {
    List<Brand> brands = service.findAll();
    List<BrandDto> brandDtos = brands.stream()
        .map(BrandDto::fromEntity)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(brandDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BrandDto> findById(@PathVariable Long id) {
    Brand brand = service.findById(id);
    BrandDto brandDto = BrandDto.fromEntity(brand);
    return ResponseEntity.status(HttpStatus.OK).body(brandDto);
  }

  @PutMapping
  public ResponseEntity<BrandDto> update(@RequestBody Brand brand) {
    Brand brandDb = service.update(brand);
    BrandDto brandDto = BrandDto.fromEntity(brandDb);
    return ResponseEntity.status(HttpStatus.OK).body(brandDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    String message = service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

}
