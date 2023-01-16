package com.example.demo.restapijvs.product.controller;

import com.example.demo.restapijvs.product.model.ProductRequestModel;
import com.example.demo.restapijvs.product.model.ProductResponseModel;
import com.example.demo.restapijvs.product.service.ProductService;
import com.example.demo.restapijvs.user.model.UserRequestModel;
import com.example.demo.restapijvs.user.service.UserService;
import com.example.demo.restapijvs.utils.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class ProductController {
    @Autowired(required = false)
    ProductService productService;

    @GetMapping("/v1/products")
    public ResponseEntity<ResponseApi> getUsers() {
        log.info(" --- [LOG] GET/v1/products is called");
        var result = productService.getProducts();
        return result;
    }

    @GetMapping("/v1/products/{productId}")
    public ResponseEntity<ResponseApi> getUserById(@PathVariable Integer productId) {
        log.info(" --- [LOG] GET/v1/products/{productId} is called");
        var result = productService.getProductById(productId);
        return result;
    }

    @PostMapping("/v1/products")
    public ResponseEntity<ResponseApi> addUser(@RequestBody ProductRequestModel request) {
        log.info(" --- [LOG] POST/v1/products is called");
        var result = productService.addProduct(request);
        return result;
    }

    @DeleteMapping("/v1/products/{productId}")
    public ResponseEntity<ResponseApi> deleteUser(@PathVariable Integer productId) {
        log.info(" --- [LOG] DELETE/v1/products/{productId} is called");
        var result = productService.deleteProduct(productId);
        return result;
    }

    @PutMapping("/v1/products")
    public ResponseEntity<ResponseApi> updateProduct(@RequestBody ProductRequestModel request) {
        log.info(" --- [LOG] PUT/v1/products is called");
        var result = productService.updateProduct(request);
        return result;
    }
}
