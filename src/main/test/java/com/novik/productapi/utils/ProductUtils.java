package com.novik.productapi.utils;

import com.novik.productsapi.dto.request.ProductDTO;
import com.novik.productsapi.entity.Product;
import com.novik.productsapi.enums.Inventory;

import java.time.LocalDate;
import java.util.Collections;

public class ProductUtils {

    private static final String NAME = "Caixa de som";
    private static final String BRAND = "JBL";
    private static  final String BATCH =  "#001";
    private static final int AMOUNT = 15;
    private static final double WEIGTH = 0.9;
    private static final double UNIT_VALUE = 299.00;
    private static final long PRODUCT_ID = 1L;
    private static final Inventory INVENTORY = Inventory.AVAILABLE;

    public static final LocalDate MATURITY_DATE = LocalDate.of(2010,10,11);

    public static ProductDTO createFakeDTO(){
        return ProductDTO.builder()
                .name(NAME)
                .brand(BRAND)
                .batch(BATCH)
                .amount(AMOUNT)
                .weight(WEIGTH)
                .unitValue(UNIT_VALUE)
                .maturityDate("11-10-2010")
                .statusInventory(INVENTORY)
                .storesList(Collections.singletonList(StoreUtils.createFakeDTO()))
                .build();
    }

    public static Product createFakeEntity(){
        return Product.builder()
                .id(PRODUCT_ID)
                .name(NAME)
                .brand(BRAND)
                .batch(BATCH)
                .amount(AMOUNT)
                .weight(WEIGTH)
                .unitValue(UNIT_VALUE)
                .maturityDate(MATURITY_DATE)
                .statusInventory(INVENTORY)
                .storesList(Collections.singletonList(StoreUtils.createFakeEntity()))
                .build();

    }
}
