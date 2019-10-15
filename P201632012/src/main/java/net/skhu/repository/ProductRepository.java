package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}

