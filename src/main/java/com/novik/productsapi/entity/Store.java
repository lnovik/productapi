package com.novik.productsapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameStore;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String zipCode;


}
