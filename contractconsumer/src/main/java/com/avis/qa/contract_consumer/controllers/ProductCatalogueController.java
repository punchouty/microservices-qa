package com.avis.qa.contract_consumer.controllers;


import com.avis.qa.contract_consumer.clients.ProductServiceClient;
import com.avis.qa.contract_consumer.models.ProductCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductCatalogueController {
  @Autowired
  private ProductServiceClient productServiceClient;

  @GetMapping("/catalogue")
  public String catalogue(Model model) {
    ProductCatalogue catalogue = new ProductCatalogue("Default Catalogue", productServiceClient.fetchProducts().getProducts());
    model.addAttribute("catalogue", catalogue);
    return "catalogue";
  }

  @GetMapping("/catalogue/{id}")
  public String catalogue(@PathVariable("id") Long id, Model model) {
    model.addAttribute("product", productServiceClient.getProductById(id));
    return "details";
  }
}
