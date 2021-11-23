package com.avis.qa.contract_provider.controllers;

import com.avis.qa.contract_provider.products.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponse {
  private final List<Product> products;
}
