package br.com.kamatech.productmanagement.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
  private ProductDetail productDetail;
  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;
//  private List<Category> categories = new ArrayList<>();

  public Product() {}

  public Product(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDetail getProductDetail() {
    return productDetail;
  }

  public void setProductDetail(ProductDetail productDetail) {
    this.productDetail = productDetail;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

//  public List<Category> getCategories() {
//    return categories;
//  }

//  public void setCategories(List<Category> categories) {
//    this.categories = categories;
//  }

}
