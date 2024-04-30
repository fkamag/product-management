package br.com.kamatech.productmanagement.controllers;

import br.com.kamatech.productmanagement.controllers.dtos.ProductDto;
import br.com.kamatech.productmanagement.controllers.dtos.ProdutctDetailDto;
import br.com.kamatech.productmanagement.entities.Brand;
import br.com.kamatech.productmanagement.entities.Product;
import br.com.kamatech.productmanagement.entities.ProductDetail;
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
  @Autowired
  private BrandService brandService;

  @PostMapping
  public ResponseEntity<ProductDto> create(@RequestBody Product product) {
    Product productDb = service.create(product);
    ProductDto productDto = ProductDto.fromEntity(productDb);
    return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
  }

  @GetMapping
  public ResponseEntity<List<ProductDto>> findAll() {
    List<Product> products = service.findAll();
    List<ProductDto> productDtos = products.stream()
        .map(ProductDto::fromEntity)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(productDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
    Product product = service.findById(id);
    ProductDto productDto = ProductDto.fromEntity(product);
    return ResponseEntity.status(HttpStatus.OK).body(productDto);
  }

  @PutMapping
  public ResponseEntity<ProductDto> update(@RequestBody Product product) {
    Product productDb = service.update(product);
    ProductDto productDto = ProductDto.fromEntity(productDb);
    return ResponseEntity.status(HttpStatus.OK).body(productDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    String message = service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

  @PostMapping("/{productId}/detail")
  public ResponseEntity<ProdutctDetailDto> createDetail(@PathVariable Long productId,
      @RequestBody ProductDetail productDetail) {
    ProductDetail productDetailDb = service.createDetail(productId, productDetail);
    ProdutctDetailDto produtctDetailDto = ProdutctDetailDto.fromEntity(productDetailDb);
    return ResponseEntity.status(HttpStatus.OK).body(produtctDetailDto);
  }

  @GetMapping("/{productId}/detail")
  public ResponseEntity<ProdutctDetailDto> getDetail(@PathVariable Long productId) {
    ProductDetail productDetail = service.getProductDetail(productId);
    ProdutctDetailDto produtctDetailDto = ProdutctDetailDto.fromEntity(productDetail);
    return ResponseEntity.status(HttpStatus.OK).body(produtctDetailDto);
  }

  @PutMapping("/{productId}/detail")
  public ResponseEntity<ProdutctDetailDto> updateDetail(@PathVariable Long productId,
      @RequestBody ProductDetail productDetail) {
    ProductDetail productDetailDb = service.updateDetail(productId, productDetail);
    ProdutctDetailDto produtctDetailDto = ProdutctDetailDto.fromEntity(productDetailDb);
    return ResponseEntity.status(HttpStatus.OK).body(produtctDetailDto);
  }

  @DeleteMapping("/{productId}/detail")
  public ResponseEntity<ProdutctDetailDto> deleteDetail(@PathVariable Long productId) {
    ProductDetail productDetail = service.deleteDetail(productId);
    ProdutctDetailDto produtctDetailDto = ProdutctDetailDto.fromEntity(productDetail);
    return ResponseEntity.status(HttpStatus.OK).body(produtctDetailDto);
  }

  @PutMapping("/{productId}/brand/{brandId}")
  public ResponseEntity<ProductDto> updateProductBrand(@PathVariable Long productId,
      @PathVariable Long brandId) {
    Product product = service.findById(productId);
    Brand brand = brandService.findById(brandId);
    product.setBrand(brand);
    Product productDb = service.update(product);
    ProductDto productDto = ProductDto.fromEntity(productDb);
    return ResponseEntity.status(HttpStatus.OK).body(productDto);
  }

  @DeleteMapping("/{productId}/brand/{brandId}")
  public ResponseEntity<ProductDto> deleteProductBrand(@PathVariable Long productId,
      @PathVariable Long brandId) {
    Product product = service.findById(productId);
    product.setBrand(null);
    Product productDb = service.update(product);
    ProductDto productDto = ProductDto.fromEntity(productDb);
    return ResponseEntity.status(HttpStatus.OK).body(productDto);
  }
}
