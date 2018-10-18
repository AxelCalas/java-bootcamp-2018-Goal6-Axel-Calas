package com.globant.bootcamp.repositories;

import com.globant.bootcamp.objects.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
