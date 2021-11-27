package com.novik.productsapi.service;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.dto.response.MessageResponseDTO;
import com.novik.productsapi.entity.Product;
import com.novik.productsapi.exception.ProductNotFoundException;
import com.novik.productsapi.mapper.ProductMapper;
import com.novik.productsapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;


    public MessageResponseDTO createProduct(ProductDTO productDTO) {
        Product productToSave = productMapper.toModel(productDTO);
        Product savedProduct = productRepository.save(productToSave);
        return createMessageResponse(savedProduct.getId(), " Product update with ID: ");
    }

    public List<ProductDTO> listAll() {
        List<Product> allProduct = productRepository.findAll();
        return allProduct.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        Product product = verifyIfExists(id);
        return productMapper.toDTO(product);

    }

    public void deleteById(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, ProductDTO productDTO) throws ProductNotFoundException {
        verifyIfExists(id);
        Product productToSave = productMapper.toModel(productDTO);
        Product updateProduct = productRepository.save(productToSave);
        return createMessageResponse(updateProduct.getId(), " Product update with ID: ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


}

