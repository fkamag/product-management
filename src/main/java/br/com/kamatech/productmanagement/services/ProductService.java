package br.com.kamatech.productmanagement.services;

import br.com.kamatech.productmanagement.entities.Product;
import br.com.kamatech.productmanagement.entities.ProductDetail;
import br.com.kamatech.productmanagement.exceptions.ProductDetailNotFoundException;
import br.com.kamatech.productmanagement.exceptions.ProductNotFoundException;
import br.com.kamatech.productmanagement.repositories.ProductDetailRepository;
import br.com.kamatech.productmanagement.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;
  @Autowired
  private ProductDetailRepository detailRepository;

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

  public ProductDetail createDetail(Long productId, ProductDetail productDetail) {
    Product product = findById(productId);
    productDetail.setProduct(product);
    productDetail.setId(productId);
    return detailRepository.save(productDetail);
  }

  public ProductDetail getProductDetail(Long productId) {
    Product product = findById(productId);
    ProductDetail productDetail = product.getProductDetail();
    if (productDetail == null) {
      throw new ProductDetailNotFoundException();
    }
    return productDetail;
  }

  public ProductDetail updateDetail(Long productId, ProductDetail productDetail) {
    ProductDetail productDetailDb = getProductDetail(productId);
    productDetailDb.setAvailableStock(productDetail.getAvailableStock());
    productDetailDb.setUnitPrice(productDetail.getUnitPrice());

    return detailRepository.save(productDetailDb);
  }

  public ProductDetail deleteDetail(Long productId) {
    Product product = findById(productId);
    ProductDetail productDetail = product.getProductDetail();
    if (productDetail == null) {
      throw new ProductDetailNotFoundException();
    }
    product.setProductDetail(null);
    productDetail.setProduct(null);
    detailRepository.delete(productDetail);

    return productDetail;
  }

}
