package com.novik.productsapi.dto.request;

import com.novik.productsapi.enums.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

   private Long id;

    @NotEmpty
    @Size(min = 2, max = 25)
    private String name;

    @NotEmpty
    @Size(min =2, max = 10)
    private String brand;

    @NotEmpty
    @Size(max = 100)
    private String batch;

    @NotNull
    private int amount;

    @NotNull
    private double weight;

    @NotNull
    private double unitValue;

    @NotEmpty
    private String maturityDate;

    @Enumerated(EnumType.STRING)
    private Inventory statusInventory;

    @Valid
    @NotEmpty
    private List<StoreDTO> storesList;


}


