package com.avis.qa.contract_consumer.clients;


import com.avis.qa.contract_consumer.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductServiceResponse {
  private List<Product> products;
}
