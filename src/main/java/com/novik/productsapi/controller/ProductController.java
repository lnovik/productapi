package com.novik.productsapi.controller;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.dto.response.MessageResponseDTO;
import com.novik.productsapi.exception.ProductNotFoundException;
import com.novik.productsapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> listAll() {
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateProductById(@PathVariable Long id, @RequestBody @Valid  ProductDTO productDTO) throws ProductNotFoundException {
        return productService.updateById(id, productDTO);
    }


}
