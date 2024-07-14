package com.example.store;

import com.example.store.entities.Product;
import com.example.store.models.CreateProductRequest;
import com.example.store.repos.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceLayer {
  final Logger logger = LoggerFactory.getLogger(ServiceLayer.class);

  @Autowired
  ProductRepo productRepo;

  Optional<Product> getProductService(Long id) {
    logger.info("Get product request received: {}", id);
    Optional<Product> optionalProduct = productRepo.findById(id);
    return optionalProduct;
  }

  Optional<Product> getAllProductsService() {
    logger.info("Get all products request received");
    Optional<Product> optionalProduct = productRepo.findById(id);
    return optionalProduct;
  }

  Product createProductService(CreateProductRequest createRequest) {
    logger.info("Create product request received: {}", createRequest.getName());
    Product product = new Product(createRequest);
    product = productRepo.save(product);
    return product;
  }
}
