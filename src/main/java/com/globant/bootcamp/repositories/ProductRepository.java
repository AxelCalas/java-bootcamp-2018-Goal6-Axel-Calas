package com.globant.bootcamp.repositories;

import com.globant.bootcamp.objects.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
