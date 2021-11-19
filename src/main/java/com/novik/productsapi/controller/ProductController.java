package com.novik.productsapi.controller;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.dto.response.MessageResponseDTO;
import com.novik.productsapi.entity.Product;
import com.novik.productsapi.exception.ProductNotFoundException;
import com.novik.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }


}
