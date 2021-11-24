package com.novik.productapi.utils;

import com.novik.productsapi.dto.request.StoreDTO;
import com.novik.productsapi.entity.Store;

public class StoreUtils{

    private static final String NAME_STORE = "Americanas";
    private static final String DISTRICT = "São Bras";
    private static final String ZIP_CODE = "111-11";
    private static final long STORE_ID = 1L;

    public static StoreDTO createFakeDTO(){
        return StoreDTO.builder()
                .nameStore(NAME_STORE)
                .district(DISTRICT)
                .zipCode(ZIP_CODE)
                .build();
    }

    public static Store createFakeEntity(){
        return Store.builder()
                .id(STORE_ID)
                .nameStore(NAME_STORE)
                .district(DISTRICT)
                .zipCode(ZIP_CODE)
                .build();
    }





}
