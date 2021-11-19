package com.novik.productsapi.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String nameStore;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String district;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String zipCode;



}
