package com.github.gopalakrrish.springstore.jpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private  String name;
}
