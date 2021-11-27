package com.novik.productsapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Inventory {

    OUTOFSTOCK("OUTOFSTOCK"),
    AVAILABLE("AVAILABLE"),
    CLOSEDSTOCK("CLOSEDSTOCK"),
    EXPIRED("EXPIRED");

    private final String description;

}
