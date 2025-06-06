package com.learning2code.spring_boot_ecommerce.dao;

import com.learning2code.spring_boot_ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
}
