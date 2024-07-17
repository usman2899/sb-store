package com.example.store;

import com.example.store.entities.Product;
import com.example.store.models.CreateProductRequest;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ControllerLayer {
  final Logger logger = LoggerFactory.getLogger(ControllerLayer.class);

  @Autowired ServiceLayer serviceLayer;

  @GetMapping("/product/{id}")
  ResponseEntity<Product> getProduct(@PathVariable Long id) {
    Optional<Product> optionalProduct = serviceLayer.getProductService(id);
    if (optionalProduct.isPresent()) {
      return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/product")
  ResponseEntity<List<Product>> getAllProducts() {
    List<Product> productList = serviceLayer.getAllProductsService();
    return new ResponseEntity<>(productList, HttpStatus.OK);
  }

  @PostMapping("/product")
  ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest createRequest) {
    Product product = serviceLayer.createProductService(createRequest);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @DeleteMapping("/product/{id}")
  ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
    Optional<Product> optionalProduct = serviceLayer.deleteProductService(id);
    if (optionalProduct.isPresent()) {
      return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
