package com.novik.productapi.service;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.dto.response.MessageResponseDTO;
import com.novik.productsapi.entity.Product;
import com.novik.productsapi.repository.ProductRepository;
import com.novik.productsapi.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.novik.productapi.utils.ProductUtils.createFakeDTO;
import static com.novik.productapi.utils.ProductUtils.createFakeEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGivenProductDTOThenReturnSavedMessage() {
        ProductDTO productDTO = createFakeDTO();
        Product expectedSavedProduct = createFakeEntity();

        when(productRepository.save(any(Product.class))).thenReturn(expectedSavedProduct);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedProduct.getId());
        MessageResponseDTO sucessMessage = productService.createProduct(productDTO);

        Assertions.assertEquals(expectedSuccessMessage, sucessMessage);

    }
    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Product update with ID: " + id)
                .build();
    }
}
