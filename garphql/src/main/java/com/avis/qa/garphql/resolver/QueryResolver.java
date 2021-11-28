package com.avis.qa.garphql.resolver;

import com.avis.qa.garphql.domain.Brand;
import com.avis.qa.garphql.dto.BrandDto;
import com.avis.qa.garphql.repository.BrandRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final BrandRepository brandRepository;

    public QueryResolver(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /*
    query {
      hello
    }
     */
    public String hello() {
        return "Hello from Graphql";
    }

    /*
    query {
      greeting(firstName: "Rajan", lastName: "Punchouty")
    }
     */
    public String greeting(String firstName, String lastName) {
        return String.format("Hello %s %s", firstName, lastName);
    }

    /*
    query {
      brand(idString : "1") {
        name
        code
      }
    }
     */
    public BrandDto getBrand(String idString) {
        Long id = Long.valueOf(idString);
        Optional<Brand> byId = brandRepository.findById(id);
        if(byId.isPresent()) {
            Brand brand = byId.get();
            return BrandDto.builder().id(brand.getId()).name(brand.getName()). code(brand.getCode()).build();
        }
        else {
         throw new RuntimeException("Not found");
        }
    }

    /*
    query {
      brand {
        name
        code
      }
    }
     */
    public List<BrandDto> getBrand() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> BrandDto.builder().id(brand.getId()).name(brand.getName()). code(brand.getCode()).build()).collect(Collectors.toList());
    }
}
