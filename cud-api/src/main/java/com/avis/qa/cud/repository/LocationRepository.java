package com.avis.qa.cud.repository;

import com.avis.qa.cud.domain.Brand;
import com.avis.qa.cud.domain.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

    List<Location> findByName(@Param("name") String name);
}
