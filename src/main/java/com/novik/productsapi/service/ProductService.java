package com.novik.productsapi.service;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.dto.response.MessageResponseDTO;
import com.novik.productsapi.entity.Product;
import com.novik.productsapi.mapper.ProductMapper;
import com.novik.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public MessageResponseDTO createProduct(ProductDTO productDTO) {
        Product productToSave = productMapper.toModel(productDTO);
        Product savedProduct = productRepository.save(productToSave);
        return MessageResponseDTO.builder()
                .message("Product created with ID:" + savedProduct.getId())
                .build();
    }


}