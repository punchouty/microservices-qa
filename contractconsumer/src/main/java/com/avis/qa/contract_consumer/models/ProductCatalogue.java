package com.avis.qa.contract_consumer.models;

import lombok.Data;

import java.util.List;

@Data
public class ProductCatalogue {
  private final String name;
  private final List<Product> products;
}
