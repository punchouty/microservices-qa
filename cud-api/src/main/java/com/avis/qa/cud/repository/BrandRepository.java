package com.avis.qa.cud.repository;

import com.avis.qa.cud.domain.Brand;
import com.avis.qa.cud.domain.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Long> {

    List<Brand> findByName(@Param("name") String name);
}
