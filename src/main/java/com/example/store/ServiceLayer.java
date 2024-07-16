package com.example.store;

import com.example.store.entities.Product;
import com.example.store.models.CreateProductRequest;
import com.example.store.repos.ProductRepo;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
  final Logger logger = LoggerFactory.getLogger(ServiceLayer.class);

  @Autowired ProductRepo productRepo;

  Optional<Product> getProductService(Long id) {
    logger.info("Get product request received: {}", id);
    Optional<Product> optionalProduct = productRepo.findById(id);
    return optionalProduct;
  }

  Optional<Product> deleteProductService(Long id) {
    logger.info("Delete product request received: {}", id);
    Optional<Product> optionalProduct = productRepo.findById(id);
    if (optionalProduct.isPresent()) {
      productRepo.delete(optionalProduct.get());
    }
    return optionalProduct;
  }

  List<Product> getAllProductsService() {
    logger.info("Get all products request received");
    List<Product> productList = productRepo.findAll();
    return productList;
  }

  Product createProductService(CreateProductRequest createRequest) {
    logger.info("Create product request received: {}", createRequest.getName());
    Product product = new Product(createRequest);
    product = productRepo.save(product);
    return product;
  }
}
