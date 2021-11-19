package com.novik.productsapi.mapper;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    @Mapping(target = "maturityDate", source = "maturityDate", dateFormat = "dd-MM-yyyy")
    Product toModel(ProductDTO productDTO);

    ProductDTO toDTO(Product product);


}
